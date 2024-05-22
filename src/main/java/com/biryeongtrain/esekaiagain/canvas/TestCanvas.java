package com.biryeongtrain.esekaiagain.canvas;

import eu.pb4.mapcanvas.api.core.CanvasColor;
import eu.pb4.mapcanvas.api.core.CanvasImage;
import eu.pb4.mapcanvas.api.core.DrawableCanvas;
import eu.pb4.mapcanvas.api.core.PlayerCanvas;
import eu.pb4.mapcanvas.api.utils.CanvasUtils;
import eu.pb4.mapcanvas.api.utils.VirtualDisplay;
import eu.pb4.mapcanvas.impl.BaseMapCanvas;
import eu.pb4.mapcanvas.impl.view.SubView;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TestCanvas {
    private PlayerCanvas canvas;
    private VirtualDisplay display;
    private ServerPlayerEntity player;
    private CanvasImage backgroundCanvas;
    private CanvasColor color = CanvasColor.TERRACOTTA_BLACK_LOW;

    public TestCanvas(ServerPlayerEntity player) {
        this.backgroundCanvas = new CanvasImage(128, 128);
        this.canvas = DrawableCanvas.create(6, 4);
        display = VirtualDisplay.builder(this.canvas, player.getSteppingPos().up(3), Direction.byId(5))
                .rotation(BlockRotation.NONE)
                .glowing()
                .invisible()
                .build();
        this.player = player;
        test();
    }

    public void test() {
        CanvasUtils.fill(canvas, 0, 0, canvas.getWidth(), canvas.getHeight(), color);
        CanvasUtils.clear(display.getCanvas(), CanvasColor.BLACK_LOW);
        var duckImage = getImage("https://i.imgur.com/AZGRYkb.png");
        duckImage.thenAccept(image -> {
            if (image != null) {

                CanvasUtils.draw(canvas, 0, 0, CanvasImage.from(image));
                display.getCanvas().sendUpdates();
                display.addPlayer(player);
                display.getCanvas().addPlayer(player);
            }
        });
    }


    private CompletableFuture<BufferedImage> getImage(String input) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (isValid(input)) {
                    URL url = new URL(input);
                    URLConnection connection = url.openConnection();
                    connection.setRequestProperty("User-Agent", "ESekai");
                    connection.connect();
                    return ImageIO.read(connection.getInputStream());
                }
             } catch (Throwable e) {
                return null;
            }
            return null;
        });
    }

    private static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

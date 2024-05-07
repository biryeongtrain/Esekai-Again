package com.biryeongtrain.esekaiagain.canvas;

import eu.pb4.mapcanvas.api.core.CanvasImage;
import eu.pb4.mapcanvas.api.core.DrawableCanvas;
import eu.pb4.mapcanvas.api.core.PlayerCanvas;
import eu.pb4.mapcanvas.api.utils.CanvasUtils;
import eu.pb4.mapcanvas.api.utils.VirtualDisplay;
import eu.pb4.mapcanvas.impl.BaseMapCanvas;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TestCanvas {
    private PlayerCanvas canvas = DrawableCanvas.create();
    private VirtualDisplay display;
    private ServerPlayerEntity player;

    public TestCanvas(ServerPlayerEntity player) {
        display = VirtualDisplay.builder()
                .canvas(canvas)
                .pos(player.getBlockPos())
                .direction(Direction.NORTH)
                .invisible(true)
                .build();
        this.player = player;
        test();
        display.addPlayer(player);
        canvas.addPlayer(player);
    }

    public void test() {
        CanvasImage canvasImage;
        var img = getImage("https://i.imgur.com/AZGRYkb.png")
                .orTimeout(60, TimeUnit.SECONDS)
                .handleAsync((image, ex) -> {
                    if (image == null) {
                        return null;
                    }
                    CanvasUtils.draw(canvas, 0, 0, CanvasImage.from(image));
                    return null;
                }, player.getServer());


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

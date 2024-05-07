package com.biryeongtrain.esekaiagain.impl.commands;

import com.biryeongtrain.esekaiagain.canvas.TestCanvas;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;

public class TestCanvasCommand {
    public static int testCanvas(CommandContext<ServerCommandSource> ctx) {
        var player = ctx.getSource().getPlayer();
        var canvas = new TestCanvas(player);

        return 1;
    }
}

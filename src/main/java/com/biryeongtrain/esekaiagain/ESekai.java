package com.biryeongtrain.esekaiagain;

import com.biryeongtrain.esekaiagain.commands.TestCanvasCommand;
import com.biryeongtrain.esekaiagain.registry.ESekaiDataRegistry;
import com.biryeongtrain.esekaiagain.registry.ESekaiItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.literal;

public class ESekai implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Esekai");
    public static final String MOD_ID = "esekai";
    public static int MAX_LEVEL = 100;
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("test_canvas")
                    .executes(TestCanvasCommand::testCanvas)
            );
        });

        ESekaiDataRegistry.init();
        ESekaiItemRegistry.init();
    }
}

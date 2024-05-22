package com.biryeongtrain.esekaiagain.stat;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class SimpleStat extends AbstractStat {

    public SimpleStat(@NotNull Identifier id) {
        super(id, (entity, value) -> {});
    }

    @Override
    public boolean hasChangeEvent() {
        return false;
    }
}

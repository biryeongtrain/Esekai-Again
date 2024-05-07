package com.biryeongtrain.esekaiagain.impl.stat;

import com.biryeongtrain.esekaiagain.entity.StatHolder;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class StimulatingStat extends AbstractStat {

    public StimulatingStat(@NotNull Identifier id, BiConsumer<StatHolder, Float> entityConsumer) {
        super(id, entityConsumer);
    }

    @Override
    public boolean hasChangeEvent() {
        return true;
    }
}

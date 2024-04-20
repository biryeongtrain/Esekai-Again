package com.biryeongtrain.esekaiagain.impl.stat;

import com.biryeongtrain.esekaiagain.entity.StatHolder;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public interface Stat {
    Identifier getId();
    BiConsumer<StatHolder, Float> getConsumer();
    void onChanged(StatHolder entity, float value);
    boolean hasChangeEvent();
}


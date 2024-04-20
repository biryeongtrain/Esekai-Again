package com.biryeongtrain.esekaiagain.impl.stat;

import com.biryeongtrain.esekaiagain.entity.StatHolder;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SimpleStat implements Stat {
    private final Identifier id;
    private final BiConsumer<StatHolder, Float> entityConsumer = (entity, value) -> {};

    public SimpleStat(@NotNull Identifier id) {
        this.id = id;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    @Nullable
    public BiConsumer<StatHolder, Float> getConsumer() {
        return this.entityConsumer;
    }

    @Override
    public void onChanged(StatHolder entity, float value) {
        entityConsumer.accept(entity, value);
    }

    @Override
    public boolean hasChangeEvent() {
        return true;
    }
}

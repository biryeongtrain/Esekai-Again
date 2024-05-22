package com.biryeongtrain.esekaiagain.stat;

import com.biryeongtrain.esekaiagain.entity.StatHolder;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public abstract class AbstractStat implements Stat {
    private final Identifier id;
    private final BiConsumer<StatHolder, Float> entityConsumer;

    public AbstractStat(@NotNull Identifier id, BiConsumer<StatHolder, Float> entityConsumer) {
        this.id = id;
        this.entityConsumer = entityConsumer;
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

}

package com.biryeongtrain.esekaiagain.impl.stat;

import net.minecraft.util.Identifier;

import java.util.EnumSet;
import java.util.Set;

public class StatModifier implements Modifier {
    private final Identifier id;
    private final Set<Stat> affectStats;
    private final EnumSet<StatType> tags;

    public StatModifier(Identifier id, Set<Stat> affectStats, EnumSet<StatType> tags) {
        this.id = id;
        this.affectStats = affectStats;
        this.tags = tags;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public Set<Stat> getAffectStats() {
        return this.affectStats;
    }

    @Override
    public EnumSet<StatType> getStatTypes() {
        return this.tags;
    }
}

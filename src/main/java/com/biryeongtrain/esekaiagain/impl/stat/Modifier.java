package com.biryeongtrain.esekaiagain.impl.stat;

import net.minecraft.util.Identifier;

import java.util.EnumSet;
import java.util.Set;

public interface Modifier {
    Identifier getId();
    Set<Stat> getAffectStats();
    EnumSet<StatType> getStatTypes();

}

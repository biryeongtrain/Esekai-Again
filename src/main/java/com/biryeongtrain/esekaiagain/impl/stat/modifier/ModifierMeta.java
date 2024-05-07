package com.biryeongtrain.esekaiagain.impl.stat.modifier;

import com.biryeongtrain.esekaiagain.slot.SlotType;

import java.util.Set;

public record ModifierMeta(int minLevel, int maxLevel, Set<SlotType> slots, Set<ModifierStatInstance> instances) {
}

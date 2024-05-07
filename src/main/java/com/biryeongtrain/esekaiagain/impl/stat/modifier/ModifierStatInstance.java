package com.biryeongtrain.esekaiagain.impl.stat.modifier;

import com.biryeongtrain.esekaiagain.impl.stat.Stat;
import com.biryeongtrain.esekaiagain.impl.stat.StatIncreaseType;

public record ModifierStatInstance(float min, float max, StatIncreaseType type, Stat stat) {
}

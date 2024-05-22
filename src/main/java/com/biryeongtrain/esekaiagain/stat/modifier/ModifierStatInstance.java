package com.biryeongtrain.esekaiagain.stat.modifier;

import com.biryeongtrain.esekaiagain.stat.Stat;
import com.biryeongtrain.esekaiagain.stat.StatIncreaseType;

public record ModifierStatInstance(float min, float max, StatIncreaseType type, Stat stat) {
}

package com.biryeongtrain.esekaiagain.entity;

import com.biryeongtrain.esekaiagain.stat.Stat;
import com.biryeongtrain.esekaiagain.stat.StatIncreaseType;
import net.minecraft.util.Identifier;

public interface StatHolder {
    float getStat(Stat stat);
    void addStat(Identifier id, Stat stat, StatIncreaseType type, float value, boolean replace);

}

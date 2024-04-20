package com.biryeongtrain.esekaiagain.util;

import com.biryeongtrain.esekaiagain.ESekai;
import com.biryeongtrain.esekaiagain.impl.stat.SimpleStat;
import net.minecraft.util.Identifier;

public class StatUtil {
    public static SimpleStat UNKNOWN_SPELL = new SimpleStat(
            new Identifier(ESekai.MOD_ID, "stat_unknown"), (entity) -> {});

}

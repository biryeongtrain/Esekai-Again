package com.biryeongtrain.esekaiagain.impl.stat;

import static com.biryeongtrain.esekaiagain.util.IdentifierUtil.toId;

public class Stats {
    // 1st stat. this will not affect other stat.
    public static Stat HEALTH = new SimpleStat(toId("health"));
    public static Stat MANA = new SimpleStat(toId("mana"));
    public static Stat ENERGY_SHIELD = new SimpleStat(toId("energy_shield"));
    public static Stat ARMOUR = new SimpleStat(toId("armour"));
    public static Stat DODGE =  new SimpleStat(toId("dodge"));

    // 2nd stat. this affects 1st stats.
    public static Stat DEX = new SimpleStat(toId("dex"), (entity) -> {

    });
}

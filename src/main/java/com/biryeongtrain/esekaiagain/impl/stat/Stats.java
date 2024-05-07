package com.biryeongtrain.esekaiagain.impl.stat;

import static com.biryeongtrain.esekaiagain.util.IdentifierUtil.toId;

public class Stats {
    // 1st stat. this will not affect other stat.
    public static Stat HEALTH = new SimpleStat(toId("health"));
    public static Stat MANA = new SimpleStat(toId("mana"));
    public static Stat ENERGY_SHIELD = new SimpleStat(toId("energy_shield"));
    public static Stat ARMOUR = new SimpleStat(toId("armour"));
    public static Stat DODGE =  new SimpleStat(toId("dodge"));
    public static Stat CRIT_RATE = new SimpleStat(toId("crit_rate"));
    public static Stat CRIT_MULTIPLIER = new SimpleStat(toId("crit_multiplier"));
    // 2nd stat. this affects 1st stats.
    public static Stat DEX = new StimulatingStat(toId("dex"), (entity, value) -> {
        entity.addStat(toId("dex_bonus"), DODGE, StatIncreaseType.FLAT, 2 * value, true);
        entity.addStat(toId("dex_bonus"), CRIT_MULTIPLIER, StatIncreaseType.FLAT, (float) (0.05 * (value % 5)), true);
    });
    public static Stat INT = new StimulatingStat(toId("int"), (entity, value) -> {
        entity.addStat(toId("int_bonus"), MANA, StatIncreaseType.FLAT, 2 * value, true);
        entity.addStat(toId("int_bonus"), ENERGY_SHIELD, StatIncreaseType.INCREASE, 0.05f * value, true);
    });
    public static Stat STR =  new StimulatingStat(toId("str"),  (entity, value) -> {
        entity.addStat(toId("str_bonus"), HEALTH, StatIncreaseType.FLAT, 5 * value, true);
        entity.addStat(toId("str_bonus"), ARMOUR, StatIncreaseType.FLAT, 5 * value, true);
    });
}

package com.biryeongtrain.esekaiagain.entity;

public interface LeveledEntity {
    int getLevel();
    boolean increaseLevel();
    void setLevel(int level);
    boolean isMaxLevel();
    boolean isEnoughLevel(int level);
    boolean canLevelUp();
}

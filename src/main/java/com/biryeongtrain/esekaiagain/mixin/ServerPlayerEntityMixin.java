package com.biryeongtrain.esekaiagain.mixin;

import com.biryeongtrain.esekaiagain.ESekai;
import com.biryeongtrain.esekaiagain.player.ESekaiPlayer;
import com.biryeongtrain.esekaiagain.stat.Stat;
import com.biryeongtrain.esekaiagain.stat.StatIncreaseType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin implements ESekaiPlayer {
    private int esekai$level = 1;
    @Override
    public int getLevel() {
        return this.esekai$level;
    }

    @Override
    public boolean increaseLevel() {
        if (this.isMaxLevel()) {
            return false;
        }

        esekai$level++;
        return true;
    }

    @Override
    public void setLevel(int level) {
        this.esekai$level = level;
    }

    @Override
    public boolean isMaxLevel() {
        return this.esekai$level >= ESekai.MAX_LEVEL;
    }

    @Override
    public boolean isEnoughLevel(int level) {
        return this.esekai$level >= level;
    }

    @Override
    public boolean canLevelUp() {
        return this.isMaxLevel();
    }

    @Override
    public float getStat(Stat stat) {
        return 0;
    }

    @Override
    public void addStat(Identifier id, Stat stat, StatIncreaseType type, float value, boolean replace) {

    }
}

package com.biryeongtrain.esekaiagain.registry;

import com.biryeongtrain.esekaiagain.skill.SkillInfo;
import com.biryeongtrain.esekaiagain.util.IdentifierUtil;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.component.DataComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.UnaryOperator;

public class ESekaiDataRegistry {
    public static DataComponentType<Integer> SKILLSCROLL_MANA = register("skillscroll_mana", (builder) -> builder.codec(Codecs.NONNEGATIVE_INT).packetCodec(PacketCodecs.INTEGER));
    public static DataComponentType<Float> SKILL_DAMAGE = register("skill_damage", (builder) -> builder.codec(Codecs.POSITIVE_FLOAT).packetCodec(PacketCodecs.FLOAT));
    public static DataComponentType<Float> SKILL_COST = register("skill_cost", (builder) -> builder.codec(Codecs.POSITIVE_FLOAT).packetCodec(PacketCodecs.FLOAT));
    public static DataComponentType<Integer> SKILL_RANGE = register("skill_range", (builder) -> builder.codec(Codecs.rangedInt(0, 30)).packetCodec(PacketCodecs.INTEGER));
    public static DataComponentType<Integer> SKILL_SCROLL_LEVEL = register("skillscroll_level", (builder) -> builder.codec(Codecs.rangedInt(1, 100)).packetCodec(PacketCodecs.INTEGER));
//    public static DataComponentType<SkillInfo.TargetType> SKILL_TARGET_TYPE = register("target_type", (builder) -> builder.codec(Codecs.))


    public static <T> DataComponentType<T> register(String id, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {
        var data = (DataComponentType) Registry.register(Registries.DATA_COMPONENT_TYPE, IdentifierUtil.toId(id), ((DataComponentType.Builder) builderUnaryOperator.apply(DataComponentType.builder())).build());
        PolymerItemUtils.markAsPolymer(data);

        return data;
    }

    public static void init() {

    }
}

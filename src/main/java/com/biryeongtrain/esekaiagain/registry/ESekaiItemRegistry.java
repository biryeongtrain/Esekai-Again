package com.biryeongtrain.esekaiagain.registry;

import com.biryeongtrain.esekaiagain.item.SkillScrollItem;
import com.biryeongtrain.esekaiagain.util.IdentifierUtil;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.Contract;

public class ESekaiItemRegistry {
    public static Item SKILL_SCROLL = register(new SkillScrollItem(new Item.Settings().maxCount(8)), "skill_scroll");

    @Contract("_, !null -> _")
    public static Item register(Item item, String value) {
        Registry.register(Registries.ITEM, IdentifierUtil.toId(value), item);
        return item;
    }

    public static void init() {

    }
}

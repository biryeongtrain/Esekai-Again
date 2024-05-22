package com.biryeongtrain.esekaiagain.item;

import com.biryeongtrain.esekaiagain.player.ESekaiPlayer;
import com.biryeongtrain.esekaiagain.registry.ESekaiDataRegistry;
import com.biryeongtrain.esekaiagain.util.IdentifierUtil;
import eu.pb4.placeholders.api.parsers.TagParser;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SkillScrollItem extends Item implements PolymerItem {
    private final PolymerModelData model;

    public SkillScrollItem(Settings settings) {
        super(settings);
        this.model = PolymerResourcePackUtils.requestModel(Items.PAPER, IdentifierUtil.toId("item/skill_scroll"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.model.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.model.value();
    }

    public boolean canEnchantSkill(ItemStack itemStack) {
        if (itemStack.getItem() != this) {
            return false;
        }

        return itemStack.contains(ESekaiDataRegistry.SKILL_DAMAGE);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof ServerPlayerEntity player)) {
            return;
        }
        ESekaiPlayer eSekaiPlayer = (ESekaiPlayer) player;
        if (stack.contains(ESekaiDataRegistry.SKILL_SCROLL_LEVEL)) {
            stack.set(ESekaiDataRegistry.SKILL_SCROLL_LEVEL, eSekaiPlayer.getLevel());
            stack.set(ESekaiDataRegistry.SKILLSCROLL_MANA, eSekaiPlayer.getLevel() * 3 + 10);
        }
    }

    @Override
    public void modifyClientTooltip(List<Text> tooltip, ItemStack stack, @Nullable ServerPlayerEntity player) {
        if (stack.contains(ESekaiDataRegistry.SKILL_SCROLL_LEVEL)) {
            String color = "<white>";
            if (player != null) {
                ESekaiPlayer eSekaiPlayer = (ESekaiPlayer) player;
                color = eSekaiPlayer.getLevel() >= stack.get(ESekaiDataRegistry.SKILL_SCROLL_LEVEL) ? "<green>" : "<red>";
            }
            tooltip.add(TagParser.QUICK_TEXT_SAFE
                    .parseNode("Level :" + color + "%s".formatted(stack.get(ESekaiDataRegistry.SKILL_SCROLL_LEVEL) + color.replace("<", "</")))
                    .toText());
        }
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (user instanceof ServerPlayerEntity player) {
            player.sendMessage(Text.literal(String.valueOf(remainingUseTicks)));
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 20;
    }

    @Override
    public ItemStack getDefaultStack() {
        var stack = new ItemStack(this);
        stack.set(DataComponentTypes.MAX_STACK_SIZE, 8);

        return stack;
    }

}

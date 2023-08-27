package sc.legendofthecurse.item.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;



public class RingOfTheCurseItem extends TrinketItem {

    public RingOfTheCurseItem(Settings settings) {
        super(settings);
    }

    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return TrinketEnums.DropRule.KEEP;
    }
    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);

        stack.addHideFlag(ItemStack.TooltipSection.ADDITIONAL);

        Weared = true;

    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    public static boolean Weared = false;

    @Override
    public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return false;
    }



    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover1").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover2").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover3").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover4").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover5").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover6").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover7").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_hover8").formatted(Formatting.DARK_PURPLE));
        }else{
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_info").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.legendofthecurse.ringofthecurse_info1").formatted(Formatting.DARK_PURPLE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +10% movement speed
        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "legendofthecurse:armor", -0.3, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "legendofthecurse:attack_damage",-0.5,EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        return modifiers;
    }



}

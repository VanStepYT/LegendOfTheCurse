package sc.legendofthecurse.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import sc.legendofthecurse.LegendOfTheCurse;

public class ModItemGroup {

    public static final ItemGroup LEGEND_OF_THE_CURSE = FabricItemGroupBuilder.build(new Identifier(LegendOfTheCurse.MOD_ID, "legend_of_the_curse"),
            () -> new ItemStack(ModItems.RING_OF_THE_CURSE));
}

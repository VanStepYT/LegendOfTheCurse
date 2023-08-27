package sc.legendofthecurse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sc.legendofthecurse.LegendOfTheCurse;
import sc.legendofthecurse.item.custom.RingOfTheCurseItem;

public class ModItems {

    public static final Item RING_OF_THE_CURSE = registerItem("ring_of_the_curse",
            new RingOfTheCurseItem(new FabricItemSettings().group(ModItemGroup.LEGEND_OF_THE_CURSE).maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(LegendOfTheCurse.MOD_ID, name), item);
    }

    public static void registerModItems(){
        LegendOfTheCurse.LOGGER.info("Registering Mod Items for " + LegendOfTheCurse.MOD_ID);
    }
}

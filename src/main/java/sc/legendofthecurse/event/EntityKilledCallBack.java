package sc.legendofthecurse.event;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import sc.legendofthecurse.item.ModItems;

import java.util.Optional;


public interface EntityKilledCallBack {

    public static final Event<ServerLivingEntityEvents.AfterDeath> AFTER_DEATH = EventFactory.createArrayBacked(ServerLivingEntityEvents.AfterDeath.class, callbacks -> (entity, damageSource) -> {
        for (ServerLivingEntityEvents.AfterDeath callback : callbacks) {
            callback.afterDeath(entity, damageSource);
        }



        Entity entity1 = damageSource.getAttacker();

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity1);

        TrinketComponent tcomp = trinket.get();
        //if(tcomp.isEquipped(ModItems.RING_OF_THE_CURSE));




    });

}

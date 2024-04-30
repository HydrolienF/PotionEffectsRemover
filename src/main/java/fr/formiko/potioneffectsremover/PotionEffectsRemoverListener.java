package fr.formiko.potioneffectsremover;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Action;

public class PotionEffectsRemoverListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = org.bukkit.event.EventPriority.HIGH)
    public void onPotionEffectEvent(EntityPotionEffectEvent event) {
        if (isPotionEffectAddedOrChanged(event.getAction()) && isARemovedPotionEffectType(event) && isAValideEntity(event.getEntity())
                && isAValideCause(event.getCause())) {
            event.setCancelled(true);
        }
        PotionEffectsRemoverPlugin
                .log(event.getEntity().getName() + " had a potion effect removed ? " + event.getModifiedType().translationKey() + " "
                        + isPotionEffectAddedOrChanged(event.getAction()) + " " + isARemovedPotionEffectType(event) + " "
                        + isAValideEntity(event.getEntity()) + " " + isAValideCause(event.getCause()) + " => " + event.isCancelled());
    }

    private boolean isPotionEffectAddedOrChanged(Action action) { return action == Action.ADDED || action == Action.CHANGED; }
    private boolean isAValideEntity(Entity entity) {
        // If player check game mode
        if (entity instanceof Player player) {
            return !PotionEffectsRemoverPlugin.getInstance().getBypassGameModes().contains(player.getGameMode());
        } else { // If not player check that we accept entity
            return !PotionEffectsRemoverPlugin.getInstance().getConfig().getBoolean("affectOnlyPlayers", false);
        }
    }
    private boolean isAValideCause(EntityPotionEffectEvent.Cause cause) {
        return !PotionEffectsRemoverPlugin.getInstance().getBypassCauses().contains(cause);
    }
    private boolean isARemovedPotionEffectType(EntityPotionEffectEvent event) {
        return PotionEffectsRemoverPlugin.getInstance().getDisabledPotionEffects().contains(event.getModifiedType());
    }
}

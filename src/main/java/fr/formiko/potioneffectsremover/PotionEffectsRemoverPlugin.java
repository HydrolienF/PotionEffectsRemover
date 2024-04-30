package fr.formiko.potioneffectsremover;

import java.util.Collection;
import org.bstats.bukkit.Metrics;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import co.aikar.commands.PaperCommandManager;

public class PotionEffectsRemoverPlugin extends JavaPlugin {
    private Collection<PotionEffectType> disabledPotionEffects;
    private Collection<GameMode> bypassGameModes;
    private Collection<EntityPotionEffectEvent.Cause> bypassCauses;

    public static PotionEffectsRemoverPlugin getInstance() { return JavaPlugin.getPlugin(PotionEffectsRemoverPlugin.class); }

    @Override
    public void onEnable() {
        new Metrics(this, 21741);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PotionEffectsRemoverListener(), this);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new PotionEffectsRemoverCommand());
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        disabledPotionEffects = getConfig().getStringList("disabledPotionEffects").stream()
                .map(dpe -> Registry.POTION_EFFECT_TYPE.get(NamespacedKey.minecraft(dpe.toLowerCase()))).toList();
        bypassGameModes = getConfig().getStringList("bypassGameModes").stream().map(GameMode::valueOf).toList();
        bypassCauses = getConfig().getStringList("bypassCauses").stream().map(EntityPotionEffectEvent.Cause::valueOf).toList();
    }

    public Collection<PotionEffectType> getDisabledPotionEffects() { return disabledPotionEffects; }
    public Collection<GameMode> getBypassGameModes() { return bypassGameModes; }
    public Collection<EntityPotionEffectEvent.Cause> getBypassCauses() { return bypassCauses; }

    public static void log(String message) {
        if (getInstance().getConfig().getBoolean("debug", false))
            getInstance().getLogger().info(message);
    }
}

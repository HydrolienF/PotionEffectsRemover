package fr.formiko.potioneffectsremover;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.command.CommandSender;

@CommandAlias("potionEffectsRemover|per")
@CommandPermission("potioneffectsremover.admin")
public class PotionEffectsRemoverCommand extends BaseCommand {
    @Subcommand("reload")
    public void onReload(CommandSender sender) {
        PotionEffectsRemoverPlugin.getInstance().reloadConfig();
        sender.sendMessage("PotionEffectsRemover reloaded");
    }
}

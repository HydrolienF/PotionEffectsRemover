package fr.formiko.potioneffectsremover;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;

@CommandAlias("potionEffectsRemover|per")
@CommandPermission("potioneffectsremover.admin")
public class PotionEffectsRemoverCommand extends BaseCommand {
    @Subcommand("reload")
    public void onReload() { PotionEffectsRemoverPlugin.getInstance().reloadConfig(); }
}

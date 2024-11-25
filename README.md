[download]: https://img.shields.io/github/downloads/HydrolienF/PotionEffectsRemover/total
[downloadLink]: https://hangar.papermc.io/Hydrolien/PotionEffectsRemover
[discord-shield]: https://img.shields.io/discord/728592434577014825?label=discord
[discord-invite]: https://discord.gg/RPNbtRSFqG

[ ![download][] ][downloadLink]
[ ![discord-shield][] ][discord-invite]

[**Discord**](https://discord.gg/RPNbtRSFqG) | [**Hangar**](https://hangar.papermc.io/Hydrolien/PotionEffectsRemover) | [**Spigot**](https://www.spigotmc.org/resources/potioneffectsremover.116610/) | [**GitHub**](https://github.com/HydrolienF/PotionEffectsRemover)

# PotionEffectsRemover
Minecraft plugin to disable some potion effects.

Support **Paper** forks including **Folia** for version 1.20 to the last one. (See version compatibility in releases)
Older version than 1.20 won't be supported.

## Install
Download last version.
Place it in `plugins/` in your server files.
After 1st launch you can edit config in `plugins/PotionEffectsRemover/config.yml`


## Test
To test plugin you need Java 21+ to compile & package: `./gradlew assemble`. Plugin file will be in `build/libs/`.
Then you need an 1.20 Minecraft server with PaperMc or a fork to run it.


## Configurations

Edit `plugins/PotionEffectsRemover/config.yml`.

The only needed setting is `disabledPotionEffects` that determine witch potion effects will be disabled.

You can optionaly define some bypass, so player will ba able to have disabled potion effects.
Bypass can be a gamemode, for example all player in creative can have disabled potion effects.
Bypass can be a cause, for example if the potion is set by a command, then it's not disabled.

`affectOnlyPlayers` allow you to disable potion effects for player only or for all entities.


## Statistics
[![bStats Graph Data](https://bstats.org/signatures/bukkit/PotionEffectsRemover.svg)](https://bstats.org/plugin/bukkit/PotionEffectsRemover/21741)

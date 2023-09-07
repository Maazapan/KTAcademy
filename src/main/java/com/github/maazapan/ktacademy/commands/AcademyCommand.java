package com.github.maazapan.ktacademy.commands;

import com.github.maazapan.ktacademy.KTAcademy;
import com.github.maazapan.ktacademy.academy.manager.AcademyManager;
import com.github.maazapan.ktacademy.academy.villages.Village;
import com.github.maazapan.ktacademy.utils.file.FileManager;
import com.github.maazapan.ktacademy.utils.file.FileType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AcademyCommand implements CommandExecutor, TabCompleter {

    private final KTAcademy plugin;

    public AcademyCommand(KTAcademy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;

        AcademyManager manager = plugin.getAcademyManager();
        FileManager config = new FileManager(plugin);
        Player player = (Player) sender;

        if (!(args.length > 0)) {
            player.sendMessage(config.get("messages.help", FileType.CONFIG));
            return true;
        }

        switch (args[0].toLowerCase()) {
            /*
             + Create a new classroom at academy.
             - /academy create <academy> <day>
             */
            case "create": {
                if (!player.hasPermission("ktacademy.create")) {
                    player.sendMessage(config.get("messages.no-permission", FileType.CONFIG));
                    return true;
                }

                if (args.length < 2) {
                    player.sendMessage(config.get("messages.args-error-create", FileType.CONFIG));
                    return true;
                }

                String villageArg = args[1].toUpperCase();

                if (!Village.exists(villageArg)) {
                    player.sendMessage(config.get("messages.village-not-exists", FileType.CONFIG).replaceAll("%village%", villageArg));
                    return true;
                }

                try {
                    Village village = Village.valueOf(villageArg);
                    int day = Integer.parseInt(args[2]);

                    if (manager.isTakenDay(village, day)) {
                        player.sendMessage(config.get("messages.day-taken", FileType.CONFIG).replaceAll("%day%", String.valueOf(day)));
                        return true;
                    }

                    manager.createRoom(village, day);
                    player.sendMessage(config.get("messages.create-success", FileType.CONFIG)
                            .replaceAll("%day%", String.valueOf(day))
                            .replaceAll("%village%", villageArg));

                } catch (NumberFormatException e) {
                    player.sendMessage(config.get("messages.number-format-error", FileType.CONFIG));
                    return true;
                }
            }
            break;

            /*
             + Delete a classroom at academy.
             - /academy delete <academy> <day>
             */
            case "delete": {

            }
            break;

            default:
                player.sendMessage(config.get("messages.help", FileType.CONFIG));
                break;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender.isOp() || sender.hasPermission("ktacademy.admin"))) return null;
        List<String> completions = Arrays.asList("create", "delete");
        List<String> villages = Arrays.stream(Village.values())
                .map(Village::toString)
                .collect(Collectors.toList());

        if (args.length == 1) return completions;
        if (args.length > 2) {
            if (args[0].equalsIgnoreCase("create")) return villages;
        }
        return null;
    }
}

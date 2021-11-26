package com.github.jasgo.pump;

import com.github.jasgo.pump.event.KeyListener;
import com.github.jasgo.pump.game.KeyIcon;
import com.github.jasgo.pump.game.PumpGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Pump extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new KeyListener(), this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("pump")) {
            if (args.length == 2) {
                Player player = (Player) sender;
                ArmorStand as = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
                as.addPassenger(player);
                int size = Integer.parseInt(args[0]);
                int length = Integer.parseInt(args[1]);
                List<KeyIcon> list = new ArrayList<>();
                for (int i = 1; i <= size; i++) {
                    Random r = new Random();
                    int random = r.nextInt(5);
                    if (random == 0) {
                        list.add(KeyIcon.UP);
                    } else if (random == 1) {
                        list.add(KeyIcon.DOWN);
                    } else if (random == 2) {
                        list.add(KeyIcon.LEFT);
                    } else if (random == 3) {
                        list.add(KeyIcon.RIGHT);
                    } else {
                        list.add(KeyIcon.CENTER);
                    }
                }
                PumpGame game = new PumpGame(list, (Player) sender);
                game.start(length);
            }
        }
        return false;
    }
}

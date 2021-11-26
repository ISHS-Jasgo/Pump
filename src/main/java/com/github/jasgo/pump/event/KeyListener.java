package com.github.jasgo.pump.event;

import com.github.jasgo.pump.game.KeyIcon;
import com.github.jasgo.pump.game.PumpGame;
import com.github.jasgo.pump.game.PumpGameManager;
import com.github.jasgo.vehicle.VehicleSteerEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class KeyListener implements Listener {
    @EventHandler
    public void onKeyPress(VehicleSteerEvent event) {
        if (PumpGameManager.hasGame(event.getPlayer())) {
            PumpGame game = PumpGameManager.getGame(event.getPlayer());
            Player player = event.getPlayer();
            if (event.isForward()) {
                if (game.getCurrent().equals(KeyIcon.UP)) {
                    game.addPoint(1);
                    player.showTitle(Title.title(Component.text(ChatColor.GREEN + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    game.addPoint(-1);
                    player.showTitle(Title.title(Component.text(ChatColor.RED + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            } else if (event.isBackward()) {
                if (game.getCurrent().equals(KeyIcon.DOWN)) {
                    game.addPoint(1);
                    player.showTitle(Title.title(Component.text(ChatColor.GREEN + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    game.addPoint(-1);
                    player.showTitle(Title.title(Component.text(ChatColor.RED + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            } else if (event.isLeft()) {
                if (game.getCurrent().equals(KeyIcon.LEFT)) {
                    game.addPoint(1);
                    player.showTitle(Title.title(Component.text(ChatColor.GREEN + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    game.addPoint(-1);
                    player.showTitle(Title.title(Component.text(ChatColor.RED + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            } else if (event.isRight()) {
                if (game.getCurrent().equals(KeyIcon.RIGHT)) {
                    game.addPoint(1);
                    player.showTitle(Title.title(Component.text(ChatColor.GREEN + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    game.addPoint(-1);
                    player.showTitle(Title.title(Component.text(ChatColor.RED + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            } else if (event.isJump()) {
                if (game.getCurrent().equals(KeyIcon.CENTER)) {
                    game.addPoint(1);
                    player.showTitle(Title.title(Component.text(ChatColor.GREEN + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    game.addPoint(-1);
                    player.showTitle(Title.title(Component.text(ChatColor.RED + game.getCurrent().getIcon()), Component.text("")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            }
        }
    }
    @EventHandler
    public void onGameEnd(PumpGameEndEvent event) {
        event.getPlayer().showTitle(Title.title(Component.text(event.getGame().getPoint() + "점"), Component.text("")));
        event.getGame().setPoint(0);
        PumpGameManager.end(event.getPlayer());
    }
    @EventHandler
    public void onGameStart(PumpGameStartEvent event) {
        PumpGameManager.start(event.getPlayer(), event.getGame());
    }
}

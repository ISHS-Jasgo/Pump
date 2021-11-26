package com.github.jasgo.pump.game;

import com.github.jasgo.pump.Pump;
import com.github.jasgo.pump.event.PumpGameEndEvent;
import com.github.jasgo.pump.event.PumpGameStartEvent;
import com.github.jasgo.vehicle.VehicleEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class PumpGame {

    public BossBar progress = Bukkit.createBossBar("점수: 0", BarColor.GREEN, BarStyle.SEGMENTED_10);

    private final List<KeyIcon> pattern;
    private KeyIcon current;
    private int point;
    private final Player player;

    public PumpGame(List<KeyIcon> pattern, Player player) {
        this.pattern = pattern;
        this.player = player;
        this.point = 0;
    }
    public void start(int length) {
        progress.addPlayer(player);
        (new BukkitRunnable() {
            int count = 3;
            @Override
            public void run() {
                if (count >= 1) {
                    player.showTitle(Title.title(Component.text(count), Component.text("")));
                    count--;
                } else {
                    cancel();
                    startGame(length);
                    callStartEvent();
                }
            }
        }).runTaskTimer(Pump.getPlugin(Pump.class), 0L, 20L);
    }

    public KeyIcon getCurrent() {
        return current;
    }

    public void setCurrent(KeyIcon current) {
        this.current = current;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    public void addPoint(int point) {
        setPoint(getPoint() + point);
    }

    public Player getPlayer() {
        return player;
    }

    public List<KeyIcon> getPattern() {
        return pattern;
    }
    public void startGame(int length) {
        (new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count < pattern.size()) {
                    setCurrent(pattern.get(count));
                    player.showTitle(Title.title(Component.text(getCurrent().getIcon()), Component.text("")));
                    double p = ((double) getPoint()/getPattern().size()) * 10;
                    progress.setTitle("점수: " + (Math.floor(p)/10));
                    progress.setProgress((double) getPoint()/getPattern().size());
                    count++;
                } else {
                    cancel();
                    callEndEvent();
                    reset();
                }
            }
        }).runTaskTimer(Pump.getPlugin(Pump.class), 0L, length);
    }
    public void callStartEvent() {
        Bukkit.getPluginManager().callEvent(new PumpGameStartEvent(player, this));
    }
    public void callEndEvent() {
        Bukkit.getPluginManager().callEvent(new PumpGameEndEvent(player, this));
    }

    public void reset() {
        player.getVehicle().remove();
        progress.removePlayer(player);
    }
}

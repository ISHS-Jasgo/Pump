package com.github.jasgo.pump.event;

import com.github.jasgo.pump.game.PumpGame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PumpGameEndEvent extends Event {

    public static HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final PumpGame game;

    public PumpGameEndEvent(Player player, PumpGame game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return player;
    }

    public PumpGame getGame() {
        return game;
    }
}

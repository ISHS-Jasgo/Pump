package com.github.jasgo.pump.game;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PumpGameManager {
    public static HashMap<Player, PumpGame> gameList = new HashMap<>();

    public static boolean hasGame(Player player) {
        return gameList.containsKey(player);
    }
    public static PumpGame getGame(Player player) {
        return gameList.get(player);
    }
    public static void start(Player player, PumpGame game) {
        gameList.put(player, game);
    }
    public static void end(Player player) {
        gameList.remove(player);
    }
}

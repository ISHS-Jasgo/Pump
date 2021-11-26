package com.github.jasgo.pump.game;

public enum KeyIcon {
    UP("↑"), DOWN("↓"), LEFT("←"),
    RIGHT("→"), CENTER("▣");

    private final String icon;
    KeyIcon(String s) {
        this.icon = s;
    }

    public String getIcon() {
        return icon;
    }
}

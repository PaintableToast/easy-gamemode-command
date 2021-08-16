package de.paintabletoast.system.var;

import org.bukkit.Sound;

public enum Sounds {
    NO_PERMISSION,
    PLAYER_NOT_ONLINE,
    GAMEMODE_OTHER,
    GAMEMODE_SELF,
    WRONG_COMMAND;
    public final Sound getSound() {
        return Sound.valueOf(ConfigFile.SOUNDS.getConfig().getString(PathFile.SOUNDS.getPath() + this.name()));
    }
}

package de.paintabletoast.system.var;

public enum Permission {
    GAMEMODE_OTHER,
    GAMEMODE_USE;
    public final String getPermission() {
        return ConfigFile.PERMISSION.getConfig().getString(PathFile.PERMISSION.getPath() + this.name());
    }
}

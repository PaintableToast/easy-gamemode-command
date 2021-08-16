package de.paintabletoast.system.var;

public enum Settings {
    DEFAULT;
    public boolean getSetting() {
        return (boolean) ConfigFile.SETTINGS.getConfig().get(PathFile.SETTINGS.getPath() + this.name());
    }

}

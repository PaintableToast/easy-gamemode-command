package de.paintabletoast.system.var;

public enum Message {
    PREFIX(PathFile.GENERAL),
    CONSOLE_PREFIX(PathFile.GENERAL),
    INFORMATION_TAG(PathFile.GENERAL),

    NO_PERMISSION(PathFile.USER),
    WRONG_COMMAND_ARGUMENTATION(PathFile.USER),
    PLAYER_NOT_ONLINE(PathFile.USER),
    GAMEMODE_OTHER(PathFile.USER),
    GAMEMODE_SELF(PathFile.USER),

    PLUGIN_LOAD(PathFile.CONSOLE),
    PLUGIN_SUCCESS_LOAD(PathFile.CONSOLE),
    PLUGIN_ERROR_LOAD(PathFile.CONSOLE),
    PLUGIN_STOP(PathFile.CONSOLE),
    FILE_LOAD_CONFIG(PathFile.CONSOLE),
    COMMAND_SUCCESS(PathFile.CONSOLE),
    COMMAND_ERROR(PathFile.CONSOLE),
    LISTENER_SUCCESS(PathFile.CONSOLE),
    LISTENER_ERROR(PathFile.CONSOLE),
    NO_CONSOLE(PathFile.CONSOLE),

    GAMEMODE_COMMAND(PathFile.ARGUMENTS)
    ;
    private PathFile pathFile;
    Message(PathFile pathFile) {
       this.pathFile = pathFile;
    }
    public String getMessage() {
        if(pathFile == PathFile.GENERAL) {
            return ConfigFile.MESSAGE.getConfig().getPreString(PathFile.MESSAGE.getPath() + pathFile.getPath() +  this.name());
        }
        return ConfigFile.MESSAGE.getConfig().getString(PathFile.MESSAGE.getPath() + pathFile.getPath() +  this.name());
    }

}


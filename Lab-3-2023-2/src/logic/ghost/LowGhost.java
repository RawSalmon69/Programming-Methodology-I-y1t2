package logic.ghost;

import utils.Config;

public abstract class LowGhost extends Ghost {
    // constructor
    public LowGhost() {
        super(Config.LowGhostHp);
    }

    // method
    public int getLevel() {
        return Config.LowGhostLevel;
    }
}

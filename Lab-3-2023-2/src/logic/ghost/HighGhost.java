package logic.ghost;

import utils.Config;

public abstract class HighGhost extends Ghost {
    // constructor
    public HighGhost() {
        super(Config.HighGhostHp);
    }

    // method
    public abstract void damage();
}

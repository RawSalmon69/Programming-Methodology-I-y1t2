package logic.ghost;

public abstract class Ghost {
    // field
    private int hp;

    // constructor
    public Ghost(int hp) {
        setHp(hp);
    }

    // method
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public int getHp() {
        return this.hp;
    }

    public boolean isDestroyed() {
        return this.hp == 0;
    }

    public void decreaseHp(int amount) {
        setHp(getHp() - amount);
    }

    public abstract int getLevel();

    public abstract void attack();
}

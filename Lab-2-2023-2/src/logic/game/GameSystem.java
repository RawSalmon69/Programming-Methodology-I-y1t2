package logic.game;

import monkey.*;

import java.util.*;

public class GameSystem {
    private final ArrayList<BaseMonkey> monkeyContainer = new ArrayList<BaseMonkey>();
    private final ArrayList<BaseMonkey> apeContainer = new ArrayList<BaseMonkey>();
    private int gameState = 0;
    private int sp = 5;


    private boolean gameEnd = false;
    private static GameSystem instance = new GameSystem();

    public static GameSystem getInstance() {
        return instance;
    }

    public GameSystem() {
        // monkeyContainer = new ArrayList<BaseMonkey>();
        //apeContainer = new ArrayList<BaseMonkey>();
        addApe();
    }

    public void addMonkey() {
        BaseMonkey m1 = new BaseMonkey(100, 15, 10);
        MuscleMonkey m2 = new MuscleMonkey(200, 20, 10);
        MommyMonkey m3 = new MommyMonkey(80, 0, 10);
        UgabugagaMonkey m4 = new UgabugagaMonkey(80, 10, 15);

        getMonkeyContainer().add(m1);
        getMonkeyContainer().add(m2);
        getMonkeyContainer().add(m3);
        getMonkeyContainer().add(m4);
    }

    public void addApe() {
        //TODO for student : Fill code here
        Ape ape = new Ape(200, 30, 10);
        getApeContainer().add(ape);
        getApeContainer().add(ape);
        getApeContainer().add(ape);
    }

    public ArrayList<BaseMonkey> getMonkeyContainer() {
        return monkeyContainer;
    }

    public boolean isGameEnd() {
        if (monkeyContainer.size() <= 1) {
            gameEnd = true;
        }
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }


    public ArrayList<BaseMonkey> getApeContainer() {
        return apeContainer;
    }

    public void printMonkeyStatus() {
        for (int i = 0; i < monkeyContainer.size(); i++) {
            BaseMonkey temp = getMonkeyContainer().get(i);
            System.out.println(temp.toString());
        }
    }

    public void removeDeadEntity(ArrayList<BaseMonkey> entityContainer) {
        //TODO for student : Fill code here
        for(int i=0;i<entityContainer.size();i++) {
            if (entityContainer.get(i).getHp() == 0) {
                showDeadMessage(entityContainer.get(i), i);
                entityContainer.remove(i);
            }
        }
    }

    public void showDeadMessage(BaseMonkey monkey, int index) {

        if (monkey.getType().equals("Ape")) {
            System.out.println("Monkey takes down one enemy ape!");
            System.out.println("Ape " + "<" + index + "> has fallen!");
        } else {
            System.out.println("your " + monkey.getType() + " <" + index + ">" + " has fallen. Press 'F' to pay them respects.");
        }
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

}

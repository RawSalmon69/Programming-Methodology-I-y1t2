package logic.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

import exception.BadStatusException;
import logic.components.*;
public class GameController {
    public ArrayList<Market> markets;
    public ArrayList<Player> players;
    public ArrayList<Monster> monsters;
    public ArrayList<Ore> ores;
    public static GameController instance = null;
    public boolean gameEnd = false;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public GameController() {
        markets = new ArrayList<Market>();
        markets.add(new Market("Taiyo"));
        markets.get(0).getFoods().add(new Food("Bacon", 10, 5));
        markets.get(0).getFoods().add(new Food("Chicken", 15, 7));
        markets.get(0).getFoods().add(new Food("Beef", 20, 12));
        markets.get(0).getPotions().add(new Potion("Middle Heal", 15, createNewStatus(4, 0, 0, 0)));
        markets.get(0).getPotions().add(new Potion("Middle Attack", 15, createNewStatus(0, 0, 4, 0)));
        players = new ArrayList<Player>();
        players.add(new Player("Akira", createNewStatus(10, 2, 4, 2)));
        players.add(new Player("Ayane", createNewStatus(5, 3, 3, 6), 6, 1200));
        monsters = new ArrayList<Monster>();
        monsters.add(new Monster("Boar", createNewStatus(12, 2, 1, 2)));
        monsters.add(new Monster("Basilisk", createNewStatus(7, 4, 6, 0)));
        monsters.get(0).setFood(new Food("Boar bacon", 20, 7));
        monsters.get(0).setPotion(new Potion("Little Hp Potion", 10, createNewStatus(1, 0, 0, 0)));
        monsters.get(1).setFood(new Food("Basilisk meat", 70, 20));
        monsters.get(1).setPotion(new Potion("Medium Potion", 40, createNewStatus(4, 2, 3, 3)));
        ores = new ArrayList<Ore>();
        ores.add(new Ore("Gold", 180));
        ores.add(new Ore("Silver", 140));
        ores.add(new Ore("Platinum", 250));
        ores.add(new Ore("Bronze", 40));
    }

    public void addMarket(Market market) {
        markets.add(market);
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void endDay(){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getEnergy() >= 3){
                players.get(i).setEnergy(players.get(i).getEnergy() - 3);
            }else{
                int hploss = -1*(players.get(i).getEnergy() - 3);
                players.get(i).setEnergy(0);
                try{
                    players.get(i).getStatus().setHp(players.get(i).getStatus().getHp() - hploss);
                }catch (BadStatusException e){
                    return;
                }
            }
        }
    }

    public void removeDeadPlayerAndMonster() {
        for (int i = monsters.size() - 1; i >= 0; i--) {
            if (monsters.get(i).getStatus().getHp() <= 0) {
                monsters.remove(i);
            }
        }
        for (int i = players.size() - 1; i >= 0; i--) {
            if (players.get(i).getStatus().getHp() <= 0) {
                players.remove(i);
            }
        }
    }

    public boolean buyOre(int player, int number) {
        return players.get(player).buyOre(ores.get(number));
    }
    public boolean checkGameEnd(){
        if(gameEnd == true){
            return true;
        }
        for(int i=0;i<players.size();++i){
            boolean haveFourOres=true;
            for(int j=0;j<4;++j) {
                if (players.get(i).getOres().contains(ores.get(j)) == false){
                    haveFourOres=false;
                    break;
                }
            }
            if(haveFourOres==true){
                System.out.println("Player : "+players.get(i).getName()+" Win");
                gameEnd=true;
                return gameEnd;
            }
        }
        return gameEnd;
    }
    public static Status createNewStatus(int hp, int durable, int attack,int magic){
        Status status;
        try {
            status = new Status(hp,durable,attack,magic);
        } catch (BadStatusException e) {
            return null;
        }
        return status;
    }
}

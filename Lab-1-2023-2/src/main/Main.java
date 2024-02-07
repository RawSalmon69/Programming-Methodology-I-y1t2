package main;

import logic.components.*;
import logic.game.GameController;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, Welcome to the game");
        while (!GameController.getInstance().checkGameEnd()) {
            System.out.println("Start Day");
            while (true) {
                System.out.println("Enter any string to go to next step");
                scan.next();
                System.out.println("======================================================");
                System.out.println("Choose an option");
                System.out.println("------------------------------------------------------");
                System.out.println("<1> Add Market");
                System.out.println("<2> Add Monster");
                System.out.println("<3> Add Player");
                System.out.println("<4> Add Food to the market");
                System.out.println("<5> Add Potion to the market");
                System.out.println("<6> Show all information of player");
                System.out.println("<7> Show all information of monster");
                System.out.println("<8> Buy Food or Potion From Market");
                System.out.println("<9> Player Attack Monster");
                System.out.println("<10> Monster Attack Player");
                System.out.println("<11> Buy Ore");
                System.out.println("<12> Drink Potion");
                System.out.println("<13> Eat Food");
                System.out.println("<14> Sell Potion");
                System.out.println("<15> Sell Food");
                System.out.println("<16> End Day");
                System.out.println("------------------------------------------------------");
                System.out.println("<0> Exit");
                System.out.println("======================================================");
                int option;
                while(true) {
                    try {
                        option = scan.nextInt();
                        while (option < 0 || option > 16) {
                            System.out.println("Invalid option, please type your option again.");
                            option = scan.nextInt();
                        }
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Invalid option, please type your option again.");
                        scan.nextLine();
                    }
                }
                if(option == 0){
                    GameController.getInstance().gameEnd=true;
                    break;
                }
                else if (option == 1) {
                    System.out.println("======================================================");
                    System.out.println("Enter market name");
                    String marketName = scan.next();
                    GameController.getInstance().addMarket(new Market(marketName));
                    System.out.println("Market created");
                } else if (option == 2) {
                    System.out.println("======================================================");
                    System.out.println("Enter monster name");
                    String monsterName = scan.next();
                    System.out.println("Enter hp");
                    int hp = scan.nextInt();
                    System.out.println("Enter durability");
                    int durable = scan.nextInt();
                    System.out.println("Enter attack");
                    int attack = scan.nextInt();
                    System.out.println("Enter magic");
                    int magic = scan.nextInt();
                    Status status = GameController.createNewStatus(hp, durable, attack, magic);
                    if(status == null)continue;
                    GameController.getInstance().addMonster(new Monster(monsterName, status));
                    GameController.getInstance().monsters.get(GameController.getInstance().monsters.size()-1).setFood(new Food("Meat",40,6));
                    GameController.getInstance().monsters.get(GameController.getInstance().monsters.size()-1).setPotion(new Potion("Expense Potion",50,GameController.createNewStatus(4,4,4,4)));
                    System.out.println("Monster created");
                } else if (option == 3) {
                    System.out.println("======================================================");
                    System.out.println("Enter player name");
                    String playerName = scan.next();
                    System.out.println("Enter hp");
                    int hp = scan.nextInt();
                    System.out.println("Enter durability");
                    int durable = scan.nextInt();
                    System.out.println("Enter attack");
                    int attack = scan.nextInt();
                    System.out.println("Enter magic");
                    int magic = scan.nextInt();
                    Status status = GameController.createNewStatus(hp, durable, attack, magic);
                    if(status == null)continue;
                    Player newPlayer = new Player(playerName, status);
                    GameController.getInstance().addPlayer(newPlayer);
                    System.out.println("Player created");
                } else if (option == 4) {
                    System.out.println("======================================================");
                    System.out.println("Choose market");
                    for (int i = 0; i < GameController.getInstance().markets.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().markets.get(i).getName());
                    }
                    int market = scan.nextInt();
                    if (market < 0 || market >= GameController.getInstance().markets.size()) {
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Enter food name");
                    String foodName = scan.next();
                    System.out.println("Enter food price");
                    int price = scan.nextInt();
                    if (price <= 0) {
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Enter food energy");
                    int energy = scan.nextInt();
                    if (energy <= 0) {
                        System.out.println("Error");
                        continue;
                    }
                    GameController.getInstance().markets.get(market).getFoods().add(new Food(foodName, price, energy));
                    System.out.println("Food is added to market");
                } else if (option == 5) {
                    System.out.println("======================================================");
                    System.out.println("Choose market");
                    for (int i = 0; i < GameController.getInstance().markets.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().markets.get(i).getName());
                    }
                    int market = scan.nextInt();
                    if (market < 0 || market >= GameController.getInstance().markets.size()) {
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Enter Potion name");
                    String potionName = scan.next();
                    System.out.println("Enter Potion price");
                    int price = scan.nextInt();
                    if (price <= 0) {
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Enter Increasing Hp");
                    int hp = scan.nextInt();
                    System.out.println("Enter Increasing durability");
                    int durable = scan.nextInt();
                    System.out.println("Enter Increasing attack");
                    int attack = scan.nextInt();
                    System.out.println("Enter Increasing magic");
                    int magic = scan.nextInt();
                    Status status = GameController.createNewStatus(hp, durable, attack, magic);
                    if(status == null)continue;
                    GameController.getInstance().markets.get(market).getPotions().add(new Potion(potionName,price,status));
                    System.out.println("Potion is added to market");
                }
                else if(option == 6){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for(int i=0;i<GameController.getInstance().players.size();i++){
                        System.out.println("<"+i+"> "+"Player: "+GameController.getInstance().players.get(i).getName());
                        System.out.println("Hp: "+GameController.getInstance().players.get(i).getStatus().getHp()+" Durability: "+GameController.getInstance().players.get(i).getStatus().getDurability()
                        +" Attack: "+GameController.getInstance().players.get(i).getStatus().getAttack()+" Magic: "+GameController.getInstance().players.get(i).getStatus().getMagic()
                        +" Energy: "+GameController.getInstance().players.get(i).getEnergy()+" Money: "+GameController.getInstance().players.get(i).getMoney()
                        );
                    }
                    int player = scan.nextInt();
                    if(player<0||player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Player: "+GameController.getInstance().players.get(player).getName());
                    System.out.println("Hp: "+GameController.getInstance().players.get(player).getStatus().getHp()+" Durability: "+GameController.getInstance().players.get(player).getStatus().getDurability()
                            +" Attack: "+GameController.getInstance().players.get(player).getStatus().getAttack()+" Magic: "+GameController.getInstance().players.get(player).getStatus().getMagic()
                            +" Energy: "+GameController.getInstance().players.get(player).getEnergy()+" Money: "+GameController.getInstance().players.get(player).getMoney()
                    );
                    System.out.println("Food: ");
                    for(int i=0;i<GameController.getInstance().players.get(player).getFoods().size();i++){
                        System.out.println(GameController.getInstance().players.get(player).getFoods().get(i).getName());
                    }
                    System.out.println("Potion: ");
                    for(int i=0;i<GameController.getInstance().players.get(player).getPotions().size();i++){
                        System.out.println(GameController.getInstance().players.get(player).getPotions().get(i).getName());
                    }
                    System.out.println("Ore: ");
                    for(int i=0;i<GameController.getInstance().players.get(player).getOres().size();i++){
                        System.out.println(GameController.getInstance().players.get(player).getOres().get(i).getName());
                    }
                }
                else if(option == 7){
                    System.out.println("======================================================");
                    if(GameController.getInstance().monsters.size()==0){
                        System.out.println("There is no monster");
                        continue;
                    }
                    System.out.println("Choose monster");
                    for(int i=0;i<GameController.getInstance().monsters.size();i++){
                        System.out.println("<"+i+"> "+"Monster: "+GameController.getInstance().monsters.get(i).getName());
                        System.out.println("Hp: "+GameController.getInstance().monsters.get(i).getStatus().getHp()+" Durability: "+GameController.getInstance().monsters.get(i).getStatus().getDurability()
                                +" Attack: "+GameController.getInstance().monsters.get(i).getStatus().getAttack()+" Magic: "+GameController.getInstance().monsters.get(i).getStatus().getMagic()
                        );
                    }
                    int monster = scan.nextInt();
                    if(monster <0||monster >=GameController.getInstance().monsters.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Monster: "+GameController.getInstance().monsters.get(monster).getName());
                    System.out.println("Hp: "+GameController.getInstance().monsters.get(monster).getStatus().getHp()+" Durability: "+GameController.getInstance().monsters.get(monster).getStatus().getDurability()
                            +" Attack: "+GameController.getInstance().monsters.get(monster).getStatus().getAttack()+" Magic: "+GameController.getInstance().monsters.get(monster).getStatus().getMagic()
                    );
                    System.out.println("Drop Food: "+GameController.getInstance().monsters.get(monster).getFood().getName() + ", Drop Potion: "+GameController.getInstance().monsters.get(monster).getPotion().getName());
                }
                else if(option == 8){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose one choice");
                    System.out.println("<1> Buy Potion");
                    System.out.println("<2> Buy Food");
                    int choice = scan.nextInt();
                    if(choice!=1 && choice!=2){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose player who is buyer");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                        System.out.println("Money: "+GameController.getInstance().players.get(i).getMoney());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose Market");
                    for (int i = 0; i < GameController.getInstance().markets.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().markets.get(i).getName());
                    }
                    int market = scan.nextInt();
                    if (market < 0 || market >= GameController.getInstance().markets.size()) {
                        System.out.println("Error");
                        continue;
                    }
                    if(choice == 1){
                        if(GameController.getInstance().markets.get(market).getFoods().size()==0){
                            System.out.println("This market don't have foods");
                            continue;
                        }
                        System.out.println("Choose potion you want to buy");
                        for(int i=0;i<GameController.getInstance().markets.get(market).getPotions().size();i++){
                            System.out.println("<"+i+"> "+GameController.getInstance().markets.get(market).getPotions().get(i).getName());
                            System.out.println("Increasing Status Hp: "+GameController.getInstance().markets.get(market).getPotions().get(i).getIncreasingStatus().getHp()
                                    +" Durability: "+GameController.getInstance().markets.get(market).getPotions().get(i).getIncreasingStatus().getDurability()
                                    +" Attack: "+GameController.getInstance().markets.get(market).getPotions().get(i).getIncreasingStatus().getAttack()
                                    +" Magic: "+GameController.getInstance().markets.get(market).getPotions().get(i).getIncreasingStatus().getMagic()
                            );
                            System.out.println("Price: "+GameController.getInstance().markets.get(market).getPotions().get(i).getPrice());
                        }
                        int potion = scan.nextInt();
                        if(potion<0 || potion>=GameController.getInstance().markets.get(market).getPotions().size()){
                            System.out.println("Error");
                            continue;
                        }
                        if(GameController.getInstance().players.get(player).getMoney()<GameController.getInstance().markets.get(market).getPotions().get(potion).getPrice()){
                            System.out.println("Your money is not enough to buy this potion");
                            continue;
                        }
                        System.out.println("Buy potion completed");
                        GameController.getInstance().players.get(player).setMoney(GameController.getInstance().players.get(player).getMoney()-GameController.getInstance().markets.get(market).getPotions().get(potion).getPrice());
                        GameController.getInstance().players.get(player).getPotions().add(GameController.getInstance().markets.get(market).getPotions().get(potion));
                        GameController.getInstance().markets.get(market).getPotions().remove(GameController.getInstance().markets.get(market).getPotions().get(potion));
                    }
                    else if(choice == 2){
                        if(GameController.getInstance().markets.get(market).getFoods().size()==0){
                            System.out.println("This market does not have foods");
                            continue;
                        }
                        System.out.println("Choose food you want to buy");
                        for(int i=0;i<GameController.getInstance().markets.get(market).getFoods().size();i++){
                            System.out.println("<"+i+"> "+GameController.getInstance().markets.get(market).getFoods().get(i).getName());
                            System.out.println("Price: "+GameController.getInstance().markets.get(market).getFoods().get(i).getPrice()+" Energy : "+GameController.getInstance().markets.get(market).getFoods().get(i).getEnergy());
                        }
                        int food = scan.nextInt();
                        if(food<0 || food>=GameController.getInstance().markets.get(market).getFoods().size()){
                            System.out.println("Error");
                            continue;
                        }
                        if(GameController.getInstance().players.get(player).getMoney()<GameController.getInstance().markets.get(market).getFoods().get(food).getPrice()){
                            System.out.println("Your money is not enough to buy this food");
                            continue;
                        }
                        System.out.println("Buy food completed");
                        GameController.getInstance().players.get(player).setMoney(GameController.getInstance().players.get(player).getMoney()-GameController.getInstance().markets.get(market).getFoods().get(food).getPrice());
                        GameController.getInstance().players.get(player).getFoods().add(GameController.getInstance().markets.get(market).getFoods().get(food));
                        GameController.getInstance().markets.get(market).getFoods().remove(GameController.getInstance().markets.get(market).getFoods().get(food));
                    }
                }
                else if(option == 9){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 || GameController.getInstance().monsters.size()==0){
                        System.out.println("There is no player or no monster");
                        continue;
                    }
                    System.out.println("Choose Player which is attacker");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose Monster which is attacked");
                    for (int i = 0; i < GameController.getInstance().monsters.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().monsters.get(i).getName());
                    }
                    int monster = scan.nextInt();
                    if(monster<0 || monster>=GameController.getInstance().monsters.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose type of attack");
                    System.out.println("<1> Normal Attack");
                    System.out.println("<2> Magic Attack");
                    int attack = scan.nextInt();
                    if(attack == 1){
                        GameController.getInstance().players.get(player).attack(GameController.getInstance().monsters.get(monster));
                        System.out.println("Monster: "+GameController.getInstance().monsters.get(monster).getName()+" now has hp "+GameController.getInstance().monsters.get(monster).getStatus().getHp());
                    }
                    else if(attack == 2){
                        GameController.getInstance().players.get(player).magicAttack(GameController.getInstance().monsters.get(monster));
                        System.out.println("Monster: "+GameController.getInstance().monsters.get(monster).getName()+ " now has hp "+GameController.getInstance().monsters.get(monster).getStatus().getHp());
                    }
                    else{
                        System.out.println("Error");
                        continue;
                    }
                    if(GameController.getInstance().monsters.get(monster).getStatus().getHp()<=0){
                        System.out.println("You got Food: "+GameController.getInstance().monsters.get(monster).getFood().getName());
                        System.out.println("Price: "+GameController.getInstance().monsters.get(monster).getFood().getPrice()+" Energy: "+GameController.getInstance().monsters.get(monster).getFood().getEnergy());
                        System.out.println("You got Potion: "+GameController.getInstance().monsters.get(monster).getPotion().getName());
                        System.out.println("Price: "+GameController.getInstance().monsters.get(monster).getPotion().getPrice());
                        System.out.println("Increasing Status Hp: "+GameController.getInstance().monsters.get(monster).getPotion().getIncreasingStatus().getHp()
                                +" Durability: "+GameController.getInstance().monsters.get(monster).getPotion().getIncreasingStatus().getDurability()
                                +" Attack: "+GameController.getInstance().monsters.get(monster).getPotion().getIncreasingStatus().getAttack()
                                +" Magic: "+GameController.getInstance().monsters.get(monster).getPotion().getIncreasingStatus().getMagic()
                        );
                        GameController.getInstance().players.get(player).getFoods().add(GameController.getInstance().monsters.get(monster).getFood());
                        GameController.getInstance().players.get(player).getPotions().add(GameController.getInstance().monsters.get(monster).getPotion());
                    }
                    GameController.getInstance().removeDeadPlayerAndMonster();
                }
                else if(option == 10){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 || GameController.getInstance().monsters.size()==0){
                        System.out.println("There is no player or no monster");
                        continue;
                    }
                    System.out.println("Choose Monster which is attacker");
                    for (int i = 0; i < GameController.getInstance().monsters.size(); i++) {
                        System.out.println("<" + i + "> "  + GameController.getInstance().monsters.get(i).getName());
                    }
                    int monster = scan.nextInt();
                    if(monster<0 || monster>=GameController.getInstance().monsters.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose Player which is attacked");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose type of attack");
                    System.out.println("<1> Normal Attack");
                    System.out.println("<2> Magic Attack");
                    int attack = scan.nextInt();
                    if(attack == 1){
                        GameController.getInstance().monsters.get(monster).attack(GameController.getInstance().players.get(player));
                        System.out.println("Player: "+GameController.getInstance().players.get(player).getName()+ " now has hp "+GameController.getInstance().players.get(player).getStatus().getHp());

                    }
                    else if(attack == 2){
                        GameController.getInstance().monsters.get(monster).magicAttack(GameController.getInstance().players.get(player));
                        System.out.println("Player: "+GameController.getInstance().players.get(player).getName()+ " now has hp "+GameController.getInstance().players.get(player).getStatus().getHp());
                    }
                    else{
                        System.out.println("Error");
                        continue;
                    }
                    GameController.getInstance().removeDeadPlayerAndMonster();
                }
                else if(option==11){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 ){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                        System.out.println("Money: "+GameController.getInstance().players.get(i).getMoney());
                        System.out.println("Ores: ");
                        for(int j=0;j<GameController.getInstance().players.get(i).getOres().size();j++){
                            System.out.println(GameController.getInstance().players.get(i).getOres().get(j).getName());
                        }
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Choose ore you want to buy");
                    for(int i=0;i<4;i++){
                        System.out.println("<"+i+"> "+GameController.getInstance().ores.get(i).getName() +" Cost: "+GameController.getInstance().ores.get(i).getCost());
                    }
                    int ore=scan.nextInt();
                    if(ore<0||ore>=4){
                        System.out.println("Error");
                        continue;
                    }
                    if(!GameController.getInstance().players.get(player).buyOre(GameController.getInstance().ores.get(ore))){
                        System.out.println("Money is not enough to buy ore");
                        continue;
                    }
                    System.out.println("Buy ore success");
                    if(GameController.getInstance().checkGameEnd()){
                        break;
                    }
                }
                else if(option == 12){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 ){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    if(GameController.getInstance().players.get(player).getPotions().size()==0){
                        System.out.println(GameController.getInstance().players.get(player).getName()+" does not have any potion");
                        continue;
                    }
                    System.out.println("Choose Potion you want to drink");
                    for (int i = 0; i < GameController.getInstance().players.get(player).getPotions().size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(player).getPotions().get(i).getName());
                        System.out.println("Increasing Status Hp : "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getHp()
                                +" Durability: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getDurability()
                                +" Attack: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getAttack()
                                +" Magic: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getMagic()
                        );
                        System.out.println("Price: "+GameController.getInstance().players.get(player).getPotions().get(i).getPrice());
                    }
                    int potion = scan.nextInt();
                    if(potion<0||potion>=GameController.getInstance().players.get(player).getPotions().size()){
                        System.out.println("Error");
                        continue;
                    }
                    System.out.println("Drink Potion completed");
                    GameController.getInstance().players.get(player).drinkPotion(potion);
                    //GameController.getInstance().players.get(player).getStatus().addStatus(GameController.getInstance().players.get(player).getPotions().get(potion).getIncreasingStatus());
                    //GameController.getInstance().players.get(player).getPotions().remove(GameController.getInstance().players.get(player).getPotions().get(potion));
                }
                else if(option == 13){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 ){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    if(GameController.getInstance().players.get(player).getFoods().size()==0){
                        System.out.println(GameController.getInstance().players.get(player).getName()+" does not have any food");
                        continue;
                    }
                    System.out.println("Choose Food you want to eat");
                    for (int i = 0; i < GameController.getInstance().players.get(player).getFoods().size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(player).getFoods().get(i).getName());
                        System.out.println("Energy: "+GameController.getInstance().players.get(player).getFoods().get(i).getEnergy()
                                +" Price: "+GameController.getInstance().players.get(player).getFoods().get(i).getPrice());
                    }
                    int food = scan.nextInt();
                    if(food<0||food>=GameController.getInstance().players.get(player).getFoods().size()){
                        System.out.println("Error");
                        continue;
                    }
                    GameController.getInstance().players.get(player).eatFood(food);
                }
                else if(option == 14){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 ){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    if(GameController.getInstance().players.get(player).getPotions().size()==0){
                        System.out.println(GameController.getInstance().players.get(player).getName()+" does not have any potion");
                        continue;
                    }
                    System.out.println("Choose Potion you want to sell");
                    for (int i = 0; i < GameController.getInstance().players.get(player).getPotions().size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(player).getPotions().get(i).getName());
                        System.out.println("Increasing Status Hp: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getHp()
                                +" Durability: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getDurability()
                                +" Attack: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getAttack()
                                +" Magic: "+GameController.getInstance().players.get(player).getPotions().get(i).getIncreasingStatus().getMagic()
                        );
                        System.out.println("Price: "+GameController.getInstance().players.get(player).getPotions().get(i).getPrice());
                    }
                    int potion = scan.nextInt();
                    if(potion<0||potion>=GameController.getInstance().players.get(player).getPotions().size()){
                        System.out.println("Error");
                        continue;
                    }
                    GameController.getInstance().players.get(player).sellPotion(potion);
                }
                else if(option == 15){
                    System.out.println("======================================================");
                    if(GameController.getInstance().players.size()==0 ){
                        System.out.println("There is no player");
                        continue;
                    }
                    System.out.println("Choose player");
                    for (int i = 0; i < GameController.getInstance().players.size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(i).getName());
                    }
                    int player = scan.nextInt();
                    if(player<0 || player>=GameController.getInstance().players.size()){
                        System.out.println("Error");
                        continue;
                    }
                    if(GameController.getInstance().players.get(player).getFoods().size()==0){
                        System.out.println(GameController.getInstance().players.get(player).getName()+" does not have any food");
                        continue;
                    }
                    System.out.println("Choose Food you want to sell");
                    for (int i = 0; i < GameController.getInstance().players.get(player).getFoods().size(); i++) {
                        System.out.println("<" + i + "> " + GameController.getInstance().players.get(player).getFoods().get(i).getName());
                        System.out.println("Energy: "+GameController.getInstance().players.get(player).getFoods().get(i).getEnergy()
                                +" Price: "+GameController.getInstance().players.get(player).getFoods().get(i).getPrice());
                    }
                    int food = scan.nextInt();
                    if(food<0||food>=GameController.getInstance().players.get(player).getFoods().size()){
                        System.out.println("Error");
                        continue;
                    }
                    GameController.getInstance().players.get(player).sellFood(food);
                }
                else {
                    break;
                }
            }
            GameController.getInstance().endDay();
            GameController.getInstance().removeDeadPlayerAndMonster();
        }
    }
}
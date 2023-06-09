package game;

import game.characters.Hero;
import game.fight.FightBuilder;
import game.merchant.Merchant;
import game.merchant.Shop;

import java.util.Scanner;

public class Game {
    Hero hero;
    Merchant merchant;
    Shop shop;

    public Game(Hero hero) {
        this.hero = hero;
        this.merchant = new Merchant();
        this.shop = new Shop(this.merchant, this.hero);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nWelcome, " + hero.getName() + ", to the Lost Lands.");

        // Main menu
        do {
            System.out.println("\nWhat do you want to do:");
            System.out.println("1. Show my stats");
            System.out.println("2. Go to the Dark Forest");
            System.out.println("3. Go to Merchant");
            System.out.println("4. Exit");

            String input = scanner.nextLine();

            if (input.equals("4")) break;
            
            switch (input) {
                case "1" -> hero.print();
                case "2" -> new FightBuilder().startFight(hero);
                case "3" -> shop.startTrading();
                default -> {
                    System.out.println("\n--- I don't understand you, brave warrior!");
                }
            }

            if (hero.getCurrentHp() == 0) break;
            checkToLevelUp();

        } while (true);
    }

    private void checkToLevelUp() {
        if (hero.getCurrentLevel() == Constant.MAX_LEVEL) return;
        if (hero.getExp() >= Constant.HERO_EXP_LEVEL[hero.getCurrentLevel() + 1]) {
            hero.levelUp();
            System.out.println("--- Greetings, " + hero.getName() + "! You've been promoted to level " + hero.getCurrentLevel() + ".");
        }
    }
}

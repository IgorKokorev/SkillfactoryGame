package game;


import game.characters.Hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, brave warrior!");
        System.out.print("What is your name? ");
        String heroName = scanner.nextLine();
        System.out.println("We're happy to see you, " + heroName + "!");
        System.out.println("Here begins your adventure!");

        for (int i = 0; i < 20; i++) {
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }

        Hero hero = new Hero(heroName);
        do {
            Game game = new Game(hero);
            game.startGame();

            System.out.print("\n--- It was a good game! do you want to play again? (Y/N) ");
        } while (scanner.nextLine().equalsIgnoreCase("y"));
        System.out.println("\nGood buy, " + heroName + "!");
    }
}
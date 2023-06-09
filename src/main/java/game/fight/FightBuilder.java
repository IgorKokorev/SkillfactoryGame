package game.fight;

import game.characters.Hero;
import game.characters.Monster;
import game.characters.MonsterFactory;

public class FightBuilder {
    public void startFight(Hero hero) {
        FightConsoleLink fightConsoleLink = new FightConsoleLink();

        MonsterFactory monsterFactory = new MonsterFactory();
        Monster monster = monsterFactory.getMonster(hero.getCurrentLevel());

        Fight fight = new Fight(hero, monster, fightConsoleLink);
        Thread threadFight = new Thread(fight, "Fight");

        ConsoleInput consoleInput = new ConsoleInput(fightConsoleLink);
        Thread threadConsole = new Thread(consoleInput, "Console");

        threadFight.start();
        threadConsole.start();

        try {
            threadFight.join();
        } catch (InterruptedException e) {
        }

        if (threadConsole.isAlive()){
            System.out.println("--- Enter 'q' to exit the figh.");
            try {
                threadConsole.join();
            } catch (InterruptedException e) {
                System.out.println("Error closing console thread.");
            }
        }

        if (hero.getCurrentHp() == 0) {
            System.out.println("\n--- You are dead, brave warrior... We will always remember you...\n");
        } else if (monster.getCurrentHp() == 0) {
            System.out.println("\n--- You won, brave warrior! Congratulations!\n");
            hero.setGold(hero.getGold() + monster.getGold());
            hero.setExp(hero.getExp() + monster.getExp());
        } else {
            System.out.println("\n--- You escaped the fight. What a shame!");
        }
    }
}

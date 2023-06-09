package game.fight;

import game.Constant;
import game.characters.Hero;
import game.characters.Monster;

public class Fight implements Runnable {
    private Hero hero;
    private Monster monster;
    FightConsoleLink fightConsoleLink;

    private int heroAttacksDone = 0;
    private boolean monsterBeastMode = false;

    // preparing the fight
    public Fight(Hero hero, Monster monster, FightConsoleLink fightConsoleLink) {
        this.hero = hero;
        this.monster = monster;
        this.fightConsoleLink = fightConsoleLink;

        System.out.println("=========== Welcome to the Dark Forest! ===========");
        System.out.println("(If you want to quit the fight input 'q', for beast mode input 'b'.)");
        System.out.println("Look! There's a monster here!\n");

    }

    @Override
    public void run() {

        // Greetings
        hero.voice();

        try {
            Thread.sleep(Constant.delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        monster.voice();
        try {
            Thread.sleep(Constant.delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Fight
        while (true) {

            if (fightConsoleLink.isExitFight()) break;

            // Hero attack
            boolean attackResult;
            if (fightConsoleLink.isTurnOnBeastMode()) {
                attackResult = hero.attack(monster, true);
                fightConsoleLink.beastModeOff();
                heroAttacksDone = 0;
            } else {
                attackResult = hero.attack(monster, false);
            }
            if (attackResult) break;
            if (++heroAttacksDone >= Constant.HERO_ATTACKS_TO_BEAST_MODE) {
                System.out.println("\n--- BEAST MODE AVAILABLE!!!");
            }

            try {
                Thread.sleep(Constant.delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (fightConsoleLink.isExitFight()) break;

            // Monster attack
            if (monster.attack(hero, false)) break;
            try {
                Thread.sleep(Constant.delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

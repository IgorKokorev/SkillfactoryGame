package game.fight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Runnable {
    FightConsoleLink fightConsoleLink;

    public ConsoleInput(FightConsoleLink fightConsoleLink) {
        this.fightConsoleLink = fightConsoleLink;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (true) {
            try {
                input = br.readLine();
            } catch (IOException e) {
            }

            if (input.equalsIgnoreCase("q")) {
                fightConsoleLink.exitFight();
                System.out.println("================ Command: EXIT FIGHT! ====================");
                break;
            }

            if (input.equalsIgnoreCase("b")) {
                System.out.println("================ Command: BEAST MODE! ====================");
                fightConsoleLink.beastModeOn();
            }
        }
    }
}

package game.fight;

public class FightConsoleLink {
    private boolean turnOnBeastMode = false;
    private boolean exitFight = false;

    public synchronized boolean isTurnOnBeastMode() {
        return turnOnBeastMode;
    }

    public synchronized boolean isExitFight() {
        return exitFight;
    }

    public synchronized void exitFight() {
        this.exitFight = true;
    }

    public synchronized void beastModeOn() {
        this.turnOnBeastMode = true;
    }

    public synchronized void beastModeOff() {
        this.turnOnBeastMode = false;
    }
}

package game.characters;

public interface Fightable {
    // Return true if Character is dead after the hit
    public boolean attack(Character character, boolean beastMode);
    // Return true if you're hit after been hit
    public boolean gethit(int force);
    // Voice before fight
    public void voice();
    // voice before attack
    public void voiceAttack();
    // voice when you're dead
    public void voiceDead();
    // voice when enemy missed
    public void voiceYouMissed();
    // voice when your hit is crit
    public void voiceCrit();
    // voice when you're hit
    public void voiceBeenHit(int force);
    // voice when a character is in the beast mode
    public void voiceBeastMode();

}

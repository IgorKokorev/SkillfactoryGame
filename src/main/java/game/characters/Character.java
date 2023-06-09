package game.characters;

import game.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
abstract public  class Character implements Fightable{
    private String name;
    private int currentLevel;

    private int currentHp;
    private int maxHp;
    private int agility;
    private int Exp;
    private int force;
    private int armor;
    private int critHitChance;
    private int gold;


    public void setHp(int hp) {
        if (hp > this.getMaxHp()) this.currentHp = this.getMaxHp();
        else this.currentHp = hp;
    }
    private int hitForce() {
        Random rng = new Random();
        return this.agility > rng.nextInt(100) ? this.force : 0;
    }

    private boolean isCrit() {
        Random rng = new Random();
        return this.critHitChance > rng.nextInt(100);
    }

    @Override
    public boolean attack(Character character, boolean beastMode) {
        System.out.println("\n" + this.getName() + " attacks.");
        int hitForce = hitForce();
        if (hitForce == 0) {
            character.voiceYouMissed();
            return false;
        }

        if (isCrit()) {
            this.voiceCrit();
            hitForce *= Constant.CRITICAL_HIT_MULTIPLIER;
        }

        if (beastMode) {
            this.voiceBeastMode();
            hitForce *= Constant.BEAST_MODE_MULTIPLIER;
        }
        return character.gethit(hitForce);
    }

    @Override
    public boolean gethit(int force) {
        if (this.currentHp <= force) {
            this.currentHp = 0;
            this.voiceDead();
            return true;
        } else {
            this.currentHp -= force;
            this.voiceBeenHit(force);
            return false;
        }
    }

    @Override
    public void voiceCrit() {
        System.out.println(this.name + ": I'm lucky! Critical hit!");
    }

    @Override
    public void voiceBeastMode() {
        System.out.println(this.name + ": I'M FURIOUS!!! SUPER HIT!");
    }

    public void print() {
        System.out.println(this);
    }
}

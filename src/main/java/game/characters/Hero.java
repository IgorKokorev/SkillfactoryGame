package game.characters;

import game.Constant;


public class Hero extends Character {

    public Hero(String name) {
        this.setName(name);
        this.setCurrentLevel(0);
        setLevelStats();
        this.setExp(Constant.HERO_EXP_LEVEL[0]);
        this.setHp(this.getMaxHp());
        this.setGold(Constant.HERO_START_GOLD);
    }

    private void setLevelStats() {
        this.setMaxHp(Constant.HERO_MAX_HP[this.getCurrentLevel()]);
        this.setAgility(Constant.HERO_AGILITY[this.getCurrentLevel()]);
        this.setForce(Constant.HERO_FORCE[this.getCurrentLevel()]);
        this.setArmor(this.getCurrentLevel());
        this.setCritHitChance(Constant.HERO_CRIT[this.getCurrentLevel()]);
    }

    public boolean levelUp() {
        if (this.getCurrentLevel() == Constant.MAX_LEVEL) return false;
        this.setCurrentLevel(this.getCurrentLevel() + 1);
        setLevelStats();
        this.setHp(this.getMaxHp() - Constant.HERO_MAX_HP[this.getCurrentLevel() - 1] + this.getCurrentHp());
        this.setExp(this.getExp() - Constant.HERO_EXP_LEVEL[this.getCurrentLevel()]);
        return true;
    }

    @Override
    public void voice() {
        System.out.println(this.getName() + ": Hi stranger! I'm valiant knight " + this.getName() + ". Who are you?");
    }

    @Override
    public void voiceAttack() {
        System.out.println(this.getName() + ": Prepare for my attack!");
    }

    @Override
    public void voiceDead() {
        System.out.println(this.getName() + ": You've killed me, filthy animal!");

    }

    @Override
    public void voiceYouMissed() {
        System.out.println(this.getName() + ": You've missed! Ha-ha!");

    }

    @Override
    public void voiceBeenHit(int force) {
        System.out.println(this.getName() + ": You'he hit me, monster! I lost " + force + " health and I only have " + this.getCurrentHp() + "left...");

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Hero:\n");
        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getCurrentLevel() + "\n");
        result.append("Health: " + this.getCurrentHp() + "\n");
        result.append("Max health: " + this.getMaxHp() + "\n");
        result.append("Agility: " + this.getAgility() + "\n");
        result.append("Experience points: " + this.getExp() + "\n");
        result.append("Force: " + this.getForce() + "\n");
        result.append("Critical hit chance: " + this.getCritHitChance() + "\n");
        result.append("Gold: " + this.getGold() + "\n");
        return result.toString();
    }
}

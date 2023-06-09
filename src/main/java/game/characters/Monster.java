package game.characters;


public class Monster extends Character {
    Type type;

    enum Type {Goblin, Skeleton}

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void voice() {
        System.out.println(this.getName() + ": Grrr! I'm an awful " + this.type + ", my name is " + this.getName() + " and I'll kill you!");
    }

    @Override
    public void voiceAttack() {
        System.out.println(this.getName() + ": Grrr! Die, little hero!");
    }

    @Override
    public void voiceDead() {
        System.out.println(this.getName() + ": Grrr! I can't believe, you killed me!");
    }

    @Override
    public void voiceYouMissed() {
        System.out.println(this.getName() + ": Hrrrrrmrrrr, you missed little hero!");
    }

    @Override
    public void voiceBeenHit(int force) {
        System.out.println(this.getName() + ": Uhrrr! You hit me, little hero! I lost " + force + " health but I still have " + this.getCurrentHp() + "left...");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Monster:\n");
        result.append("Type: " + this.getType() + "\n");
        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getCurrentLevel() + "\n");
        result.append("Health: " + this.getCurrentHp() + "\n");
        result.append("Agility: " + this.getAgility() + "\n");
        result.append("Force: " + this.getForce() + "\n");
        result.append("Critical hit chance: " + this.getCritHitChance() + "\n");
        return result.toString();
    }
}

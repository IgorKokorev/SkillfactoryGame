package game.characters;

import game.Constant;

import java.util.Random;

public class MonsterFactory {

    String[] monstersNames = {"Grum", "Strumble", "Hurrum", "Arggamble", "Baaramburr", "Torrum", "Dramble"};
    public Monster getMonster(int level) {
        if (level >= Constant.MAX_LEVEL) return null;

        Random rng = new Random();

        // creating empty monster
        Monster monster = new Monster();

        // setting type
        if (rng.nextInt(2) == 0) monster.setType(Monster.Type.Goblin);
        else monster.setType(Monster.Type.Skeleton);

        // Giving random name
        monster.setName(monstersNames[rng.nextInt(monstersNames.length)]);

        // setting level
        monster.setCurrentLevel(level);

        // health
        monster.setMaxHp(Constant.MONSTER_MAX_HP[level]);
        monster.setHp(monster.getMaxHp());

        // random agility
        monster.setAgility(rng.nextInt(Constant.MONSTER_MIN_AGILITY[level], Constant.MONSTER_MAX_AGILITY[level]));

        // Exp points to earn when the monster is dead
        monster.setExp(Constant.MONSTER_EXP[level]);

        // force
        monster.setForce(Constant.MONSTER_FORCE[level]);

        // armor
        monster.setArmor(0);

        // crit hit chance
        monster.setCritHitChance(Constant.MONSTER_CRIT[level]);

        // gold to earn when the monster is dead
        monster.setGold(Constant.MONSTER_GOLD[level]);

        return monster;
    }
}

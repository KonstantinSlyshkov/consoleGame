package com.slyshkov.interactions;

import com.slyshkov.characters.monsters.Monster;

import java.util.Random;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class MonstersLvlUp {

	public static Monster upMonster(Monster monster, int lvl) {
		int monsterLvl = new Random().nextInt(lvl) + 1;
		for (int i = 1; i < monsterLvl; i++) {
			monster.getParameters().setHitPoints((int) (monster.getParameters().getHitPoints() * 1.4));
			monster.getParameters().setManaPoints((int) (monster.getParameters().getManaPoints() * 1.1));
			monster.getParameters().setLvl(monster.getParameters().getLvl() + 1);
			monster.getParameters().setAgility((int) (monster.getParameters().getAgility() * 1.1));
			monster.getParameters().setAttack((int) (monster.getParameters().getAttack() * 1.4));
			monster.getParameters().setDefence((int) (monster.getParameters().getDefence() * 1.2));
			monster.getParameters().setExperience((int) (monster.getParameters().getExperience() * 1.4));
		}
		return monster;
	}
}

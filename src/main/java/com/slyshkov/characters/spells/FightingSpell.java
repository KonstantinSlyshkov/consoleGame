package com.slyshkov.characters.spells;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public abstract class FightingSpell implements Spell {
	protected int manaCost;
	protected int pointsEffected;

	public void castSpell(Hero hero, Monster monster) {
		if (hero.getParameters().getManaPoints() < manaCost) {
			System.out.println("Unable to cast magic. Lack of mana");
			return;
		}
		int leftHp = monster.getParameters().getHitPoints() - pointsEffected;
		monster.getParameters().setHitPoints(leftHp);
		if (monster.getParameters().getHitPoints() <= 0) {
			hero.slainTheMonster(monster, leftHp);
		}
		hero.getParameters().setManaPoints(hero.getParameters().getManaPoints() - manaCost);
	}

}

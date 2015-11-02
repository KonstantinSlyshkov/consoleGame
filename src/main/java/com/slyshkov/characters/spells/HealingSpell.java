package com.slyshkov.characters.spells;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public abstract class HealingSpell implements Spell {
	protected int manaCost;
	protected int pointsEffected;

	public void castSpell(Hero hero, Monster monster) {
		int newHP = hero.getParameters().getHitPoints() + pointsEffected;
		if (newHP > hero.getMaxHp()) {
			hero.getParameters().setHitPoints(hero.getMaxHp());
		} else {
			hero.getParameters().setHitPoints(newHP);
		}
		System.out.println("Your hp = " + hero.getParameters().getHitPoints());
		hero.getParameters().setManaPoints(hero.getParameters().getManaPoints() - manaCost);
	}


}

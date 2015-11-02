package com.slyshkov.interactions;

import com.slyshkov.characters.heroes.Hero;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class WarriorLvlUp {

	public Hero upHero(Hero hero) {
		hero.setMaxExperience((int) (hero.getMaxExperience() * 1.7));
		hero.setMaxHp((int) (hero.getMaxHp() * 1.7));
		hero.getParameters().setManaPoints((int) (hero.getParameters().getManaPoints() * 1.2));
		hero.getParameters().setLvl(hero.getParameters().getLvl() + 1);
		hero.getParameters().setAgility((int) (hero.getParameters().getAgility() * 1.3));
		hero.getParameters().setAttack((int) (hero.getParameters().getAttack() * 1.5));
		hero.getParameters().setDefence((int) (hero.getParameters().getDefence() * 1.6));
		System.out.println("Congratulations you just riched lvl " + hero.getParameters().getLvl());
		return hero;
	}
}

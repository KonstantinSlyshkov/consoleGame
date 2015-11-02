package com.slyshkov.interactions;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.spells.IceBlast;

/**
 * Created by Kostiantyn_Slyshkov on 11/2/2015.
 */
public class WizardLvlUp {
	public Hero upHero(Hero hero) {
		hero.setMaxExperience((int) (hero.getMaxExperience() * 1.7));
		hero.setMaxHp((int) (hero.getMaxHp() * 1.5));
		hero.getParameters().setManaPoints((int) (hero.getParameters().getManaPoints() * 1.4));
		hero.getParameters().setLvl(hero.getParameters().getLvl() + 1);
		hero.getParameters().setAgility((int) (hero.getParameters().getAgility() * 1.5));
		hero.getParameters().setAttack((int) (hero.getParameters().getAttack() * 1.4));
		hero.getParameters().setDefence((int) (hero.getParameters().getDefence() * 1.4));
		if (hero.getParameters().getLvl() == 2) {
			hero.addSkill(new IceBlast());
			System.out.println("congratulations you gained new Skill");
		}
		System.out.println("Congratulations you just riched lvl " + hero.getParameters().getLvl());
		return hero;
	}
}

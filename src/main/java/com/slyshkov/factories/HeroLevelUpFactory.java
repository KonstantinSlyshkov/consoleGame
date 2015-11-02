package com.slyshkov.factories;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.heroes.Thief;
import com.slyshkov.characters.heroes.Wizard;
import com.slyshkov.enums.Heroes;
import com.slyshkov.interactions.ThiefLvlUp;
import com.slyshkov.interactions.WarriorLvlUp;
import com.slyshkov.interactions.WizardLvlUp;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class HeroLevelUpFactory {

	public static Hero upLevel(Heroes heroes, Hero hero) {
		switch (heroes) {
			case Warrior:
				return new WarriorLvlUp().upHero(hero);
			case Thief:
				return new ThiefLvlUp().upHero(hero);
			case Wizard:
				return new WizardLvlUp().upHero(hero);
			default:
				throw new UnsupportedOperationException("unable to update hero");
		}
	}
}

package com.slyshkov.factories;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.heroes.Thief;
import com.slyshkov.characters.heroes.Warrior;
import com.slyshkov.characters.heroes.Wizard;
import com.slyshkov.characters.parameters.BasicParameters;
import com.slyshkov.characters.spells.HealingSpellLvlOne;
import com.slyshkov.enums.Heroes;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class HeroFactory {

	public static Hero getHero(Heroes hero) {

		switch (hero) {
			case Warrior:
				return new Warrior(BasicParameters.newBuilder().setAttack(15).setDefence(9).setAgility(6).setExperience(0).setHitPoints(100).setLvl(1).setManaPoints(20).build());
			case Thief:
				return new Thief(BasicParameters.newBuilder().setAttack(13).setDefence(10).setAgility(10).setExperience(0).setHitPoints(90).setLvl(1).setManaPoints(0).build());
			case Wizard:
				return new Wizard(BasicParameters.newBuilder().setAttack(7).setDefence(7).setAgility(8).setExperience(0).setHitPoints(70).setLvl(1).setManaPoints(50).build());
			default:
				throw new UnsupportedOperationException("unable to create a hero");
		}
	}
}

package com.slyshkov.characters.heroes;

import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.characters.parameters.BasicParameters;
import com.slyshkov.enums.Heroes;
import com.slyshkov.factories.HeroLevelUpFactory;


/**
 * Created by Kostiantyn_Slyshkov on 11/2/2015.
 */
public class Thief extends Hero {

	public Thief(BasicParameters parameters) {
		super(parameters);
	}

	@Override
	public void slainTheMonster(Monster monster, int leftHP) {
		System.out.println("You are just slained the Goblin, gained " + monster.getParameters().getExperience() + " exp\n");
		int currentExp = getParameters().getExperience() + monster.getParameters().getExperience();
		if (getMaxExperience() <= currentExp) {
			HeroLevelUpFactory.upLevel(Heroes.Thief, this);
		}
		getParameters().setExperience(currentExp);
		monster.getParameters().setHitPoints(leftHP);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


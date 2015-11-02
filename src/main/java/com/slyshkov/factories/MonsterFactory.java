package com.slyshkov.factories;

import com.slyshkov.characters.monsters.Goblin;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.characters.parameters.BasicParameters;
import com.slyshkov.enums.Monsters;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class MonsterFactory {

	public static Monster getMonster(Monsters monster) {

		switch (monster) {
			case GOBLIN:
				return new Goblin(BasicParameters.newBuilder().setAttack(13).setDefence(8).setAgility(4).setExperience(10).setHitPoints(70).setLvl(1).build());
			default:
				throw new UnsupportedOperationException("unable to create a monster");
		}
	}
}

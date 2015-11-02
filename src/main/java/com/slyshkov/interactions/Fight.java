package com.slyshkov.interactions;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;

import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class Fight {

	public static void start(Hero hero, Map<Integer, Monster> monsters) {
		if (monsters.size() >= 1) {
			int counter = monsters.size();
			while (hero.getParameters().getHitPoints() > 0 && counter != 0) {
				hero.hitTheMonster(monsters.get(counter-1));
				for (int monsterNumber = 0; monsterNumber < counter; monsterNumber++) {
					if (monsters.get(counter-1).getParameters().getHitPoints()<=0) {
						counter--;
					} else if (counter != 0) {
						monsters.get(monsterNumber).hitTheHero(hero);
					}
				}
			}
		}

	}
}

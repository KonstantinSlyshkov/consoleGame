package com.slyshkov.interactions;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.menues.FightMenu;

import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class WorldInteraction {

	public void interact(Hero hero, BufferedReader bufferedReader) {
		Map<Integer, Monster> monstersMap = new MonsterInteraction().generateMonsters(hero);
		System.out.println( "You were attacked by ");
		for (Monster monsterTmp: monstersMap.values()) {
			System.out.println(monsterTmp.getClass().getSimpleName()
					+ " lvl "
					+ monsterTmp.getParameters().getLvl()
					+ "\n");
		}
		new FightMenu(bufferedReader, monstersMap, hero).display();
	}
}

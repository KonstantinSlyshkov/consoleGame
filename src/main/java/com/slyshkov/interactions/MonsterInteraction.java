package com.slyshkov.interactions;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.enums.Monsters;
import com.slyshkov.factories.MonsterFactory;

import java.util.*;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class MonsterInteraction {

	public Map<Integer, Monster> generateMonsters(Hero hero) {
		Map<Integer, Monster> monsterMap = new HashMap<Integer, Monster>();
		Random random = new Random();
		int monsterNumbers = random.nextInt(3) + 1;
		List<Monsters> values = Collections.unmodifiableList(Arrays.asList(Monsters.values()));
		Monsters monster = values.get(random.nextInt(values.size()));
		switch (monster) {
			case GOBLIN:
				createGoblins(hero, monsterNumbers, monsterMap);
				break;
			default:
				throw new UnsupportedOperationException("no such monster");
		}
		return monsterMap;
	}

	private Map<Integer, Monster> createGoblins(Hero hero, int monsterNumbers, Map<Integer, Monster> monsterMap) {
		for (int monsterNumber = 0; monsterNumber < monsterNumbers; monsterNumber++) {
			int lvl = hero.getParameters().getLvl();
			Monster generatedMonster = MonstersLvlUp.upMonster(MonsterFactory.getMonster(Monsters.GOBLIN), lvl);
			monsterMap.put(monsterNumber, generatedMonster);
		}
		return monsterMap;
	}
}

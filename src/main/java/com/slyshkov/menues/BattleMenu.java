package com.slyshkov.menues;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.characters.spells.Spell;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/27/2015.
 */
public class BattleMenu extends Menu {

	private BufferedReader bufferedReader;
	private Map<Integer, Monster> monsterMap;
	private Hero hero;

	public BattleMenu(BufferedReader bufferedReader, Map<Integer, Monster> monsterMap, Hero hero) {
		this.bufferedReader = bufferedReader;
		this.hero = hero;
		this.monsterMap = monsterMap;
	}

	@Override
	public void display() {
		System.out.println("1.Hit the monster\n" +
				"2.Use magic\n" +
				"3.Back to previous menu\n");
		String answer = "";
		try {
			while (answer.isEmpty()) {
				answer = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (answer.equals("1")) {
			generalHit();
		} else if(answer.equals("2")) {
			castMagic();
		} else if (answer.equals("3")) {
			new FightMenu(bufferedReader, monsterMap, hero).display();
		}
	}

	private void castMagic() {
		String chosenSpell;
		System.out.println("you have " + hero.getParameters().getManaPoints() + " manaPoints");
		if (hero.getSkills().values().isEmpty()) {
			System.out.println("you don't have skills\n");
			new BattleMenu(bufferedReader, monsterMap, hero).display();
		} else {
			for (int count = 1; count <= hero.getSkills().values().size(); count++) {
				System.out.println(count + ". " + hero.getSkills().get(count).getClass().getSimpleName());
			}
		}
		try {
			chosenSpell = bufferedReader.readLine();
			heroCastMagic(chosenSpell);
			new BattleMenu(bufferedReader,monsterMap,hero).display();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void heroCastMagic(String chosenSpell) {
		int counter = monsterMap.size();
		hero.getSkills().get(Integer.parseInt(chosenSpell)).castSpell(hero, monsterMap.get(counter - 1));
		monstersHitHero(counter);
	}

	private void generalHit() {
		int counter = monsterMap.size();
		hero.hitTheMonster(monsterMap.get(counter - 1));
		monstersHitHero(counter);
	}

	private void monstersHitHero(int monsterCounter) {
		for (int monsterNumber = 0; monsterNumber < monsterCounter; monsterNumber++) {
			if (monsterMap.get(monsterCounter-1).getParameters().getHitPoints()<=0) {
				monsterCounter--;
			} else if (monsterCounter != 0) {
				monsterMap.get(monsterNumber).hitTheHero(hero);
			}
		}
		System.out.println("hero hp = " + hero.getParameters().getHitPoints() + "\n");
		if (monsterCounter != 0) {
			for (Monster monster: monsterMap.values()) {
				System.out.println("Monster HP = " + monster.getParameters().getHitPoints() + "\n");
			}
			new BattleMenu(bufferedReader, monsterMap, hero).display();
		} else {
			new WorldMenu(bufferedReader, hero).display();
		}
	}
}

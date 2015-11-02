package com.slyshkov.menues;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.enums.Monsters;
import com.slyshkov.interactions.Fight;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public class FightMenu extends Menu {

	private BufferedReader bufferedReader;
	private Map<Integer, Monster> monsterMap;
	private Hero hero;

	public FightMenu(BufferedReader bufferedReader, Map<Integer, Monster> monstersMap, Hero hero) {
		this.bufferedReader = bufferedReader;
		this.monsterMap = monstersMap;
		this.hero = hero;
	}

	@Override
	public void display() {
		System.out.println("1.Fight\n" +
				"2.AutoFight\n" +
				"3.Retreat\n");
		String answer = "";
		try {
			while (answer.isEmpty()) {
				answer = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (answer.equals("1")) {
			new BattleMenu(bufferedReader, monsterMap, hero).display();
			new WorldMenu(bufferedReader, hero).display();
		} else if (answer.equals("2")) {
			Fight.start(hero, monsterMap);
			new WorldMenu(bufferedReader, hero).display();
		} else if (answer.equals("3")) {
			System.out.println("You successfully escaped\n");
			new WorldMenu(bufferedReader, hero).display();
		}
	}
}

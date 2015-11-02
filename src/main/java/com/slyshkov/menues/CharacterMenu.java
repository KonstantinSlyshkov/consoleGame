package com.slyshkov.menues;

import com.slyshkov.Engine;
import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.heroes.Warrior;
import com.slyshkov.characters.parameters.BasicParameters;
import com.slyshkov.enums.Heroes;
import com.slyshkov.factories.HeroFactory;
import com.slyshkov.menues.Menu;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public class CharacterMenu extends Menu {

	private BufferedReader bufferedReader;
	private Hero hero;

	public CharacterMenu(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void display() {
		System.out.println("1.Warrior(medium parameters can use healing magic)\n"
				+ "2.Wizzard(strong magical skill, but weak resistances to physical damage)\n"
				+ "3.Thief(high evasion, but not as strong as a Warrior)\n" +
				"4.Get back\n");
		String answer = "";
		try {
			while (answer.isEmpty()) {
				answer = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (answer.equals("1")) {
			hero = HeroFactory.getHero(Heroes.Warrior);
		} else if (answer.equals("2")) {
			hero = HeroFactory.getHero(Heroes.Wizard);
		} else if (answer.equals("3")) {
			hero = HeroFactory.getHero(Heroes.Thief);
		} else if (answer.equals("4")){
			Engine.start();
		}
		new WorldMenu(bufferedReader, hero).display();
	}
}

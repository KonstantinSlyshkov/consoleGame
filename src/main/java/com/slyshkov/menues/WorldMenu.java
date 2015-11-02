package com.slyshkov.menues;

import com.slyshkov.Engine;
import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.interactions.WorldInteraction;

import java.io.*;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class WorldMenu extends Menu {

	private BufferedReader bufferedReader;
	private Hero hero;

	public WorldMenu(BufferedReader bufferedReader, Hero hero) {
		this.bufferedReader = bufferedReader;
		this.hero = hero;
	}

	@Override
	public void display() {
		System.out.println("1.Explore the world\n" +
				"2.Current hero status\n" +
				"3.Take rest\n" +
				"4.Save progress\n" +
				"5.Go to main menu\n");
		String answer = "";
		while (answer.isEmpty()) {
			try {
				answer = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (answer.equals("1")) {
				new WorldInteraction().interact(hero, bufferedReader);
			} else if (answer.equals("2")) {
				showHeroCharacteristics(answer);
			} else if (answer.equals("3")) {
				takingRest();
			} else if (answer.equals("4")) {
				saveGame();
			} else if (answer.equals("5")) {
				Engine.start();
			}
		}
	}

	private void showHeroCharacteristics(String answer) {
		showParameters();
		try {
			answer = bufferedReader.readLine();
			if (answer.equals("1")) {
				new WorldMenu(bufferedReader, hero).display();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void takingRest() {
		System.out.println("After hard day you decided to take a sleep and get some rest\n");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hero.getParameters().setHitPoints(hero.getMaxHp());
		hero.getParameters().setManaPoints(hero.getMaxMana());
		new WorldMenu(bufferedReader, hero).display();
	}

	private void saveGame() {
		try {
			OutputStream file = new FileOutputStream("saveGame.txt");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(hero);
			output.flush();
			buffer.close();
			file.close();
			System.out.println("game was successfully saved");
			new WorldMenu(bufferedReader, hero).display();
		} catch (IOException ex) {
			throw new UnsupportedOperationException("unable to save the game");
		}
	}

	public void showParameters() {
		System.out.println("Current Hp " + hero.getParameters().getHitPoints() + "\n" +
				"Max HP " + hero.getMaxHp() + "\n" +
				"Current Mp " + hero.getParameters().getManaPoints() + "\n" +
				"Current Defence " + hero.getParameters().getDefence() + "\n" +
				"Current Attack " + hero.getParameters().getAttack() + "\n" +
				"Yours LVL " + hero.getParameters().getLvl() + "\n" +
				"Current Agility " + hero.getParameters().getAgility() + "\n" +
				"Current Experience " + hero.getParameters().getExperience() + "\n" +
				"Experience to next lvl " + (hero.getMaxExperience() - hero.getParameters().getExperience()) + "\n" +
				"1.Get back to the world\n");
	}
}

package com.slyshkov.characters.monsters;

import com.slyshkov.Engine;
import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.parameters.BasicParameters;

import java.util.Random;

/**
 * Created by Kostiantyn_Slyshkov on 10/24/2015.
 */
public class Goblin extends Monster {

	public Goblin(BasicParameters parameters) {
		super(parameters);
	}

	@Override
	public boolean hitTheHero(Hero hero) {
		int damage = modifyDamage(hero);
		int leftHP = hero.getParameters().getHitPoints() - damage;
		if (damage == 0) {
			System.out.println("goblin just missed\n");
		} else if (leftHP <= 0) {
			slainTheHero(hero, leftHP);
		} else {
			damageToHero(hero, damage, leftHP);
		}
		return true;
	}

	private void damageToHero(Hero hero, int damage, int leftHP) {
		System.out.println("goblin has hit you in " + damage + " dmg\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hero.getParameters().setHitPoints(leftHP);
	}

	private void slainTheHero(Hero hero, int leftHP) {
		System.out.println("You were, slained by " + "Goblin\n");
		hero.getParameters().setHitPoints(leftHP);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Engine.start();
	}

}

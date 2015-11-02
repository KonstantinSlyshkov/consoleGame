package com.slyshkov.characters.monsters;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.parameters.BasicParameters;

import java.util.Random;


/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public abstract class Monster {

	private BasicParameters parameters;

	public Monster(BasicParameters parameters) {
		this.parameters = parameters;
	}

	public abstract boolean hitTheHero(Hero hero);

	public BasicParameters getParameters() {
		return parameters;
	}

	public void setParameters(BasicParameters parameters) {
		this.parameters = parameters;
	}

	protected int modifyDamage(Hero hero) {
		boolean chanceForCrit = new Random().nextInt(13)==0;
		int agilityDifference = getParameters().getAgility() - hero.getParameters().getAgility();
		if (agilityDifference <= 0) {
			agilityDifference = 1;
		}
		boolean heroChanceToEvade = new Random().nextInt(agilityDifference * 12)==0;
		int damage = getParameters().getAttack() - hero.getParameters().getDefence();
		if (damage <= 0){
			damage = 1;
		} if (chanceForCrit) {
			damage = damage * 2;
		} if (heroChanceToEvade) {
			damage = 0;
		}
		return damage;
	}
}

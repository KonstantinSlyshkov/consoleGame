package com.slyshkov.characters.heroes;

import com.slyshkov.characters.parameters.BasicParameters;
import com.slyshkov.characters.spells.FightingSpell;
import com.slyshkov.characters.monsters.Monster;
import com.slyshkov.characters.spells.HealingSpell;
import com.slyshkov.characters.spells.Spell;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public abstract class Hero implements Serializable {
	private int quantitySkills = 1;
	protected int maxHp;
	protected int maxMana;
	protected int maxExperience = 100;
	protected Map<Integer,Spell> skills = new HashMap<Integer, Spell>();

	private BasicParameters parameters;

	public Hero(BasicParameters parameters) {
		this.parameters = parameters;
		System.out.println("You successfully created new character\r" +
				"THE STORY HAS BEGUN\n");
		this.maxHp = this.getParameters().getHitPoints();
		this.maxMana = this.getParameters().getManaPoints();
	}

	public boolean hitTheMonster(Monster monster) {
		int damage = modifyDamage(monster);
		int leftHP = monster.getParameters().getHitPoints() - damage;
		if (damage == 0) {
			System.out.println("you just missed\n");
		} else if (leftHP <= 0) {
			slainTheMonster(monster, leftHP);
		} else {
			damageToMonster(monster, damage, leftHP);
		}
		return true;
	}

	private void damageToMonster(Monster monster, int damage, int leftHP) {
		System.out.println("you have made " + damage + " dmg\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monster.getParameters().setHitPoints(leftHP);
	}

	private int modifyDamage(Monster monster) {
		boolean chanceForCrit = new Random().nextInt(10)==0;
		int agilityDifference = getParameters().getAgility() - monster.getParameters().getAgility();
		if (agilityDifference <= 0 ) {
			agilityDifference = 1;
		}
		boolean monsterChanceToEvade = new Random().nextInt(agilityDifference * 12)==0;
		int damage = getParameters().getAttack() - monster.getParameters().getDefence();
		if (damage <= 0){
			damage = 1;
		} if (chanceForCrit) {
			damage = damage * 2;
		} if (monsterChanceToEvade) {
			damage = 0;
		}
		return damage;
	}

	public abstract void slainTheMonster(Monster monster, int leftHP);

	public BasicParameters getParameters() {
		return parameters;
	}

	public void setParameters(BasicParameters parameters) {
		this.parameters = parameters;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}

	public Map<Integer,Spell> getSkills() {
		return skills;
	}

	public void addSkill(Spell spell) {
		skills.put(quantitySkills++, spell);
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
}

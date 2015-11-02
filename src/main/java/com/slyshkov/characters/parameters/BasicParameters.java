package com.slyshkov.characters.parameters;

import java.io.Serializable;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public class BasicParameters implements Serializable {
	private int hitPoints;
	private int manaPoints;
	private int attack;
	private int defence;
	private int agility;
	private int lvl;
	private int experience;

	private BasicParameters() {
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public static Builder newBuilder() {
		return new BasicParameters().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setHitPoints(int hitPoints) {
			BasicParameters.this.setHitPoints(hitPoints);
			return this;
		}

		public Builder setAttack(int attack) {
			BasicParameters.this.setAttack(attack);
			return this;
		}

		public Builder setManaPoints(int manaPoints) {
			BasicParameters.this.setManaPoints(manaPoints);
			return this;
		}

		public Builder setDefence(int defence) {
			BasicParameters.this.setDefence(defence);
			return this;
		}

		public Builder setAgility(int evasion) {
			BasicParameters.this.setAgility(evasion);
			return this;
		}

		public Builder setLvl(int lvl) {
			BasicParameters.this.setLvl(lvl);
			return this;
		}

		public Builder setExperience(int experience) {
			BasicParameters.this.setExperience(experience);
			return this;
		}

		public BasicParameters build(){
			return BasicParameters.this;
		}
	}
}

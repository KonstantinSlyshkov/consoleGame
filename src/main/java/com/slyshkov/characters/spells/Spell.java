package com.slyshkov.characters.spells;

import com.slyshkov.characters.heroes.Hero;
import com.slyshkov.characters.monsters.Monster;

import java.io.Serializable;

/**
 * Created by Kostiantyn_Slyshkov on 10/27/2015.
 */
public interface Spell extends Serializable {
	void castSpell(Hero hero, Monster monster);
}

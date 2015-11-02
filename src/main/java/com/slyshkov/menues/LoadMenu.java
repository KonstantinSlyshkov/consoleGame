package com.slyshkov.menues;

import com.slyshkov.characters.heroes.Hero;

import java.io.*;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public class LoadMenu extends Menu {

	private BufferedReader bufferedReader;
	public LoadMenu(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void display() {
		try {
			InputStream file = new FileInputStream("saveGame.txt");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			Hero loadedHero = (Hero) input.readObject();
			System.out.println("Save was successfully loaded");
			new WorldMenu(bufferedReader, loadedHero).display();
		}
			catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
	}
}

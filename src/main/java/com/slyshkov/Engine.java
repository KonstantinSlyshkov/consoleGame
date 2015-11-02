package com.slyshkov;

import com.slyshkov.menues.CharacterMenu;
import com.slyshkov.menues.LoadMenu;
import com.slyshkov.menues.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kostiantyn_Slyshkov on 10/23/2015.
 */
public class Engine {

	private static Menu menu;

	public static void start() {
		System.out.println("1. new Game \n" + "2. Load game\n" + "3. Exit\n");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = "";
			while (s.isEmpty()) {
				s = bufferRead.readLine();
			}
			if (s.equals("1")){
				menu = new CharacterMenu(bufferRead);
			} else if (s.equals("2")) {
				menu = new LoadMenu(bufferRead);
			} else if (s.equals("3")) {
				System.exit(0);
			}
			menu.display();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

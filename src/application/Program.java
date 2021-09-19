package application;

import java.util.Scanner;

import model.entities.Game;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Game game = new Game();
		game.menuPrincipal();
		
		sc.close();
	}

}

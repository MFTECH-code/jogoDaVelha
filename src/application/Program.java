package application;

import model.entities.Game;

public class Program {

	public static void main(String[] args) {

		Game game = Game.getInstance();
		while (true) {
			game.menuPrincipal();
			if (!game.isGameContinue()) {
				break;
			}
		}
	
	}

}

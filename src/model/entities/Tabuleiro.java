package model.entities;

import model.enums.JogadoresEnum;

public class Tabuleiro {
	private JogadoresEnum [][] tabuleiro = new JogadoresEnum [3][3];

	public Tabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; i< tabuleiro[i].length; j++) {
				tabuleiro[i][j] = JogadoresEnum.N;
			}
		}
	}

	public JogadoresEnum[][] getTabuleiro() {
		return tabuleiro;
	}
	
}

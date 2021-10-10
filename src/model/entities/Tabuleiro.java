package model.entities;

import model.enums.JogadoresEnum;

public class Tabuleiro {
	private JogadoresEnum [][] tabuleiro = new JogadoresEnum [3][3];

	public Tabuleiro() {
		inicializarTabuleiro();
	}

	public JogadoresEnum[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public void setTabuleiro(JogadoresEnum[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void inicializarTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = JogadoresEnum.N;
			}
		}
	}
	
	public void limparTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = JogadoresEnum.N;
			}
		}
	}
}

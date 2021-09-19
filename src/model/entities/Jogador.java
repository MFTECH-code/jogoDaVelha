package model.entities;

import model.enums.JogadoresEnum;

public class Jogador {
	private JogadoresEnum tipoJogador;
	
	public Jogador() {
		
	}

	public Jogador(JogadoresEnum tipoJogador) {
		this.tipoJogador = tipoJogador;
	}

	public JogadoresEnum getTipoJogador() {
		return tipoJogador;
	}
	
	public boolean posicaoValida(int x, int y, Tabuleiro tabuleiro) {
		if (tabuleiro.getTabuleiro()[x][y].equals(JogadoresEnum.N)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void jogar(int x, int y, Tabuleiro tabuleiro) {
		if (posicaoValida(x, y, tabuleiro)) {
			JogadoresEnum[][] tabuleiroJogada = tabuleiro.getTabuleiro();
			tabuleiroJogada[x][y] = tipoJogador;
			tabuleiro.setTabuleiro(tabuleiroJogada);
		}
	}
}


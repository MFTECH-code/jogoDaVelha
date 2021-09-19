package model.entities;

import java.util.Scanner;

import model.enums.JogadoresEnum;

public class Jogador {
	private JogadoresEnum tipoJogador;
	
	private Scanner sc = new Scanner(System.in);
	
	public Jogador() {
		
	}

	public Jogador(JogadoresEnum tipoJogador) {
		this.tipoJogador = tipoJogador;
	}

	public JogadoresEnum getTipoJogador() {
		return tipoJogador;
	}
	
	public int leiaCordenadaX() {	
		return sc.nextInt();
	}
	
	public int leiaCordenadaY() {
		return sc.nextInt();
	}
	
	public boolean posicaoValida(int x, int y, Tabuleiro tabuleiro) {
		if (tabuleiro.getTabuleiro()[x][y].equals(JogadoresEnum.N)) {
			return false;
		} else {
			return true;
		}
	}
	
	public void jogar(int x, int y, Tabuleiro tabuleiro) {
		if (posicaoValida(x, y, tabuleiro)) {
			tabuleiro.getTabuleiro()[x][y] = this.tipoJogador;
		}
	}
}


package model.entities;

import java.util.Scanner;

import model.enums.JogadoresEnum;

public class Jogador {
	protected JogadoresEnum tipoJogador;
	private int pontuacao;
	
	private Scanner sc = new Scanner(System.in);
	
	public Jogador() {
		
	}

	public Jogador(JogadoresEnum tipoJogador) {
		this.tipoJogador = tipoJogador;
	}

	public JogadoresEnum getTipoJogador() {
		return tipoJogador;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean posicaoValida(int x, int y, Tabuleiro tabuleiro) {
		if (tabuleiro.getTabuleiro()[x][y] == JogadoresEnum.N) {
			return true;
		} else {
			return false;
		}
	}
	
	public void jogar(int x, int y, Tabuleiro tabuleiro) {
		JogadoresEnum[][] tabuleiroJogada = tabuleiro.getTabuleiro();
		
		while (true) {
			if (posicaoValida(x, y, tabuleiro)) {
				tabuleiroJogada[x][y] = tipoJogador;
				tabuleiro.setTabuleiro(tabuleiroJogada);
				break;
			} else {
				System.out.println("POSIÇÃO JÁ OCUPADA...");
				System.out.print("SELECIONE A CORDENADA X: ");
				x = sc.nextInt();
				System.out.print("SELECIONE A CORDENADA Y: ");
				y = sc.nextInt();
				continue;
			}
		}
	}
}


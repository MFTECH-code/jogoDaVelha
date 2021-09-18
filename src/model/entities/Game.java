package model.entities;

import java.util.Scanner;

public class Game {
	private Boolean contraMaquina;
	private Jogador jogador1;
	private Jogador jogador2;
	private int pontuacaoJogador1;
	private int pontuacaoJogador2;
	
	private Tabuleiro tabuleiro;
	
	private Scanner sc = new Scanner(System.in);
	
	public Game() {
		
	}
	
	public Game(Boolean contraMaquina, Jogador jogador1, Jogador jogador2, int pontuacaoJogador1, int pontuacaoJogador2, Tabuleiro tabuleiro) {
		this.contraMaquina = contraMaquina;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.pontuacaoJogador1 = pontuacaoJogador1;
		this.pontuacaoJogador2 = pontuacaoJogador2;
		this.tabuleiro = tabuleiro;
	}

	public Boolean getContraMaquina() {
		return contraMaquina;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public void menuPrincipal() {
		System.out.println("JOGO DA VELHA!");
		System.out.println("SELECIONE AS OPÇÕES DO JOGO");
		System.out.println("1 - JOGADOR X JOGADOR");
		System.out.println("2 - JOGADOR X MÁQUINA (FÁCIL)");
		System.out.println("3 - JOGADOR X MÁQUINA (DIFÍCIL)");
		int option = sc.nextInt();
		if (option == 1) {
			this.contraMaquina = false;
			modoJogador();
		} else {
			this.contraMaquina = true;
			if (option == 2) {
				modoFacil();
			} else if (option == 3) {
				modoDificil();
			}
		}
	}
	
	public void imprimePontuacao() {
		System.out.printf("PONTUAÇÃO: X = %d; O = %d%n", this.pontuacaoJogador1, this.pontuacaoJogador2);
	}
	
	public Jogador verificaVencedor() {
		// ****************** Esse método será modificado ****************
		Jogador ganhador = new Jogador();
		return ganhador;
	}
	
	public void verificaVelha() {
		// ***** Esse método será modificado *****
	}
	
	public void modoJogador() {
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
	}
	
	public void modoFacil() {
		this.jogador1 = new Jogador();
		this.jogador2 = new MaquinaFacil();
	}
	
	public void modoDificil() {
		this.jogador1 = new Jogador();
		this.jogador2 = new MaquinaDificil();
	}

	
}

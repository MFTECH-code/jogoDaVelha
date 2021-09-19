package model.entities;

import java.util.Scanner;

import model.enums.JogadoresEnum;

public class Game {
	private Boolean contraMaquina;
	private Jogador jogador1;
	private Jogador jogador2;
	private int pontuacaoJogador1;
	private int pontuacaoJogador2;
	
	private Tabuleiro tabuleiro;
	
	private Scanner sc = new Scanner(System.in);
	
	public Game() {
		this.tabuleiro = new Tabuleiro();
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
		System.out.println("SELECIONE AS OP��ES DO JOGO");
		System.out.println("1 - JOGADOR X JOGADOR");
		System.out.println("2 - JOGADOR X M�QUINA (F�CIL)");
		System.out.println("3 - JOGADOR X M�QUINA (DIF�CIL)");
		System.out.print("OP��O: ");
		int option = sc.nextInt();
		if (option == 1) {
			this.contraMaquina = false;
			jogador1 = new Jogador(JogadoresEnum.X);
			jogador2 = new Jogador(JogadoresEnum.O);
			modoJogador();
		} else {
			this.contraMaquina = true;
			Jogador jogador = new Jogador(JogadoresEnum.X);
			if (option == 2) {
				modoFacil(jogador);
			} else if (option == 3) {
				modoDificil(jogador);
			}
		}
	}
	
	public void imprimePontuacao() {
		System.out.printf("PONTUA��O: X = %d; O = %d%n", this.pontuacaoJogador1, this.pontuacaoJogador2);
	}
		
	public boolean vitoria(Jogador jogador) {
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			if (this.tabuleiro.getTabuleiro()[i][0] == jogador.getTipoJogador()
					&& this.tabuleiro.getTabuleiro()[i][1] == jogador.getTipoJogador()
					&& this.tabuleiro.getTabuleiro()[i][2] == jogador.getTipoJogador()) {
				return true;
				
			}
			
			if (this.tabuleiro.getTabuleiro()[0][i] == jogador.getTipoJogador()
					&& this.tabuleiro.getTabuleiro()[1][i] == jogador.getTipoJogador()
					&& this.tabuleiro.getTabuleiro()[2][i] == jogador.getTipoJogador()) {
				return true;
				
			}
		}
		
		if (this.tabuleiro.getTabuleiro()[0][0] == jogador.getTipoJogador()
				&& this.tabuleiro.getTabuleiro()[1][1] == jogador.getTipoJogador()
				&& this.tabuleiro.getTabuleiro()[2][2] == jogador.getTipoJogador()) {
			return true;
			
		}
		
		if (this.tabuleiro.getTabuleiro()[0][2] == jogador.getTipoJogador()
				&& this.tabuleiro.getTabuleiro()[1][1] == jogador.getTipoJogador()
				&& this.tabuleiro.getTabuleiro()[2][0] == jogador.getTipoJogador()) {
			return true;
			
		}
		
		return false;
	}
	
	public Jogador verificaVencedor() {
		// Condi��es de vit�ria do jogador1
		if (vitoria(jogador1)) {
			
			return jogador1;
		} else if (vitoria(jogador2)) {
			
			return jogador2;
		} else {
			return null;
		}
	}
	
	public boolean verificaVelha() {
		if (verificaVencedor() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void modoJogador() {
		Jogador vencedor = null;
		
		while (vencedor == null) {
			System.out.printf("JOGADA DE JOGADOR %S: %n", jogador1.getTipoJogador());
			System.out.print("SELECIONE A CORDENADA X: ");
			int x = sc.nextInt();
			System.out.println("SELECIONE A CORDENADA Y: ");
			int y = sc.nextInt();
			
			jogador1.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
			
			System.out.printf("JOGADA DE JOGADOR %S: %n", jogador2.getTipoJogador());
			System.out.print("SELECIONE A CORDENADA X: ");
			x = sc.nextInt();
			System.out.println("SELECIONE A CORDENADA Y: ");
			y = sc.nextInt();
			
			jogador2.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
		}
		
		System.out.printf("JOGADOR %S VENCEU!", vencedor.getTipoJogador());
	}
	
	public void modoFacil(Jogador jogador) {
		this.jogador1 = jogador;
		this.jogador2 = new MaquinaFacil();
	}
	
	public void modoDificil(Jogador jogador) {
		this.jogador1 = jogador;
		this.jogador2 = new MaquinaDificil();
	}
	
	public void imprimirTabuleiro() {
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; j < this.tabuleiro.getTabuleiro()[i].length; j++) {
				System.out.printf("[%S]", tabuleiro.getTabuleiro()[i][j]);
				if (j == 2) {
					// Quebrando linha
					System.out.print("\n");
				}
			}
		}
	}
	
}

package model.entities;

import java.util.Random;
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
	private Random random = new Random();
	
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
		System.out.println("SELECIONE AS OPÇÕES DO JOGO");
		System.out.println("1 - JOGADOR X JOGADOR");
		System.out.println("2 - JOGADOR X MÁQUINA (FÁCIL)");
		System.out.println("3 - JOGADOR X MÁQUINA (DIFÍCIL)");
		System.out.print("OPÇÃO: ");
		int option = sc.nextInt();
		if (option == 1) {
			this.contraMaquina = false;
			jogador1 = new Jogador(JogadoresEnum.X);
			jogador2 = new Jogador(JogadoresEnum.O);
			modoJogador();
		} else {
			this.contraMaquina = true;
			jogador1 = new Jogador(JogadoresEnum.X);
			if (option == 2) {
				jogador2 = new MaquinaFacil(JogadoresEnum.O);
				modoFacil();
			} else if (option == 3) {
				modoDificil(jogador1);
			}
		}
	}
	
	public void imprimePontuacao() {
		System.out.printf("PONTUAÇÃO: X = %d; O = %d%n", this.pontuacaoJogador1, this.pontuacaoJogador2);
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
		// Condições de vitória do jogador1
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
		int contRodadas = 0;
		//boolean variavelVerificadora = false;
		
		while (contRodadas != 9) {
			System.out.printf("JOGADA DE JOGADOR %S: %n", jogador1.getTipoJogador());
			System.out.print("SELECIONE A CORDENADA X: ");
			int x = sc.nextInt();
			System.out.print("SELECIONE A CORDENADA Y: ");
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
			System.out.print("SELECIONE A CORDENADA Y: ");
			y = sc.nextInt();
			
			jogador2.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			contRodadas++;
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
		}
		
		if (vencedor != null) {
			System.out.printf("JOGADOR %S VENCEU!", vencedor.getTipoJogador());			
		} else {
			System.out.println("VELHA!!");
		}
	}
	
	public void modoFacil() {
		Jogador vencedor = null;
		
		while (vencedor == null) {
			System.out.printf("JOGADA DE JOGADOR %S: %n", jogador1.getTipoJogador());
			System.out.print("SELECIONE A CORDENADA X: ");
			int x = sc.nextInt();
			System.out.print("SELECIONE A CORDENADA Y: ");
			int y = sc.nextInt();
			
			System.out.println();
			
			jogador1.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
			
			System.out.println("JOGADA DA MÁQUINA");
			x = random.nextInt(3);
			y = random.nextInt(3);
			
			System.out.println();
			
			jogador2.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
		}
		
		if (vencedor == jogador1) {
			System.out.println("JOGADOR VENCEU!");			
		} else if (vencedor == jogador2) {
			System.out.println("MÁQUINA VENCEU!");
		} else {
			System.out.println("VELHA!");
		}
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

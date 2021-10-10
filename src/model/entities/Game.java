package model.entities;

import java.util.Random;
import java.util.Scanner;

import model.enums.JogadoresEnum;

public class Game {
	private Boolean contraMaquina;
	private Jogador jogador1;
	private Jogador jogador2;
	private int pontuacao1;
	private int pontuacao2;
	private boolean gameContinue = true;
	
	private static Game game = new Game();
	
	private Tabuleiro tabuleiro;
	
	private Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	
	private Game() {
		this.tabuleiro = new Tabuleiro();
	}
	
	public static Game getInstance() {
		return game;
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

	public boolean isGameContinue() {
		return gameContinue;
	}

	public void menuPrincipal() {
		System.out.println("JOGO DA VELHA!");
		System.out.println("SELECIONE AS OPÇÕES DO JOGO");
		System.out.println("1 - JOGADOR X JOGADOR");
		System.out.println("2 - JOGADOR X MÁQUINA (FÁCIL)");
		System.out.println("3 - SAIR");
		System.out.print("OPÇÃO: ");
		int option = sc.nextInt();
		if (option == 1) {
			this.contraMaquina = false;
			jogador1 = new Jogador(JogadoresEnum.X);
			jogador2 = new Jogador(JogadoresEnum.O);
			modoJogador();
		} else if (option == 2) {
			this.contraMaquina = true;
			jogador1 = new Jogador(JogadoresEnum.X);
			if (option == 2) {
				jogador2 = new MaquinaFacil(JogadoresEnum.O);
				modoFacil();
			}
		} else {
			gameContinue = false;
		}
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
			jogador.setPontuacao(jogador.getPontuacao() + 1);
			return true;
		}
		
		return false;
	}
	
	public Jogador verificaVencedor() {
		// Condições de vitória do jogador1
		if (vitoria(jogador1)) {
			pontuacao1++;
			return jogador1;
		} else if (vitoria(jogador2)) {
			pontuacao2++;
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
		int contadorRodadas = 1;
		//boolean variavelVerificadora = false;
		
		imprimePontuacao();
		
		while (vencedor == null) {
			System.out.println("RODADA " + contadorRodadas);
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
			
			if (contadorRodadas >= 5) {
				if (vencedor == null) {
					break;
				}
			}
			
			System.out.printf("JOGADA DE JOGADOR %S: %n", jogador2.getTipoJogador());
			System.out.print("SELECIONE A CORDENADA X: ");
			x = sc.nextInt();
			System.out.print("SELECIONE A CORDENADA Y: ");
			y = sc.nextInt();
			
			jogador2.jogar(x, y, tabuleiro);
			imprimirTabuleiro();
			
			contadorRodadas++;
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
			
			if (contadorRodadas >= 5) {
				if (vencedor == null) {
					break;
				}
			}
		}
		
		if (vencedor != null) {
			System.out.printf("JOGADOR %S VENCEU!", vencedor.getTipoJogador());			
		} else {
			System.out.println("VELHA!!");
		}
		
		tabuleiro.limparTabuleiro();
	}
	
	public void modoFacil() {
		Jogador vencedor = null;
		
		imprimePontuacao();
		int contadorRodadas = 1;
		while (vencedor == null) {
			System.out.println("RODADA: " + contadorRodadas);
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
			
			contadorRodadas++;
			
			
			vencedor = verificaVencedor();
			if (vencedor != null) {
				break;
			}
			
			if (contadorRodadas >= 6) {
				if (vencedor == null) {
					break;
				}
			}
		}
		
		if (vencedor == jogador1) {
			System.out.println("JOGADOR VENCEU!");			
		} else if (vencedor == jogador2) {
			System.out.println("MÁQUINA VENCEU!");
		} else {
			System.out.println("VELHA!");
		}
		
		tabuleiro.limparTabuleiro();
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
	
	public void imprimePontuacao() {
		System.out.println("PLACAR DE PONTUAÇÃO");
		System.out.println("JOGADOR 1: " + pontuacao1);
		System.out.println("JOGADOR 2: " + pontuacao2);
	}

}

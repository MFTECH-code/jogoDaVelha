package model.entities;

import java.util.Scanner;

public class Game {
	private Boolean contraMaquina;
	private Jogador jogador1;
	private Jogador jogador2;
	private int pontuacaoJogador1;
	private int pontuacaoJogador2;
	
	protected Tabuleiro tabuleiro = new Tabuleiro();
	
	private Scanner sc = new Scanner(System.in);
	
	public Game() {
		
	}
	
	public Game(Boolean contraMaquina, Jogador jogador1, Jogador jogador2, int pontuacaoJogador1, int pontuacaoJogador2) {
		this.contraMaquina = contraMaquina;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.pontuacaoJogador1 = pontuacaoJogador1;
		this.pontuacaoJogador2 = pontuacaoJogador2;
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
			Jogador jogador1 = new Jogador();
			Jogador jogador2 = new Jogador();
			modoJogador(jogador1, jogador2);
		} else {
			this.contraMaquina = true;
			Jogador jogador = new Jogador();
			if (option == 2) {
				modoFacil(jogador);
			} else if (option == 3) {
				modoDificil(jogador);
			}
		}
	}
	
	public void imprimePontuacao() {
		System.out.printf("PONTUAÇÃO: X = %d; O = %d%n", this.pontuacaoJogador1, this.pontuacaoJogador2);
	}
	
	public boolean diagonal1(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 0) && (i == 1 && j == 1) && (i == 2 && j == 2)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean diagonal2(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 2) && (i == 1 && j == 1) && (i == 2 && j == 0)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean linha1(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 0) && (i == 1 && j == 0) && (i == 2 && j == 0)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean linha2(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 1) && (i == 1 && j == 1) && (i == 2 && j == 1)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean linha3(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 2) && (i == 1 && j == 2) && (i == 2 && j == 2)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean coluna1(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 0 && j == 0) && (i == 0 && j == 1) && (i == 0 && j == 2)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean coluna2(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 1 && j == 0) && (i == 1 && j == 1) && (i == 1 && j == 2)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public boolean coluna3(Jogador jogador) {
		boolean venceu;
		int count = 0;
		for (int i = 0; i < this.tabuleiro.getTabuleiro().length; i++) {
			for (int j = 0; i < this.tabuleiro.getTabuleiro()[i].length; j++) {
				if ((i == 2 && j == 0) && (i == 2 && j == 1) && (i == 2 && j == 2)) {
					this.tabuleiro.getTabuleiro()[i][j].equals(jogador.getTipoJogador());
					count++;
				}
			}
		}
		if (count == 3) {
			venceu = true;
		} else {
			venceu = false;
		}
		
		return venceu;
	}
	
	public Jogador verificaVencedor() {
		// Condições de vitória do jogador1
		if (diagonal1(jogador1) 
				|| diagonal2(jogador1) 
				|| linha1(jogador1) 
				|| linha2(jogador1) 
				|| linha3(jogador1)
				|| coluna1(jogador1)
				|| coluna2(jogador1)
				|| coluna3(jogador1)) {
			
			return jogador1;
		} else if (diagonal1(jogador2) 
				|| diagonal2(jogador2) 
				|| linha1(jogador2) 
				|| linha2(jogador2) 
				|| linha3(jogador2)
				|| coluna1(jogador2)
				|| coluna2(jogador2)
				|| coluna3(jogador2)) {
			
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
	
	public void modoJogador(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}
	
	public void modoFacil(Jogador jogador) {
		this.jogador1 = jogador;
		this.jogador2 = new MaquinaFacil();
	}
	
	public void modoDificil(Jogador jogador) {
		this.jogador1 = jogador;
		this.jogador2 = new MaquinaDificil();
	}
	
}

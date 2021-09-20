package model.entities;

import java.util.Random;

import model.enums.JogadoresEnum;

public class MaquinaFacil extends Jogador {
	
	private Random random = new Random();
	
	public MaquinaFacil(JogadoresEnum tipoJogador) {
		super.tipoJogador = tipoJogador;
	}
	
	public boolean tabuleiroCheio(Tabuleiro tabuleiro) {
		for (int i = 0; i < tabuleiro.getTabuleiro().length; i++) {
			for(int j = 0; j < tabuleiro.getTabuleiro()[i].length; j++) {
				if (tabuleiro.getTabuleiro()[i][j] == JogadoresEnum.N) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void jogar(int x, int y, Tabuleiro tabuleiro) {
		JogadoresEnum[][] tabuleiroJogada = tabuleiro.getTabuleiro();
		
		while (true) {
			if (tabuleiroCheio(tabuleiro)){
				break;
			} else {
				
				if (posicaoValida(x, y, tabuleiro)) {
					tabuleiroJogada[x][y] = tipoJogador;
					tabuleiro.setTabuleiro(tabuleiroJogada);
					break;
				} else {
					x = random.nextInt(3);
					y = random.nextInt(3);
					continue;
				}
			}
			
		}
			
			
	}
	
	
}

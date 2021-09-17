import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Labirinto {
	private static final char TAMANHO = 24;  // tabuleiro quadrado
	private static final double PROBABILIDADE = 0.2;

	private static final char PAREDE_HORIZONTAL = '-';
	private static final char PAREDE_VERTICAL = '|';
	private static final char PAREDE_ESQUINA = '+';
	private static final char OBSTACULO = 'L';
	private static final char VAZIO = ' ';
	private static final char INICIO = 'o';
	private static final char DESTINO = '*';
	private static final char CAMINHO = ':';

	private static char[][] tabuleiro;
	private static int linha_inicio;
	private static int coluna_inicio;
	private static int linha_destino;
	private static int coluna_destino;

	private static int gerarNumero(int minimo, int maximo) {
		int valor = (int) Math.round(Math.random() * (maximo - minimo));
		return minimo + valor;
	}

	public static void inicializarMatriz(boolean inicio_e_destino_aleatorios) {
		// paredes externas:
		tabuleiro[0][0] = PAREDE_ESQUINA;
		tabuleiro[0][TAMANHO-1] = PAREDE_ESQUINA;
		tabuleiro[TAMANHO-1][0] = PAREDE_ESQUINA;
		tabuleiro[TAMANHO-1][TAMANHO-1] = PAREDE_ESQUINA;
		for (int idx = 1;  idx < TAMANHO - 1;  idx++) {
			tabuleiro[idx][0] = PAREDE_VERTICAL;
			tabuleiro[idx][TAMANHO-1] = PAREDE_VERTICAL;
			
			tabuleiro[0][idx] = PAREDE_HORIZONTAL;
			tabuleiro[TAMANHO-1][idx] = PAREDE_HORIZONTAL;
		}
		
		// obstaculos
		for (int i = 1;  i < TAMANHO - 1;  i++) {
			for (int j = 1;  j < TAMANHO - 1;  j++) {
				if (Math.random() < PROBABILIDADE) {
					tabuleiro[i][j] = OBSTACULO;
				} else {
					tabuleiro[i][j] = VAZIO;
				}
			}
		}

		// inicio e destino
		if (inicio_e_destino_aleatorios) {
			linha_inicio = gerarNumero(1,  TAMANHO/2);
			coluna_inicio = gerarNumero(1,  TAMANHO/2);
			linha_destino = gerarNumero(TAMANHO/2 + 1,  TAMANHO - 2);
			coluna_destino = gerarNumero(TAMANHO/2 + 1,  TAMANHO - 2);
		} else {
			linha_inicio = TAMANHO - 2;
			coluna_inicio = 1;
			linha_destino = 1;
			coluna_destino = TAMANHO - 2;
		}
		tabuleiro[linha_inicio][coluna_inicio] = INICIO;
		tabuleiro[linha_destino][coluna_destino] = DESTINO;
	}
	
	public static void imprimir() {
		for (int i = 0;  i < TAMANHO;  i++) {
			for (int j = 0;  j < TAMANHO;  j++) {
				System.out.print(tabuleiro[i][j]);
			}
			System.out.println();
		}
	}

	public static boolean posicaoValida(int linha, int coluna) {
		if ( (linha <= 0) || (linha >= TAMANHO - 1) ) {
			return false;
		}
		if ( (coluna <= 0) || (coluna >= TAMANHO - 1) ) {
			return false;
		}
		if (tabuleiro[linha][coluna] == OBSTACULO) {
			return false;
		}
		return true;
	}

	public static int menorCaminho(int linha_inicial, int coluna_inicial) {
		int[][] distancia = new int[TAMANHO][TAMANHO];
		int[][] ultimo_di = new int[TAMANHO][TAMANHO];
		int[][] ultimo_dj = new int[TAMANHO][TAMANHO];
		// 1 --> cima
		// 2 --> direita
		// 3 --> baixo
		// 4 --> esquerda

		for (int i = 0;  i < TAMANHO;  i++) {
			for (int j = 0;  j < TAMANHO;  j++) {
				distancia[i][j] = Integer.MAX_VALUE;
				ultimo_di[i][j] = 0;
				ultimo_dj[i][j] = 0;
			}
		}
		distancia[linha_inicial][coluna_inicial] = 0;

		Queue<Integer> linhas = new LinkedList<Integer>();   linhas.add(linha_inicial);
		Queue<Integer> colunas = new LinkedList<Integer>();  colunas.add(coluna_inicial);
		int i, j;
		boolean encontrou_caminho = false;
		do {
			i = linhas.poll();
			j = colunas.poll();
			int proxima_dist = distancia[i][j] + 1;
			int di, dj, proximo_i, proximo_j;

			if (tabuleiro[i][j] == DESTINO) {
				encontrou_caminho = true;
				break;
			}

			// tenta ir para cima
			di = -1;
			dj = 0;
			proximo_i = i + di;
			proximo_j = j + dj;
			if ( posicaoValida(proximo_i, proximo_j) && (proxima_dist < distancia[proximo_i][proximo_j]) ) {
				distancia[proximo_i][proximo_j] = proxima_dist;
				ultimo_di[proximo_i][proximo_j] = di;
				ultimo_dj[proximo_i][proximo_j] = dj;
				linhas.add(proximo_i);
				colunas.add(proximo_j);
			}

			// tenta ir para a direita
			di = 0;
			dj = 1;
			proximo_i = i + di;
			proximo_j = j + dj;
			if ( posicaoValida(proximo_i, proximo_j) && (proxima_dist < distancia[proximo_i][proximo_j]) ) {
				distancia[proximo_i][proximo_j] = proxima_dist;
				ultimo_di[proximo_i][proximo_j] = di;
				ultimo_dj[proximo_i][proximo_j] = dj;
				linhas.add(proximo_i);
				colunas.add(proximo_j);
			}

			// tenta ir para baixo
			di = 1;
			dj = 0;
			proximo_i = i + di;
			proximo_j = j + dj;
			if ( posicaoValida(proximo_i, proximo_j) && (proxima_dist < distancia[proximo_i][proximo_j]) ) {
				distancia[proximo_i][proximo_j] = proxima_dist;
				ultimo_di[proximo_i][proximo_j] = di;
				ultimo_dj[proximo_i][proximo_j] = dj;
				linhas.add(proximo_i);
				colunas.add(proximo_j);
			}

			// tenta ir para a esquerda
			di = 0;
			dj = -1;
			proximo_i = i + di;
			proximo_j = j + dj;
			if ( posicaoValida(proximo_i, proximo_j) && (proxima_dist < distancia[proximo_i][proximo_j]) ) {
				distancia[proximo_i][proximo_j] = proxima_dist;
				ultimo_di[proximo_i][proximo_j] = di;
				ultimo_dj[proximo_i][proximo_j] = dj;
				linhas.add(proximo_i);
				colunas.add(proximo_j);
			}
		} while (! linhas.isEmpty());

		if (! encontrou_caminho) {
			return -1;
		}

		int dist = distancia[i][j];
		for (int _cc = 1;  _cc < dist; _cc++) {
			int di = ultimo_di[i][j];
			int dj = ultimo_dj[i][j];
			i = i - di;
			j = j - dj;
			tabuleiro[i][j] = CAMINHO;
		}
		return dist;
	}

	public static void main(String Arg[]) {
		tabuleiro = new char[TAMANHO][TAMANHO];
		inicializarMatriz(true);
		int distancia = menorCaminho(linha_inicio, coluna_inicio);
		imprimir();
		System.out.println("Distancia percorrida: " + distancia);
		System.out.println();
	}
}

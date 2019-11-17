
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	private static final int UNDEFINED = -1;
	private int vertices[][];
	private String descricoes[][]; 

	public Grafo(int numVertices) {
		vertices = new int[numVertices][numVertices];
		descricoes = new String[numVertices][numVertices];
	}

	public void criaAresta(int vertice1, int vertice2, int valor, String descricao, boolean isOrientado) {
		vertices[vertice1][vertice2] = valor;
		descricoes[vertice1][vertice2] = descricao;
		// se � n�o orientado, adiciona caminho de volta
		if (isOrientado == false) {
			vertices[vertice2][vertice1] = valor;
			descricoes[vertice2][vertice1] = descricao;
		}
	}

	public void removeAresta(int vertice1, int vertice2) {
		vertices[vertice1][vertice2] = 0;
		descricoes[vertice1][vertice2] = "";
		vertices[vertice2][vertice1] = 0;
		descricoes[vertice2][vertice1] = "";
	}

	public int getCusto(int vertice1, int vertice2) {
		return vertices[vertice1][vertice2];
	}

	// retorna a descri��o da aresta
	public String getDescricao(int vertice1, int vertice2) {
		return descricoes[vertice1][vertice2];
	}

	/*
	 * retorna uma lista com o �ndice de todos os v�rtices conectados ao v�rtice
	 * informado
	 */
	public List<Integer> getCentro(int vert) {
		List<Integer> vizinhos = new ArrayList<>();
		for (int i = 0; i < vertices[vert].length; i++)
			if (vertices[vert][i] > 0) {
				vizinhos.add(i);
			}
		return vizinhos;
	}

	// Implementa��o de Dijkstra
	public List<Integer> caminho(int verticeOrigem, int verticeDestino) {
		int custo[] = new int[vertices.length];
		int anterior[] = new int[vertices.length];
		Set<Integer> naoVisitado = new HashSet<>();
		// o custo para sair do v�rtice de in�cio � 0 e n�o possui anteriores
		custo[verticeOrigem] = 0;
		// Todos os outros n�s (v�rtices) ter�o o custo ajustado para INFINITO
		// (max_value) e o anterior INDEFINIDO
		for (int v = 0; v < vertices.length; v++) {
			if (v != verticeOrigem) {
				custo[v] = Integer.MAX_VALUE;
			}
			anterior[v] = UNDEFINED;
			naoVisitado.add(v);
		}
		// BUSCA NO GRAFO
		while (!naoVisitado.isEmpty()) {
			int proximo = maisProximo(custo, naoVisitado);
			naoVisitado.remove(proximo);
			for (Integer vizinho : getCentro(proximo)) {
				int custoTotal = custo[proximo] + getCusto(proximo, vizinho);
				if (custoTotal < custo[vizinho]) {
					custo[vizinho] = custoTotal;
					anterior[vizinho] = proximo;
				}
			}
			// Encontrou?
			if (proximo == verticeDestino) {
				return criaListadeCaminhos(anterior, proximo);
			}
		}
		// Nenhum caminho encontrado
		return Collections.emptyList();
	}

	// pega vertice mais pr�ximo
	private int maisProximo(int[] dist, Set<Integer> unvisited) {
		double minDist = Integer.MAX_VALUE;
		int minIndex = 0;
		for (Integer i : unvisited) {
			if (dist[i] < minDist) {
				minDist = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private List<Integer> criaListadeCaminhos(int[] anterior, int u) {
		List<Integer> caminho = new ArrayList<>();
		caminho.add(u);
		while (anterior[u] != UNDEFINED) {
			caminho.add(anterior[u]);
			u = anterior[u];
		}
		Collections.reverse(caminho);
		return caminho;
	}

}



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import grafos.Grafo;
import grafos.Parque;
import grafos.Vertice;

public class Main {
	private static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	int[] vertices;

	private static int leConsole(String tipo, Scanner entrada) {
		while (true) {
			System.out.println(tipo + ":");
			String verticeInformado = entrada.nextLine().trim();
			if (verticeInformado.isEmpty()) {
				System.out.println("Programa encerrado!");
				System.exit(0);
			}
			try {
				int vertInf = Integer.parseInt(verticeInformado);
				if (vertInf >= 1) {
					return vertInf - 1;
				}
			} catch (NumberFormatException e) {
			}
			System.out.println("V�rtice inv�lido!");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("        PARQUE ACESS�VEL COM DIJKSTRA");

		System.out.println("\n--------------------------\n");

		boolean grafoOrientado = false;
		int op = -1;

		// define se grafo ser� orientado ou n�o
		do {
			try {
				System.out.println("O grafo ser� orientado ou n�o orientado? \n1. Orientado, 2. N�o Orientado");
				System.out.print("resposta: ");
				op = scan.nextInt();
				scan.nextLine();
				if ((op < 1) || (op > 2))
					System.out.println("op��o inv�lida");
			} catch (InputMismatchException e) {
				System.out.println("op��o inv�lida");
				scan.nextLine();
				op = -1;
			}
		} while ((op < 1) || (op > 2));

		if (op == 1)
			grafoOrientado = true;
		if (op == 2)
			grafoOrientado = false;

		System.out.println("\n--------------------------\n");

		String novoLocal = "";
		Vertice v;
		String resposta = "S";
		// cadastra os v�rtices
		do {
			System.out.println("Diga o nome do local que voc� quer cadastrar");
			System.out.print("resposta: ");
			novoLocal = scan.nextLine();
			v = new Vertice();
			v.setNome(novoLocal);
			listaVertices.add(v);
			do {
				System.out.println("Voc� deseja cadastrar mais locais? (S/N)");
				System.out.print("resposta: ");
				resposta = scan.nextLine();
			} while ((!resposta.equalsIgnoreCase("S")) && (!resposta.equalsIgnoreCase("N")));
		} while (!resposta.equalsIgnoreCase("N"));

		// cria grafo
		Grafo grafo = new Grafo(listaVertices.size());

		System.out.println("\n--------------------------\n");

		int arestaOrigem = 0;
		int arestaDestino = 0;
		int valorAresta = 0;
		String descricaoAresta = "";
		resposta = "S";
		// cria lista de arestas
		do {
			v.listaVertices(listaVertices);
			// aresta de origem
			do {
				try {
					System.out.println("Digite a posi��o do local de origem, segundo a lista acima");
					System.out.print("posi��o: ");
					arestaOrigem = scan.nextInt();
					scan.nextLine();
					if ((arestaOrigem < 1) || (arestaOrigem > listaVertices.size()))
						System.out.println("op��o inv�lida");
				} catch (InputMismatchException e) {
					System.out.println("op��o inv�lida");
					scan.nextLine();
					arestaOrigem = 0;
				}
			} while ((arestaOrigem < 1) || (arestaOrigem > listaVertices.size()));
			// aresta de destino
			do {
				try {
					System.out.println("Digite a posi��o do local de destino, segundo a lista acima");
					System.out.print("posi��o: ");
					arestaDestino = scan.nextInt();
					scan.nextLine();
					if ((arestaDestino < 1) || (arestaDestino > listaVertices.size()))
						System.out.println("op��o inv�lida");
				} catch (InputMismatchException e) {
					System.out.println("op��o inv�lida");
					scan.nextLine();
					arestaDestino = 0;
				}
			} while ((arestaDestino < 1) || (arestaDestino > listaVertices.size()));
			// define peso da aresta
			valorAresta = Parque.definePeso();
			descricaoAresta = "";
			grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
			do {
				System.out.println("Voc� deseja cadastrar mais arestas? (S/N)");
				System.out.print("resposta: ");
				resposta = scan.nextLine();
			} while ((!resposta.equalsIgnoreCase("S")) && (!resposta.equalsIgnoreCase("N")));
		} while (!resposta.equalsIgnoreCase("N"));

		System.out.println("\n--------------------------\n");

		// SOLICITA PONTO INICIAL
		v.listaVertices(listaVertices);
		System.out.println();
		System.out.println("Informe a posi��o do local onde voc� est�");
		int origem = leConsole("Local atual", scan);

		System.out.println("\n--------------------------\n");

		// informa os melhores caminhos, segundo a acessibilidade
		System.out.println("Caminho mais curto, partindo do local -> " + (v.getNome(origem, listaVertices)));

		// pegar� os locais passados pelo melhor caminho atual
		ArrayList<Integer> caminhoPassado = new ArrayList<Integer>();

		for (int a = 0; a < listaVertices.size(); a++) {
			for (Integer i : grafo.caminho(origem, a)) {
				// se origem for diferente de destino e o i atual for igual ao destino, ent�o
				// mostra print sem o -> e sai do la�o
				if ((i == a) && (origem != a)) {
					System.out.println(v.getNome((i), listaVertices));
					caminhoPassado.add(i);
					break;
				}
				if (origem != a) {
					System.out.print(v.getNome((i), listaVertices) + " -> ");
					caminhoPassado.add(i);
				}
			}
			// agora de acordo com o caminho mostra o que tem nele, os seus pesos e
			// informa��es
			for (int j = 0; j < (caminhoPassado.size() - 1); j++) {
				if (j == (caminhoPassado.size() - 2)) {
					System.out.println(grafo.getPesoComMensagem(caminhoPassado.get(j), (caminhoPassado.get(j + 1))));
					break;
				}
				System.out.print(grafo.getPesoComMensagem(caminhoPassado.get(j), (caminhoPassado.get(j + 1))) + ", ");
			}
			caminhoPassado.clear(); // limpa o caminho atual para pegar as informa��es do pr�ximo
		}

	}
}

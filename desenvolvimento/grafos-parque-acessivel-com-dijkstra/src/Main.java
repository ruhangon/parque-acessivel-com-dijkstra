
import java.util.ArrayList;
import java.util.Scanner;

import grafos.Grafo;
import grafos.Parque;
import grafos.Vertice;

// classe que será usada para testar parques diversos
// vértices serão os locais, como banheiro, tirolesa, lanchonete, dentre outros
// arestas serão os caminhos e seus pesos serão de acordo com a acessibilidade do caminho
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
			System.out.println("Vértice inválido!");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("        Parque acessível");

		System.out.println("\n--------------------------\n");

		int contVertices = 0;

		// enquanto console estiver rodando
		while (true) {
			// PERGUNTA SE GRAFO É ORIENTADO OU NÃO
			System.out.println("Todos os caminhos terão ida e volta? \n1 = Não | 2 = Sim");
			// 1 = orientado, 2 = não orientado
			System.out.println("Resposta: ");
			String inputTipoGrafo = scan.nextLine().trim();
			System.out.println("");
			// default: orientado
			Boolean grafoOrientado = true;
			// atribui true or false para grafoOrientado

			switch (inputTipoGrafo) {
			case "1":
				grafoOrientado = true;
				break;

			case "2":
				grafoOrientado = false;
				break;
			}

			System.out.println("--------------------------\n");

			// CADASTRA VÉRTICES
			String pedeVertice2 = " ";
			System.out.println("Informe os locais do parque para cadastrar, ex.: uma atração específica, um banheiro");
			System.out.println("Parar deixe em branco");

			while (!pedeVertice2.equals("")) {
				// pede vértices
				System.out.print("Informe um local: ");
				pedeVertice2 = scan.nextLine().trim();
				if (!pedeVertice2.equals("")) {
					Vertice v = new Vertice();
					v.setNome(pedeVertice2);
					// v.setNome(Integer.parseInt(pedeVertice2));
					listaVertices.add(v);
				}
				contVertices++;
			}

			// cria grafo
			Grafo grafo = new Grafo(contVertices); // cont = quantidade de vértices cadastrados

			// CADASTRAR ARESTAS, OS CAMINHOS
			String pedeArestas = " ";
			String pedeValorArestas = " ";
			Vertice v = new Vertice();
			int arestaOrigem = 0;
			int arestaDestino = 0;
			int contArestas = 0;

			System.out.println("\n--------------------------\n");

			v.listaVertices(listaVertices);
			System.out.println(
					"Informe o local de origem e o local de destino referente ao caminho, segundo a posição na lista de locais cadastrados");
			System.out.println("separados por vírgula, ex.: 1,2 - Parar deixe em branco");

			while (!pedeArestas.equals("")) {
				try {
					// PEDE PAR DE ARESTAS
					System.out.print("Caminho: ");
					pedeArestas = scan.nextLine().trim();

					String[] dados = pedeArestas.split(",");
					arestaOrigem = Integer.parseInt(dados[0]);
					arestaDestino = Integer.parseInt(dados[1]);

					// PEDE VALOR DO PAR DE ARESTAS
					// System.out.print("Valor do caminho escolhido segundo a lista de valores de
					// caminhos (digite o valor inteiro): ");
					// pedeArestas = scan.nextLine().trim();
					// int valorAresta = Integer.parseInt(pedeArestas);

					int valorAresta = Parque.definePeso();
					String descricaoAresta = Parque.defineDescricao();

					contArestas++; // contador

					// só aceita par
					if (dados.length > 0 && dados.length <= 2) {

						if (!pedeArestas.equals("")) {

							for (int i = 0; i < contArestas; i++) {
								grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta,
										grafoOrientado);
							}
						}

					} else {
						System.out.println("Precisa ser um caminho válido!");
						pedeArestas = scan.nextLine().trim();
					}

				} catch (Exception e) {
					System.out.println(
							"O caminho não faz parte da lista de locais ou você digitou valores inválidos.\nCaso tenha utilizado a função SAIR, ignore a mensagem");
				}
			}

			System.out.println("\n--------------------------\n");

			// SOLICITA PONTO INICIAL e mostra melhor caminho
			v.listaVertices(listaVertices);
			System.out.println("Informe a posição do local onde você está \n(deixe em branco para fechar)");
			int origem = leConsole("Local atual", scan);

			System.out.println("\n--------------------------\n");

			System.out.println("Caminho mais curto, partindo do local -> " + (v.getNome(origem, listaVertices)));

			for (int a = 0; a < contVertices; a++) {
				for (Integer i : grafo.caminho(origem, a)) {
					// se origem for diferente de destino e o i atual for igual ao destino, então
					// mostra print sem o -> e sai do laço
					if ((i == a) && (origem != a)) {
						System.out.println(v.getNome((i), listaVertices));
						break;
					}
					// se origem for diferente de destino mostra o print com ->
					if (origem != a)
						System.out.print(v.getNome((i), listaVertices) + " -> ");
				}
			}

		}

	}
}

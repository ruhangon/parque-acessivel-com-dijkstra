
import java.util.ArrayList;
import java.util.Scanner;

import grafos.Grafo;
import grafos.Parque;
import grafos.Vertice;

public class ParqueAvaj {
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

		System.out.println("        PARQUE AVAJ");
		System.out.println("\nSeja bem vindo, visitante");

		System.out.println("Qual o seu nome?");
		System.out.print("nome: ");
		String visitante = scan.nextLine();

		System.out.println("\n--------------------------\n");

		// nesse parque todos os caminhos serão de ida e volta
		boolean grafoOrientado = false;

		String novoLocal = "";
		novoLocal = "Portão (entrada/saída)";
		Vertice v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Praça de alimentação";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Banheiro";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Montanha Russa";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Roda Gigante";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Tirolesa";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);
		novoLocal = "Arvorismo";
		v = new Vertice();
		v.setNome(novoLocal);
		listaVertices.add(v);

		// cria grafo
		Grafo grafo = new Grafo(listaVertices.size());

		int arestaOrigem = 0;
		int arestaDestino = 0;
		int contArestas = 0;

		// primeiro caminho
		arestaOrigem = 1;
		arestaDestino = 2;
		int valorAresta = 1;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		String descricaoAresta = "Caminho tranquilo e de fácil acesso";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// segundo caminho
		arestaOrigem = 2;
		arestaDestino = 3;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Caminho curto. Você passará próximo a uma placa do parque entre o caminho";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// terceiro caminho
		arestaOrigem = 3;
		arestaDestino = 4;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Caminho com escadaria curta";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// quarto caminho
		arestaOrigem = 4;
		arestaDestino = 5;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Siga reto passando pelo caminho com árvores";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// quinto caminho
		arestaOrigem = 5;
		arestaDestino = 6;
		valorAresta = 3;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há uma rampa com inclinação de 50 graus e uma placa de ferro";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// sexto caminho
		arestaOrigem = 6;
		arestaDestino = 7;
		valorAresta = 4;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há um caminho de brita";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// sétimo caminho
		arestaOrigem = 1;
		arestaDestino = 4;
		valorAresta = 1;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Siga pelo caminho de árvores, onde também há piso tátil para auxiliar";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// oitavo caminho
		arestaOrigem = 2;
		arestaDestino = 4;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Siga reto passando pelo muro";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// nono caminho
		arestaOrigem = 4;
		arestaDestino = 6;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há uma escada e um caminho longo";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo caminho
		arestaOrigem = 4;
		arestaDestino = 7;
		valorAresta = 3;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há um caminho com duas rampas, uma grande e uma pequena";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo primeiro caminho
		arestaOrigem = 1;
		arestaDestino = 6;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há uma trilha e uma escada próxima a tirolesa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo segundo caminho
		arestaOrigem = 3;
		arestaDestino = 5;
		valorAresta = 1;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Há um caminho longo, com bancos para sentar no meio dele";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// SOLICITA PONTO INICIAL e mostra melhor caminho
		v.listaVertices(listaVertices);
		System.out.println();
		System.out.println(visitante + ", informe a posição do local onde você está");
		int origem = leConsole("Local atual", scan);

		System.out.println("\n--------------------------\n");

		System.out.println("Caminho mais curto, partindo do local -> " + (v.getNome(origem, listaVertices)));
		System.out.println(
				"Modelo \nPrimeira linha: locais a passar \nSegunda linha: Informações sobre acessibilidade do caminho \nTerceira linha: Descrições de auxilio do caminho");
		System.out.println();

		ArrayList<Integer> caminhoPassado = new ArrayList<Integer>();

		for (int a = 0; a < listaVertices.size(); a++) {
			for (Integer i : grafo.caminho(origem, a)) {
				// se origem for diferente de destino e o i atual for igual ao destino, então
				// mostra print sem o -> e sai do laço
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
			// informações
			for (int j = 0; j < (caminhoPassado.size() - 1); j++) {
				// se for a última passada do laço passa por esse trecho
				if (j == (caminhoPassado.size() - 2)) {
					System.out.println(grafo.getPesoComMensagem(caminhoPassado.get(j), (caminhoPassado.get(j + 1))));
					break;
				}
				System.out.print(grafo.getPesoComMensagem(caminhoPassado.get(j), (caminhoPassado.get(j + 1))) + ", ");
			}
			// agora de acordo com o caminho mostra as descrições de cada um. Usado para
			// auxiliar ainda mais a pessoa com deficiência
			for (int k = 0; k < (caminhoPassado.size() - 1); k++) {
				// se for a última passada do laço passa por esse trecho
				if (k == (caminhoPassado.size() - 2)) {
					System.out.println(grafo.getDescricao(caminhoPassado.get(k), (caminhoPassado.get(k + 1))));
					System.out.println();
					break;
				}
				System.out.print(grafo.getDescricao(caminhoPassado.get(k), (caminhoPassado.get(k + 1))) + ", ");
			}
			caminhoPassado.clear(); // limpa o caminho atual para pegar as informações do próximo
		}

		System.out.println("\nFim do programa");

	}
}

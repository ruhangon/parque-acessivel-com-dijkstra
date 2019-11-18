
import java.util.ArrayList;
import java.util.Scanner;

import grafos.Grafo;
import grafos.Parque;
import grafos.Vertice;

public class ParqueAjav {
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

		System.out.println("        PARQUE AJAV");
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
		String descricaoAresta = "Caminho tranquilo e de fácil acesso para o restaurante";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// segundo caminho
		arestaOrigem = 2;
		arestaDestino = 3;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Caminho curto. Você passará próximo a uma placa do parque entre o caminho e chegará ao banheiro";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// terceiro caminho
		arestaOrigem = 3;
		arestaDestino = 4;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Caminho com escadaria curta até a montanha russa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// quarto caminho
		arestaOrigem = 4;
		arestaDestino = 5;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Seguindo reto passando pelo caminho com árvores você chega a montanha russa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// quinto caminho
		arestaOrigem = 5;
		arestaDestino = 6;
		valorAresta = 3;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Suba a rampa com inclinação de 50 graus, passe pela placa de ferro e chegue a tirolesa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// sexto caminho
		arestaOrigem = 6;
		arestaDestino = 7;
		valorAresta = 4;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Siga reto pelo caminho de brita e encontre o seu destino, arvorismo";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// sétimo caminho
		arestaOrigem = 1;
		arestaDestino = 4;
		valorAresta = 1;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Siga pelo caminho de árvores, onde também há piso tátil para auxiliar até a montanha russa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// oitavo caminho
		arestaOrigem = 2;
		arestaDestino = 4;
		valorAresta = 2;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Seguindo próximo ao muro do restaurante você encontrará uma atração, montanha russa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// nono caminho
		arestaOrigem = 4;
		arestaDestino = 6;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Saindo da montanha russa, subindo as escadas e seguindo pelo caminho você chega a tirolesa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo caminho
		arestaOrigem = 4;
		arestaDestino = 7;
		valorAresta = 3;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Seguindo pela direita, então subindo uma grande rampa, que tem uma parada e depois uma pequena rampa com inclinação alta, você chega ao arvorismo";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo primeiro caminho
		arestaOrigem = 1;
		arestaDestino = 6;
		valorAresta = 5;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Seguindo da entrada é possível se encontrar uma trilha que chega a uma escada e leva para a tirolesa";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// décimo segundo caminho
		arestaOrigem = 3;
		arestaDestino = 5;
		valorAresta = 1;
		if (Parque.validaPeso(valorAresta) == false)
			System.out.println("Há um peso inválido");
		descricaoAresta = "Saindo do banheiro passando pelos bancos do parque, você chegará a roda gigante";
		grafo.criaAresta(arestaOrigem - 1, arestaDestino - 1, valorAresta, descricaoAresta, grafoOrientado);
		contArestas++;

		// SOLICITA PONTO INICIAL e mostra melhor caminho
		v.listaVertices(listaVertices);
		System.out.println();
		System.out.println(visitante + ", informe a posição do local onde você está");
		int origem = leConsole("Local atual", scan);

		System.out.println("\n--------------------------\n");

		System.out.println("Caminho mais curto, partindo do local -> " + (v.getNome(origem, listaVertices)));

		int ant = -1; // pode ser necessário para ir descobrindo o caminho, para mostrar a mensagem sobre o peso junto com o caminho

		for (int a = 0; a < listaVertices.size(); a++) {
			for (Integer i : grafo.caminho(origem, a)) {
				// se origem for diferente de destino e o i atual for igual ao destino, então
				// mostra print sem o -> e sai do laço
				if ((i == a) && (origem != a)) {
					System.out.println(v.getNome((i), listaVertices));
					break;
				}
				// se origem for diferente de destino mostra o print com ->
				if (origem != a) {
					System.out
							.print(v.getNome((i), listaVertices) + " -> " + grafo.getPesoComMensagem(i, a) + " -> ");
				}
			}
		}

	}
}

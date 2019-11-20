package grafos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parque {
	// m�todo para definir o peso de um caminho
	public static int definePeso() {
		Scanner scan = new Scanner(System.in);
		int op = 0;
		boolean valido = false;
		String pesos = "1. Caminho plano ou de rampas com pouca inclina��o e cont�m piso tatil"
				+ "\n2. Caminho plano ou com rampas de pouca inclina��o, sem aux�lio de piso t�til "
				+ "\n3. Caminho com rampas bem inclinadas (maior ou igual a 45 graus)"
				+ "\n4. Caminho pouco acidentado (cont�m brita oh algum tipo de piso com diferentes inclina��es)"
				+ "\n5. Caminho com escadas";
		System.out.println("Lista de pesos \n" + pesos);
		do {
			try {
				System.out.println("Escolha um peso");
				System.out.print("resposta: ");
				op = scan.nextInt();
				scan.nextLine();
				valido = validaPeso(op);
				if ((op < 1) || (op > 5))
					System.out.println("op��o inv�lida");
			} catch (InputMismatchException e) {
				System.out.println("op��o inv�lida");
				scan.nextLine();
				op = 0;
			}
		} while (valido != true);
		return op;
	}

	// se o peso � v�lido segundo a lista de pesos retorna true
	public static boolean validaPeso(int peso) {
		if ((peso >= 1) && (peso <= 5))
			return true;
		return false;
	}

	public static String defineDescricao() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Digite uma descri��o desse caminho, que possa auxiliar melhor o usu�rio se ele ir� por esse caminho ou n�o");
		System.out.print("descri��o: ");
		String descricao = scan.nextLine();
		return descricao;
	}

}


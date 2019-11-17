import java.util.InputMismatchException;
import java.util.Scanner;

public class Parque {
	public static int definePeso() {
		Scanner scan = new Scanner(System.in);
		int op = 0;
		String pesos = "1. Caminho plano ou de rampas com pouca inclinação e contém piso tatil"
				+ "\n2. Caminho plano ou com rampas de pouca inclinação, sem auxílio de piso tátil "
				+ "\n3. Caminho com rampas bem inclinadas (maior ou igual a 45 graus)"
				+ "\n4. Caminho pouco acidentado (contém brita oh algum tipo de piso com diferentes inclinações)"
				+ "\n5. Caminho com escadas";
		System.out.println("Lista de pesos \n" + pesos);
		do {
			try {
				System.out.println("Escolha um peso");
				System.out.print("resposta: ");
				op = scan.nextInt();
				scan.nextLine();
				if ((op < 1) || (op > 5))
					System.out.println("opção inválida");
			} catch (InputMismatchException e) {
				System.out.println("opção inválida");
				scan.nextLine();
				op = 0;
			}
		} while ((op < 1) || (op > 5));
		return op;
	}

	public static String defineDescricao() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Digite uma descrição desse caminho, que possa auxiliar melhor o usuário se ele irá por esse caminho ou não");
		System.out.print("descrição: ");
		String descricao=scan.nextLine();
		return descricao;
	}

}

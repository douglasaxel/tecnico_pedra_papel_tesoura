package pedra_papel_tesoura;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice = 1;
		Scanner sc = new Scanner(System.in);

		while (choice != 0) {
			System.out.println(
					"Pedra, papel ou tesoura!!\n\nSelecione uma opção:\n1 - Pedra\n2 - Papel\n3 - Tesoura\n0 - Sair");

			choice = sc.nextInt();
			int aiChoice = getAiChoice();
			int winner = validateChoice(choice, aiChoice);

			switch (winner) {
			case 1:
				System.out.printf("Player - %s\nMáquina - %s\n", choiceToString(choice), choiceToString(aiChoice));
				System.out.println("Você ganhou!!!\n\nQuer jogar novamente? (1 - Sim, 0 - Não)");
				choice = sc.nextInt();
				break;
			case 2:
				System.out.printf("Player - %s\nMáquina - %s\n", choiceToString(choice), choiceToString(aiChoice));
				System.out.println("A máquina venceu!\n\nQuer jogar novamente? (1 - Sim, 0 - Não)");
				choice = sc.nextInt();
				break;
			case 3:
				System.out.printf("Player - %s\nMáquina - %s\n", choiceToString(choice), choiceToString(aiChoice));
				System.out.println("Empate.\n\nQuer jogar novamente? (1 - Sim, 0 - Não)");
				choice = sc.nextInt();
				break;
			case 0:
				System.out.println("Até a próxima!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Selecione uma opção válida\n\n");
			}
		}
	}

	static int getAiChoice() {
		return (int) (Math.random() * 3) + 1;
	}

	static String choiceToString(int choice) {
		switch (choice) {
		case 1:
			return "Pedra";
		case 2:
			return "Papel";
		case 3:
			return "Tesoura";
		default:
			return "Inválido";
		}
	}

	static int validateChoice(int player, int ai) {
		// 1 = player
		// 2 = ai
		// 3 = draw
		// 4 = invalid
		// 0 = Exit

		if (player == 0)
			return 0;

		if ((player == 1 && ai == 1) || (player == 2 & ai == 2) || (player == 3 && ai == 3)) {
			return 3;
		}
		if (player == 1 && ai == 2) {
			return 2;
		}
		if (player == 1 && ai == 3) {
			return 1;
		}
		if (player == 2 && ai == 1) {
			return 1;
		}
		if (player == 2 && ai == 3) {
			return 2;
		}
		if (player == 3 && ai == 1) {
			return 2;
		}
		if (player == 3 && ai == 2) {
			return 1;
		}

		return 4;
	}
}

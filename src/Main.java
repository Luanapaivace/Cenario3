import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("5 - Mostrar resolução do Exercício 5");
            System.out.println("6 - Mostrar resolução do Exercício 6");
            System.out.println("7 - Mostrar resolução do Exercício 7");
            System.out.println("8 - Mostrar resolução do Exercício 8");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 5:
                    PageRank.resolverExercicio5();
                    break;
                case 6:
                    System.out.println("Resolução do Exercício 6 ainda não implementada.");
                    break;
                case 7:
                    System.out.println("Resolução do Exercício 7 ainda não implementada.");
                    break;
                case 8:
                    System.out.println("Resolução do Exercício 8 ainda não implementada.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

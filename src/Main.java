import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n-------------- MENU --------------");
            System.out.println("4 - Fazer teste Personalizavel: ");
            System.out.println("5 - Mostrar resolução do Exercício 5");
            System.out.println("6 - Mostrar resolução do Exercício 6");
            System.out.println("7 - Mostrar resolução do Exercício 7");
            System.out.println("8 - Mostrar resolução do Exercício 8");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 4:
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Informe a quantidade linhas: ");
                    int n = entrada.nextInt();
                    System.out.println("Informe a quantidade de colunas: ");
                    int m = entrada.nextInt();
                    if(n != m){
                        System.out.println("A matriz não é quadrada. Informe uma matriz válida.");
                        break;
                    }else if (n == 0 || m == 0 || n == 1 || m == 1){
                        System.out.println("O tamanho da matriz é inválido para realizar esta operação. Tente novamente: ");
                        break;
                    }else{
                        double [][] A = new double[n][m];
                        for(int i = 0; i < n; i++){
                            for(int j = 0; j < m; j++){
                                System.out.println("Digite o elemento a(" + i + "," + j + ") da matriz" );
                                double elemento = entrada.nextDouble();
                                if(elemento != 1 && elemento != 0){
                                    System.out.println("Valor inválido. Tente novamente: ");
                                    System.out.println("Digite o elemento a(" + i + "," + j + ") da matriz" );
                                    elemento = entrada.nextDouble();
                                }
                                A [i][j] = elemento;
                            }
                        }
                        Matrix matrizA = new Matrix(n, m, A);
                        System.out.println("A matriz informada foi: ");
                        matrizA.mostraMatrix();
                        if(diagonalPrincipalEhNula(A)){
                            PageRank.resolverPersonalizado(A);
                            break;
                        }else{
                            System.out.println("Os elementos da diagonal da matriz devem ser nulos! ");
                            break;
                        }

                    }
                    //alguma coisa geral, checar se é quadrada e coluna principal = 0, PageRank. ----> acho que os requisitos sao so esses
                case 5:
                    PageRank.resolverExercicio5();
                    break;
                case 6:
                    PageRank.resolverExercicio6();
                    break;
                case 7:
                    PageRank.resolverExercicio7();
                    break;
                case 8:
                    PageRank.resolverExercicio8();
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
    public static boolean diagonalPrincipalEhNula(double [][] matriz) {
        int tamanho = Math.min(matriz.length, matriz[0].length); // Garante segurança para matrizes não quadradas
        for (int i = 0; i < tamanho; i++) {
            if (Math.abs(matriz[i][i]) > 1e-6) {
                return false; // Encontrou um valor diferente de zero na diagonal
            }
        }
        return true; // Todos os elementos da diagonal são zero
    }
}
public class PageRank {
    public static void resolverExercicio5() {
        // Matriz A (Matriz adjacente)
        double[][] A = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };

        Matrix matrizA = new Matrix(4, 4, A);

        // Calculando h0 e a0
        Vector h0 = calcularH0(matrizA);
        Vector a0 = calcularA0(matrizA);

        // Exibindo resultados
        System.out.println("----- Resolução do Exercício 5 -----\n");

        // Exibindo a matriz A
        System.out.println("Matriz A (Matriz Adjacente):");
        matrizA.mostraMatrix();  // Supondo que você tenha um método `mostraMatrix` para exibir a matriz

        // Exibindo os vetores h0 e a0
        System.out.println("\nVetor h0:");
        h0.mostraVector();

        System.out.println("\nVetor a0:");
        a0.mostraVector();

        System.out.println("\n-------- Resultado Final --------");

        // Calculando h1
        Vector h1 = calcularH1(matrizA, a0);
        System.out.println("\nVetor hn:");
        h1.mostraVector();

        // Calculando a1
        Vector a1 = calcularA1(matrizA, h1);
        System.out.println("\nVetor an:");
        a1.mostraVector();

    }

    private static Vector calcularH0(Matrix A) {
        double[] somas = new double[A.getLength()];
        for (int i = 0; i < A.getLength(); i++) {
            for (int j = 0; j < A.getWidth(); j++) {
                somas[i] += A.get(i, j);
            }
        }
        return new Vector(A.getLength(), somas);
    }

    private static Vector calcularA0(Matrix A) {
        Matrix AT = (Matrix) LinearAlgebra.transpose(A);
        double[] somas = new double[AT.getLength()];
        for (int i = 0; i < AT.getLength(); i++) {
            for (int j = 0; j < AT.getWidth(); j++) {
                somas[i] += AT.get(i, j);
            }
        }
        return new Vector(AT.getLength(), somas);
    }

    private static Vector calcularH1(Matrix A, Vector a0) {
        Vector resultado = (Vector) LinearAlgebra.dot(A, a0);
        return resultado.normalize();
    }

    private static Vector calcularA1(Matrix A, Vector h1) {
        Matrix AT = (Matrix) LinearAlgebra.transpose(A);
        Vector resultado = (Vector) LinearAlgebra.dot(AT, h1);
        return resultado.normalize();
    }
}

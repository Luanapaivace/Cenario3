public class PageRank {

    public static void resolverExercicio5() {
        double[][] A = {
                {0, 0, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 0}
        };

        Matrix matrizA = new Matrix(4, 4, A);

        Vector h = calcularH0(matrizA);
        Vector a = calcularA0(matrizA);

        System.out.println("----- Resolução do Exercício 5 -----\n");
        System.out.println("Matriz A (Matriz Adjacente):");
        matrizA.mostraMatrix();

        System.out.println("\nVetor h0:");
        h.mostraVector();

        System.out.println("\nVetor a0:");
        a.mostraVector();


        double criterioParada = 0.0001;
        int iteracao = 0;

        while (true) {
            Vector hNovo = calcularH1(matrizA, a);
            Vector aNovo = calcularA1(matrizA, hNovo);

            double diffH = h.diferencaNorma(hNovo);
            double diffA = a.diferencaNorma(aNovo);

            if (diffH < criterioParada && diffA < criterioParada) {
                break;
            }

            h = hNovo;
            a = aNovo;
            iteracao++;
        }

        System.out.println("\n-------- Resultado Final --------");
        System.out.println("\nVetor autoridade final:");
        a.mostraVector();
        System.out.println("\nQuantidade total de interações: " + iteracao);
    }

    public static void resolverExercicio6() {
        double[][] A = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };

        Matrix matrizA = new Matrix(4, 4, A);

        Vector h = calcularH0(matrizA);
        Vector a = calcularA0(matrizA);

        System.out.println("----- Resolução do Exercício 6 -----\n");
        System.out.println("Matriz A (Matriz Adjacente):");
        matrizA.mostraMatrix();

        System.out.println("\nVetor h0:");
        h.mostraVector();

        System.out.println("\nVetor a0:");
        a.mostraVector();


        double criterioParada = 0.0001;
        int iteracao = 0;

        while (true) {
            Vector hNovo = calcularH1(matrizA, a);
            Vector aNovo = calcularA1(matrizA, hNovo);

            double diffH = h.diferencaNorma(hNovo);
            double diffA = a.diferencaNorma(aNovo);

            if (diffH < criterioParada && diffA < criterioParada) {
                break;
            }

            h = hNovo;
            a = aNovo;
            iteracao++;
        }

        System.out.println("\n-------- Resultado Final --------");
        System.out.println("\nVetor an final:");
        a.mostraVector();
        System.out.println("\nQuantidade total de interações: " + iteracao);
    }

    public static void resolverExercicio7() {
        double[][] A = {
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
        };

        Matrix matrizA = new Matrix(10, 10, A);

        Vector h = calcularH0(matrizA);
        Vector a = calcularA0(matrizA);

        System.out.println("----- Resolução do Exercício 7 -----\n");
        System.out.println("Matriz A (Matriz Adjacente):");
        matrizA.mostraMatrix();

        System.out.println("\nVetor h0:");
        h.mostraVector();

        System.out.println("\nVetor a0:");
        a.mostraVector();

        double criterioParada = 0.0001;
        int iteracao = 0;

        while (true) {
            Vector hNovo = calcularH1(matrizA, a);
            Vector aNovo = calcularA1(matrizA, hNovo);

            double diffH = h.diferencaNorma(hNovo);
            double diffA = a.diferencaNorma(aNovo);

            if (diffH < criterioParada && diffA < criterioParada) {
                break;
            }

            h = hNovo;
            a = aNovo;
            iteracao++;
        }

        System.out.println("\n-------- Resultado Final --------");
        System.out.println("\nVetor autoridade final:");
        a.mostraVector();
        System.out.println("\nQuantidade total de interações: " + iteracao);
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

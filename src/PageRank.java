import java.util.Arrays;

public class PageRank {

    public static void resolverExercicio5() {
        double[][] A = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };

        resolverExercicio(A, "Exercício 5");
    }

    public static void resolverExercicio6() {
        double[][] A = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 0}
        };

        resolverExercicio(A, "Exercício 6");
    }

    public static void resolverExercicio7() {
        double[][] A = {
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0}
        };

        resolverExercicio(A, "Exercício 7");
    }

    public static void resolverExercicio8() {
        double[][] A = {
                {0, 1, 1, 0, 1, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
        };

        resolverExercicio(A, "Exercício 8");
    }

    public static void resolverPersonalizado(double [][] A) {
        resolverExercicio(A, "Teste personalizado.");
    }


    private static void resolverExercicio(double[][] A, String titulo) {
        Matrix matrizA = new Matrix(A.length, A[0].length, A);

        Vector h = calcularH0(matrizA);
        Vector a = calcularA0(matrizA);

        System.out.println("---- Resolução do " + titulo + " ----\n");
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

            double diffH = dist(h, hNovo);
            double diffA = dist(a, aNovo);

            if (diffH < criterioParada && diffA < criterioParada) {
                break;
            }

            h = hNovo;
            a = aNovo;
            iteracao++;
        }

        System.out.println("\n-------- Resultado Final --------");

        System.out.println("\nVetor autoridade final:");
        a.mostraVectorCasas();

        double[] valoresOrdenados = new double[a.getLength()];
        for (int l = 0; l < a.getLength(); l++) {
            valoresOrdenados[l] = a.get(l);
        }
        Arrays.sort(valoresOrdenados);
        for (int p = 0, j = valoresOrdenados.length - 1; p < j; p++, j--) {
            double temp = valoresOrdenados[p];
            valoresOrdenados[p] = valoresOrdenados[j];
            valoresOrdenados[j] = temp;
        }

        Vector aOrdenado = new Vector(a.getLength(), valoresOrdenados);
        System.out.println("\nVetor autoridade em ordem decrescente:");
        aOrdenado.mostraVectorCasas();

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
        return normalize(resultado);
    }

    private static Vector calcularA1(Matrix A, Vector h1) {
        Matrix AT = (Matrix) LinearAlgebra.transpose(A);
        Vector resultado = (Vector) LinearAlgebra.dot(AT, h1);
        return normalize(resultado);
    }

    public static double norm(Vector v) {
        double soma = 0;
        for (int i = 0; i < v.getLength(); i++) {
            soma += v.get(i) * v.get(i);
        }
        return Math.sqrt(soma);
    }

    public static Vector normalize(Vector v) {
        double norma = norm(v);
        double[] resultado = new double[v.getLength()];
        for (int i = 0; i < v.getLength(); i++) {
            resultado[i] = v.get(i) / norma;
        }
        return new Vector(v.getLength(), resultado);
    }

    public static double dist(Vector v1, Vector v2) {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalArgumentException("Vetores de tamanhos diferentes.");
        }
        double soma = 0;
        for (int i = 0; i < v1.getLength(); i++) {
            double diff = v1.get(i) - v2.get(i);
            soma += diff * diff;
        }
        return Math.sqrt(soma);
    }
}

public class Vector {
    private int dimensao;
    private double[] elementos;

    public Vector(int d, double[] e) {
        if (e.length != d) {
            throw new IllegalArgumentException("O número de elementos no array não corresponde à dimensão especificada.");
        }
        dimensao = d;
        elementos = e;
    }

    public double get(int i) {
        if (i < 0 || i >= dimensao) {
            throw new IndexOutOfBoundsException("Erro: Índice fora dos limites do vetor");
        }
        return elementos[i];
    }

    public void set(int i, double value) {
        if (i < 0 || i >= dimensao) {
            throw new IndexOutOfBoundsException("Erro: Índice fora dos limites do vetor");
        }
        elementos[i] = value;
        System.out.println("Valor " + value + " atribuído à posição " + i + " do vetor.");
    }

    public int getLength() {
        return dimensao;
    }

    public void mostraVector() {
        for (int i = 0; i < dimensao; i++) {
            double valor = elementos[i];
            if (Math.abs(valor) < 1e-6) {
                System.out.print("0.0  ");
            } else {
                System.out.print(Math.round(valor * 1000.0) / 1000.0 + "  ");
            }
        }
    }
}

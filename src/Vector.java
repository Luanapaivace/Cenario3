public class Vector {
    // Atributos da classe
    private int dimensao;                // dimensao do vetor
    private double[] elementos;          // array para armazenar os elementos do vetor

    // Construtor
    public Vector(int d, double[] e) {
        if (e.length != d) { // Verifica se o número de elementos no array é igual à dimensão fornecida
            throw new IllegalArgumentException("O número de elementos no array não corresponde à dimensão especificada.");
        }

        dimensao = d;   // Atribuição do valor do parâmetro ao atributo
        elementos = e;
    }

    // Método get para retornar o valor armazenado em uma determinada posição do vetor
    public double get(int i) {
        if (i < 0 || i >= dimensao) {    // Verifica se o índice fornecido está dentro dos limites do vetor
            throw new IndexOutOfBoundsException("Erro: Índice fora dos limites do vetor");
        }
        return elementos[i];    // O valor do elemento que está no índice i do vetor
    }

    // Método set para atribuir um valor em uma determinada posição do vetor
    public void set(int i, double value) {
        if (i < 0 || i >= dimensao) {
            throw new IndexOutOfBoundsException("Erro: Índice fora dos limites do vetor");
        }
        elementos[i] = value;   // Atribui o valor fornecido na posição indicada do vetor
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

    public double norm() {
        double soma = 0;
        for (double v : elementos) {
            soma += v * v;
        }
        return Math.sqrt(soma);
    }

    public Vector normalize() {
        double norma = this.norm();
        double[] resultado = new double[dimensao];
        for (int i = 0; i < dimensao; i++) {
            resultado[i] = elementos[i] / norma;
        }
        return new Vector(dimensao, resultado);
    }

    // Método que calcula a distância euclidiana entre dois vetores
    public double dist(Vector outro) {
        if (this.dimensao != outro.dimensao) {
            throw new IllegalArgumentException("Os vetores devem ter a mesma dimensão.");
        }

        double somaQuadrados = 0;
        for (int i = 0; i < this.dimensao; i++) {
            somaQuadrados += Math.pow(this.elementos[i] - outro.elementos[i], 2);
        }

        return Math.sqrt(somaQuadrados);
    }

    public double diferencaNorma(Vector outro) {
        double soma = 0;
        for (int i = 0; i < this.getLength(); i++) {
            double diff = this.get(i) - outro.get(i);
            soma += diff * diff;
        }
        return Math.sqrt(soma);
    }

}

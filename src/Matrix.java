public class Matrix {
    // Atributos da classe
    int linhas;
    int colunas;
    double [][] elementos;

    // Construtor com cópia real dos elementos
    public Matrix(int rows, int cols, double[][] elements) {
        this.linhas = rows;
        this.colunas = cols;
        this.elementos = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elementos[i][j] = elements[i][j];
            }
        }
    }



    // Metodo get
    public double get (int i, int j){
        if(i < 0 || i >= linhas || j < 0 || j >= colunas){
            throw new IllegalArgumentException("Indices fora dos limites da matriz.");
        }else{
            return elementos[i][j];
        }
    }

    // Metodo set
    public void set(int i, int j, double value){
        if(i < 0 || i >= linhas || j < 0 || j >= colunas){
            throw new IllegalArgumentException("Indices fora dos limites da matriz.");
        }else{
            elementos[i][j] = value;
        }
    }
    // *Metodo para mostrar uma matriz
    public void mostraMatrix() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(Math.round(elementos[i][j]) + "  ");
            }
            System.out.println();
        }
    }


    //
    public double [] getLinha (int i){
        if(i < 0 || i >= linhas) {
            throw new IllegalArgumentException("Indice fora dos limites estabelecidos.");
        }else{
            return elementos[i];
        }
    }

    // *Metodos para pegar linhas e colunas da matriz
    public int getLength(){
        return this.linhas;
    }
    public int getWidth(){
        return this.colunas;
    }

}
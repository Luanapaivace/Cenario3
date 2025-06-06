public class LinearAlgebra {
    // O metodo transpose sera estatico para ser acessado sem intancia da classe
    // Ira receber como parametro um objeto generico para poder trabalhar com qualquer tipo de objeto
    // O retorno sera object pois dependera do tipo de objeto que entrar

    public static Object transpose ( Object aqualquer ){
        // casting para mudar aqualquer para Matrix
        Matrix matriz = (Matrix) aqualquer;

        // criacao de uma nova matriz para ser a transposta
        double [][] transposed = new double [matriz.colunas][matriz.linhas];

        // loop para transpor a matriz
        for (int i = 0; i < matriz.linhas; i++) {
            for (int j = 0; j < matriz.colunas; j++) {
                transposed[j][i] = matriz.elementos[i][j];
            }
        }

        return new Matrix(matriz.colunas, matriz.linhas, transposed);
    }

    // Metodo SUM
    public static Object sum (Object a, Object b){
        if (a instanceof Matrix && b instanceof Matrix){

            Matrix matrizA = (Matrix) a;
            Matrix matrizB = (Matrix) b;

            if (matrizA.getLength() == matrizB.getLength() && matrizB.getWidth() == matrizA.getWidth()){

                int linhas = matrizA.getLength();
                int colunas = matrizA.getWidth();
                double [][] elementos = new double [linhas][colunas];

                for(int i = 0; i < linhas; i++){
                    for(int j = 0; j < colunas; j++){
                        elementos[i][j] = matrizA.get(i, j) + matrizB.get(i, j);
                    }
                }

                return new Matrix(linhas, colunas, elementos );

            }else{

                throw new IllegalArgumentException("Matrizes com dimensoes diferentes nao podem ser somadas!");

            }
        }
        else if (a instanceof Vector && b instanceof Vector){

            Vector vetorA = (Vector) a;
            Vector vetorB = (Vector) b;

            if(vetorA.getLength() == vetorB.getLength()){

                int dim = vetorA.getLength();
                double [] vetorResuSoma = new double [dim];

                for(int i = 0; i < vetorA.getLength(); i++){

                    vetorResuSoma [i] = vetorA.get(i) + vetorB.get(i);

                }

                return new Vector(dim,vetorResuSoma);

            }else {
                throw new IllegalArgumentException("Vetores com dimensoes diferentes nao podem ser somados!");
            }
        }
        else {
            throw new IllegalArgumentException("Nao e possivel somar esses elementos!");
        }
    }

    // Metodo dot
    public static Object dot(Object a, Object b) {
        if (a instanceof Matrix && b instanceof Matrix) {
            Matrix matrizA = (Matrix) a;
            Matrix matrizB = (Matrix) b;

            if (matrizA.getWidth() == matrizB.getLength()) {
                int linhas = matrizA.getLength();
                int colunas = matrizB.getWidth();
                double[][] matrizResuMultp = new double[linhas][colunas];

                for (int i = 0; i < linhas; i++) {
                    for (int j = 0; j < colunas; j++) {
                        for (int k = 0; k < matrizA.getWidth(); k++) {
                            matrizResuMultp[i][j] += matrizA.get(i, k) * matrizB.get(k, j);
                        }
                    }
                }
                return new Matrix(linhas, colunas, matrizResuMultp);
            } else {
                throw new IllegalArgumentException("Nao e possivel multiplicar as matrizes. Numero de colunas diferente do numero de linhas.");
            }

        } else if (a instanceof Vector && b instanceof Matrix) {
            Vector vetorA = (Vector) a;
            Matrix matrizB = (Matrix) b;

            int dim = matrizB.getWidth();
            int linhas = matrizB.getLength();

            if (vetorA.getLength() != linhas) {
                throw new IllegalArgumentException("Dimensoes diferentes, nao e possivel efetuar a operacao.");
            }

            double[] resultMult = new double[dim];
            for (int j = 0; j < dim; j++) {
                for (int i = 0; i < linhas; i++) {
                    resultMult[j] += vetorA.get(i) * matrizB.get(i, j);
                }
            }

            return new Vector(dim, resultMult);

        } else if (a instanceof Matrix && b instanceof Vector) {
            Matrix matrizA = (Matrix) a;
            Vector vetorB = (Vector) b;

            int linhas = matrizA.getLength();
            int colunas = matrizA.getWidth();

            // Caso especial: matriz com uma coluna (comportamento antigo)
            if (colunas == 1) {
                int colunasVetor = vetorB.getLength();
                double[][] matrizResuMult = new double[linhas][colunasVetor];

                for (int i = 0; i < linhas; i++) {
                    for (int j = 0; j < colunasVetor; j++) {
                        matrizResuMult[i][j] = matrizA.get(i, 0) * vetorB.get(j);
                    }
                }

                return new Matrix(linhas, colunasVetor, matrizResuMult);
            }

            // Multiplicação padrão Matrix x Vector -> retorna um vetor resultante
            if (vetorB.getLength() != colunas) {
                throw new IllegalArgumentException("Dimensoes diferentes, nao e possivel efetuar a operacao.");
            }

            double[] resultado = new double[linhas];
            for (int i = 0; i < linhas; i++) {
                double soma = 0;
                for (int j = 0; j < colunas; j++) {
                    soma += matrizA.get(i, j) * vetorB.get(j);
                }
                resultado[i] = soma;
            }

            return new Vector(linhas, resultado);

        } else if (a instanceof Double && b instanceof Matrix) {
            Matrix matrizB = (Matrix) b;
            Double escalar = (Double) a;

            int linhas = matrizB.getLength();
            int colunas = matrizB.getWidth();
            double[][] matrizResuMult = new double[linhas][colunas];

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    matrizResuMult[i][j] = matrizB.get(i, j) * escalar;
                }
            }

            return new Matrix(linhas, colunas, matrizResuMult);

        } else if (a instanceof Double && b instanceof Vector) {
            Vector vetorB = (Vector) b;
            Double escalar = (Double) a;

            int dim = vetorB.getLength();
            double[] resultMult = new double[dim];

            for (int j = 0; j < dim; j++) {
                resultMult[j] = vetorB.get(j) * escalar;
            }

            return new Vector(dim, resultMult);

        } else {
            throw new IllegalArgumentException("Nao foi possivel fazer a operacao com os elementos informados. Por favor insira elementos validos.");
        }
    }


    // Metodo times
    public static Object times (Object a, Object b){

        if(a instanceof Matrix && b instanceof Matrix){
            Matrix matrizA = (Matrix) a;
            Matrix matrizB = (Matrix) b;

            if(matrizA.getWidth() == matrizB.getLength()){

                int linhas = matrizB.getLength();
                int colunas = matrizA.getWidth();
                double [][] matrizResuMultp = new double [linhas][colunas];

                for(int i = 0; i < linhas; i++){
                    for(int j = 0; j < colunas; j++){

                        matrizResuMultp[i][j] = matrizA.get(i, j) * matrizB.get(i, j);

                    }
                }
                return new Matrix(linhas, colunas, matrizResuMultp);
            }else{
                throw new IllegalArgumentException("Nao e possivel multipilcar as matrizes. Numero de colunas diferente do numero de linhas.");
            }

        }else if(a instanceof Vector && b instanceof Vector){
            Vector vetorA = (Vector) a;
            Vector vetorB = (Vector) b;

            int dim = vetorA.getLength();
            double [] vetorResuMult = new double [dim];
            if(vetorA.getLength() == vetorB.getLength()){
                for(int i = 0; i < vetorA.getLength(); i++){

                    vetorResuMult [i] = vetorA.get(i) * vetorB.get(i);

                }
                return new Vector(dim, vetorResuMult);
            }else{
                throw new IllegalArgumentException("Os vetores têm dimensões diferentes. Não é possível multiplicá-los.");
            }

        }else if(a instanceof Double && b instanceof Matrix){

            Matrix matrizB = (Matrix) b;
            Double escalar = (Double) a;

            int linhas = matrizB.getLength();
            int colunas = matrizB.getWidth();
            double [][] matrizResuMult = new double [linhas][colunas];

            for(int i = 0; i < linhas; i++){
                for(int j = 0; j < colunas; j++){
                    matrizResuMult [i][j] = matrizB.get(i, j) * escalar;
                }
            }

            return new Matrix(linhas, colunas, matrizResuMult);

        }
        else if(a instanceof Double && b instanceof Vector){

            Vector vetorB = (Vector) b;
            Double escalar = (Double) a;

            int dim = vetorB.getLength();
            double [] resultMult = new double [dim];


            for(int j = 0; j < dim ; j++){

                resultMult[j] = vetorB.get(j) * escalar;

            }

            return new Vector (dim, resultMult);

        }
        else{
            throw new IllegalArgumentException("Nao foi possivel fazer a operacao com os elementos informados. Porvafor insira elementos validos.");
        }
    }

    // Metodo Gauss
    public static Matrix gauss(Matrix matriz){

        int linhas = matriz.getLength();
        int colunas = matriz.getWidth();

        // checando se o primeiro pivo e = 0
        for (int i = 0; i < Math.min(linhas, colunas); i++) {
            // Verifica se o pivô da linha i é 0
            if (matriz.get(i, i) == 0) {

                // Para avançar para o termo abaixo
                for (int j = i + 1; j < linhas; j++) {

                    // Se o termo de baixo for diferente de 0
                    if (matriz.get(j, i) != 0) {

                        for(int k = 0; k < colunas; k++){
                            double temp = matriz.get(i, k);
                            matriz.set(i, k, matriz.get(j,k));
                            matriz.set(j, k, temp);
                        }
                        break;
                    }
                }
            }

            // Eliminando elementos abaixo do pivô
            for (int k = i + 1; k < linhas; k++) {
                if (matriz.get(k, i) != 0) {
                    double fator = matriz.get(k, i) / matriz.get(i, i);
                    for (int j = i; j < colunas; j++) {
                        double novoValor = matriz.get(k, j) - fator * matriz.get(i, j);
                        matriz.set(k, j, novoValor);
                    }
                }
            }
        }

        return matriz;
    }
    public static Matrix solve(Matrix a, Vector termosIndependentes) {     //método usando gauss para resolver um sistemalinear
        int n = a.getLength(); //n de linhas da matriz A

        if(n != a.getWidth()){
            throw new IllegalArgumentException("A matriz deve ser quadrada dos coeficientes!");
        }

        //criando uma matriz q combine a matrizA com os termos independentes(matrizAumentada)
        //matriz aumentada com coluna extra para os termos independentes
        Matrix matrizAumentada = new Matrix(n, n + 1, new double[n][n + 1]);

        //preenchendo a parte da matriz A na matriz aumentada
        for (int i = 0; i < n; i++) { //laço pra percorrer as linhas
            for (int j = 0; j < n; j++) { //laço pra percorrer as colunas
                matrizAumentada.set(i, j, a.get(i, j)); //preenche a parte da matriz A na matriz aumentada
            }
            matrizAumentada.set(i, n, termosIndependentes.get(i)); //preenche a última coluna com os termos independentes
        }

        //chamando o método gauss para deixar a matriz aumentada em forma de triângulo
        //o método gauss vai modificar a matrizAumentada para uma forma triangular superior
        matrizAumentada = gauss(matrizAumentada);

        //substituição regressiva pra encontrar a solução do sistema
        double[] solucao = new double[n]; //vetor pra armazenar as soluções (valores das incógnitas)

        //laço pra percorrer as linhas da matriz, indo da última linha até a primeira (substituição regressiva)
        for (int i = n - 1; i >= 0; i--) {
            //começa com o valor da solução na última coluna da matriz aumentada
            solucao[i] = matrizAumentada.get(i, n); //o valor da solução é o elemento na última coluna (termo independente)

            //subtrai os valores já conhecidos das soluções pra a incógnita i
            for (int j = i + 1; j < n; j++) {
                solucao[i] -= matrizAumentada.get(i, j) * solucao[j]; //subtrai o produto dos coeficientes pela solução já encontrada
            }

            //divide pelo coeficiente principal pra encontrar o valor da incógnita i
            solucao[i] /= matrizAumentada.get(i, i); //agora o valor de solucao[i] é a solução pra a incógnita i
        }

        //criando a matriz resultado, que contém a solução do sistema
        double[][] solucaoArray = new double[n][1]; //criando uma matriz coluna pra armazenar a solução
        for (int i = 0; i < n; i++) { //preenchendo a matriz coluna com as soluções
            solucaoArray[i][0] = solucao[i]; //coloca a solução de cada incógnita na matriz coluna
        }

        //retorna a matriz coluna com a solução do sistema
        return new Matrix(n, 1, solucaoArray);
    }
}
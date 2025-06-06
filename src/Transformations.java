public class Transformations {

    //Translação 2D
    public static Vector translate2D(Vector vetor, double dx, double dy) {
        if (vetor.getLength() != 2) {
            throw new IllegalArgumentException("O vetor deve ter 2 dimensões para a translação 2D.");
        }

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { 1 }
        };

        double[][] matrizTranslacao = {
                { 1, 0, dx },
                { 0, 1, dy },
                { 0, 0, 1 }
        };

        Matrix matriz = new Matrix(3, 3, matrizTranslacao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);

        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0)
        };

        return new Vector(2, vetorResultado);
    }

    //Translação 3D
    public static Vector translate3D(Vector vetor, double dx, double dy, double dz){
        if (vetor.getLength() != 3){
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a translação 3D.");
        }
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };
        double [][] matrixTranslacao = {
                {1, 0, 0, dx},
                {0, 1, 0, dy},
                {0, 0, 1, dz},
                {0, 0, 0, 1}
        };
        Matrix matriz = new Matrix(4, 4, matrixTranslacao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);

        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Rotação 2D
    public static Vector rotation2D(Vector vetor, double anguloGraus, boolean horario) {
        if (vetor.getLength() != 2) {
            throw new IllegalArgumentException("O vetor deve ter 2 dimensões para a rotação 2D.");
        }

        if (horario) {
            anguloGraus = -anguloGraus;
        }

        double angulo = Math.toRadians(anguloGraus);
        double cos = Math.cos(angulo);
        double sin = Math.sin(angulo);

        double[][] matrizRotacao = {
                { cos, -sin, 0 },
                { sin,  cos, 0 },
                { 0,     0,  1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { 1 }
        };

        Matrix matriz = new Matrix(3, 3, matrizRotacao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);

        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0)
        };

        return new Vector(2, vetorResultado);
    }

    //Rotação 3DX
    public static Vector rotation3DX(Vector vetor, double anguloGraus, boolean horario) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a rotação 3D.");
        }

        if (horario) {
            anguloGraus = -anguloGraus;
        }

        double angulo = Math.toRadians(anguloGraus);
        double cos = Math.cos(angulo);
        double sin = Math.sin(angulo);

        double[][] matrizRotacao = {
                { 1, 0, 0, 0 },
                { 0, cos, -sin, 0 },
                { 0, sin,  cos, 0 },
                { 0, 0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizRotacao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Rotação 3DY
    public static Vector rotation3DY(Vector vetor, double anguloGraus, boolean horario) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a rotação 3D.");
        }

        if (horario) {
            anguloGraus = -anguloGraus;
        }

        double angulo = Math.toRadians(anguloGraus);
        double cos = Math.cos(angulo);
        double sin = Math.sin(angulo);

        double[][] matrizRotacao = {
                {  cos, 0, sin, 0 },
                {    0, 1,   0, 0 },
                { -sin, 0, cos, 0 },
                {    0, 0,   0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizRotacao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Rotação 3DZ
    public static Vector rotation3DZ(Vector vetor, double anguloGraus, boolean horario) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a rotação 3D.");
        }

        if (horario) {
            anguloGraus = -anguloGraus;
        }

        double angulo = Math.toRadians(anguloGraus);
        double cos = Math.cos(angulo);
        double sin = Math.sin(angulo);

        double[][] matrizRotacao = {
                { cos, -sin, 0, 0 },
                { sin,  cos, 0, 0 },
                {   0,    0, 1, 0 },
                {   0,    0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizRotacao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Reflexao 2DX
    public static Vector reflection2DX(Vector vetor){
        if(vetor.getLength() != 2){
            throw new IllegalArgumentException("O vetor deve ter 2 dimensões para reflexão 2D.");
        }
        double [][] matrizReflexao = {
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        };
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                {1}
        };
        Matrix matriz = new Matrix(3, 3, matrizReflexao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        return new Vector(2, new double[]{resultado.get(0, 0), resultado.get(1, 0)});
    }

    //Reflexão 2DY
    public static Vector reflection2DY(Vector vetor){
        if(vetor.getLength() != 2){
            throw new IllegalArgumentException("O vetor deve ter 2 dimensões para reflexão 2D.");
        }
        double [][] matrizReflexao = {
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                {1}
        };
        Matrix matriz = new Matrix(3, 3, matrizReflexao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        return new Vector(2, new double[]{resultado.get(0, 0), resultado.get(1, 0)});
    }
    //Reflexão 3DX
    public static Vector reflection3DX(Vector vetor){
        if(vetor.getLength() != 3){
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para reflexão 3D.");
        }
        //inverte o sinal da coordenada x, refletindo o objeto através do plano YZ.
        double [][] matrizReflexao = {
                {1, 0, 0, 0},
                {0, -1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}
        };
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                {1}
        };
        Matrix matriz = new Matrix(4, 4, matrizReflexao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        return new Vector(3, new double[]{resultado.get(0, 0), resultado.get(1, 0), resultado.get(2,0)});
    }
    //Reflexão 3DY
    public static Vector reflection3DY(Vector vetor){
        if(vetor.getLength() != 3){
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para reflexão 3D.");
        }
        //inverte o sinal da coordenada y, refletindo o objeto através do plano XZ.
        double [][] matrizReflexao = {
                {-1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}
        };
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                {1}
        };
        Matrix matriz = new Matrix(4, 4, matrizReflexao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        return new Vector(3, new double[]{resultado.get(0, 0), resultado.get(1, 0), resultado.get(2,0)});
    }
    //Reflexão 3DZ
    public static Vector reflection3DZ(Vector vetor){
        if(vetor.getLength() != 3){
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para reflexão 3D.");
        }
        //inverte o sinal da coordenada z, refletindo o objeto através do plano XY.
        double [][] matrizReflexao = {
                {-1, 0, 0, 0},
                {0, -1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        double [][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                {1}
        };
        Matrix matriz = new Matrix(4, 4, matrizReflexao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        return new Vector(3, new double[]{resultado.get(0, 0), resultado.get(1, 0), resultado.get(2,0)});
    }
    //Projeção 2DX
    public static Vector projection2DX(Vector vetor) {
        if (vetor.getLength() != 2) {
            throw new IllegalArgumentException("Vetor deve ter 2 dimensões para projeção 2D");
        }

        double[][] matrizProjecao = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { 1 }
        };

        Matrix matriz = new Matrix(3, 3, matrizProjecao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0)
        };

        return new Vector(2, vetorResultado);
    }

    //Projeção 2DY
    public static Vector projection2DY(Vector vetor) {
        if (vetor.getLength() != 2) {
            throw new IllegalArgumentException("Vetor deve ter 2 dimensões para projeção 2D");
        }

        double[][] matrizProjecao = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { 1 }
        };

        Matrix matriz = new Matrix(3, 3, matrizProjecao);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0)
        };

        return new Vector(2, vetorResultado);
    }

    //Projeção 3DX
    public static Vector projection3DX(Vector vetor) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a projeção 3D.");
        }

        double[][] matrizProjecao = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizProjecao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Projeção 3DY
    public static Vector projection3DY(Vector vetor) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a projeção 3D.");
        }

        double[][] matrizProjecao = {
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizProjecao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }

    //Projeção 3DZ
    public static Vector projection3DZ(Vector vetor) {
        if (vetor.getLength() != 3) {
            throw new IllegalArgumentException("O vetor deve ter 3 dimensões para a projeção 3D.");
        }

        double[][] matrizProjecao = {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { vetor.get(2) },
                { 1 }
        };

        Matrix matriz = new Matrix(4, 4, matrizProjecao);
        Matrix vetorMatrix = new Matrix(4, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0),
                resultado.get(2, 0)
        };

        return new Vector(3, vetorResultado);
    }
    //cisalhamento 2D
    public static Vector cisalhamento2D(Vector vetor, double kX, double kY) {
        if (vetor.getLength() != 2) {
            throw new IllegalArgumentException("O vetor deve ter 2 dimensões para o cisalhamento 2D.");
        }

        double[][] matrizCisalhamento = {
                { 1, kX, 0 },
                { kY, 1, 0 },
                { 0, 0, 1 }
        };

        double[][] vetorHomogeneo = {
                { vetor.get(0) },
                { vetor.get(1) },
                { 1 }
        };

        Matrix matriz = new Matrix(3, 3, matrizCisalhamento);
        Matrix vetorMatrix = new Matrix(3, 1, vetorHomogeneo);
        Matrix resultado = (Matrix) LinearAlgebra.dot(matriz, vetorMatrix);

        double[] vetorResultado = {
                resultado.get(0, 0),
                resultado.get(1, 0)
        };

        return new Vector(2, vetorResultado);
    }
}

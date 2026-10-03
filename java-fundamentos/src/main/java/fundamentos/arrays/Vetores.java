package fundamentos.arrays;

/** Aula de arrays e matrizes. */
public final class Vetores {

    private Vetores() {
    }

    public static double media(double[] valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Vetor vazio não tem média");
        }
        double soma = 0;
        for (double v : valores) {
            soma += v;
        }
        return soma / valores.length;
    }

    public static int maior(int[] valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Vetor vazio não tem maior valor");
        }
        int maior = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maior) {
                maior = valores[i];
            }
        }
        return maior;
    }

    /** Devolve um vetor novo invertido, sem mexer no original. */
    public static int[] invertido(int[] valores) {
        int[] copia = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            copia[i] = valores[valores.length - 1 - i];
        }
        return copia;
    }

    /** Transposta: a linha i vira a coluna i. */
    public static int[][] transposta(int[][] m) {
        if (m.length == 0) {
            return new int[0][0];
        }
        int[][] t = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }

    /** Soma de cada linha, funcionando também em matriz irregular (linhas de tamanhos diferentes). */
    public static int[] somaDasLinhas(int[][] m) {
        int[] somas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int valor : m[i]) {
                somas[i] += valor;
            }
        }
        return somas;
    }
}

package fundamentos.repeticao;

/** Aula de estruturas de repetição: for, while e do-while. */
public final class Lacos {

    private Lacos() {
    }

    /** Tabuada de 1 a 10, uma linha por multiplicação. */
    public static String tabuada(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append(n).append(" x ").append(i).append(" = ").append(n * i);
            if (i < 10) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static long fatorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Fatorial de 0 a 20 cabe em long: " + n);
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /** Soma dos dígitos com while: 1234 vira 1 + 2 + 3 + 4 = 10. */
    public static int somaDosDigitos(int n) {
        n = Math.abs(n);
        int soma = 0;
        while (n > 0) {
            soma += n % 10;
            n /= 10;
        }
        return soma;
    }

    /** Conta os dígitos com do-while, que roda pelo menos uma vez (assim o 0 tem 1 dígito). */
    public static int quantidadeDeDigitos(int n) {
        n = Math.abs(n);
        int digitos = 0;
        do {
            digitos++;
            n /= 10;
        } while (n > 0);
        return digitos;
    }

    /** Testa divisores só até a raiz quadrada. */
    public static boolean primo(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; (long) d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }
}

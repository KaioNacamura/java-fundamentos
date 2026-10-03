package fundamentos.condicionais;

/** Aula de estruturas condicionais: if/else, switch e operador ternário. */
public final class Notas {

    private Notas() {
    }

    /** Situação do aluno pela média final: aprovado (7 ou mais), exame (de 4 a 7) ou reprovado. */
    public static String situacao(double media) {
        if (media < 0 || media > 10) {
            throw new IllegalArgumentException("A média vai de 0 a 10: " + media);
        }
        if (media >= 7) {
            return "aprovado";
        } else if (media >= 4) {
            return "exame";
        }
        return "reprovado";
    }

    /** Conceito pela nota, com switch de expressão (Java 14+). */
    public static char conceito(int nota) {
        return switch (nota) {
            case 10, 9 -> 'A';
            case 8, 7 -> 'B';
            case 6, 5 -> 'C';
            case 4, 3, 2, 1, 0 -> 'D';
            default -> throw new IllegalArgumentException("Nota inválida: " + nota);
        };
    }

    /** Ano bissexto: divisível por 4, exceto os divisíveis por 100 que não são por 400. */
    public static boolean bissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }

    public static String parOuImpar(int n) {
        return n % 2 == 0 ? "par" : "ímpar";
    }
}

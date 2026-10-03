package fundamentos.metodos;

/** Aula de métodos estáticos e sobrecarga: o mesmo nome com parâmetros diferentes. */
public final class Geometria {

    private Geometria() {
    }

    /** Área do quadrado. */
    public static double area(double lado) {
        return lado * lado;
    }

    /** Área do retângulo. */
    public static double area(double base, double altura) {
        return base * altura;
    }

    /** Área do trapézio. */
    public static double area(double baseMaior, double baseMenor, double altura) {
        return (baseMaior + baseMenor) * altura / 2;
    }

    /** Soma com número variável de argumentos (varargs). */
    public static int somar(int... numeros) {
        int total = 0;
        for (int n : numeros) {
            total += n;
        }
        return total;
    }
}

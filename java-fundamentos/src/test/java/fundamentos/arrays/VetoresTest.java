package fundamentos.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class VetoresTest {

    @Test
    void mediaEMaior() {
        assertEquals(7.5, Vetores.media(new double[] {6, 7, 8, 9}), 1e-9);
        assertEquals(42, Vetores.maior(new int[] {-5, 42, 3}));
        assertThrows(IllegalArgumentException.class, () -> Vetores.maior(new int[0]));
    }

    @Test
    void invertidoNaoMexeNoOriginal() {
        int[] original = {1, 2, 3};
        assertArrayEquals(new int[] {3, 2, 1}, Vetores.invertido(original));
        assertArrayEquals(new int[] {1, 2, 3}, original);
    }

    @Test
    void transposta() {
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        int[][] esperado = {{1, 4}, {2, 5}, {3, 6}};
        int[][] t = Vetores.transposta(m);
        assertEquals(3, t.length);
        for (int i = 0; i < esperado.length; i++) {
            assertArrayEquals(esperado[i], t[i]);
        }
    }

    @Test
    void somaDasLinhasEmMatrizIrregular() {
        int[][] irregular = {{1}, {2, 3}, {4, 5, 6}};
        assertArrayEquals(new int[] {1, 5, 15}, Vetores.somaDasLinhas(irregular));
    }
}

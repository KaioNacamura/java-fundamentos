package fundamentos.repeticao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LacosTest {

    @Test
    void tabuadaTemDezLinhas() {
        String[] linhas = Lacos.tabuada(7).split("\n");
        assertEquals(10, linhas.length);
        assertEquals("7 x 1 = 7", linhas[0]);
        assertEquals("7 x 10 = 70", linhas[9]);
    }

    @Test
    void fatorial() {
        assertEquals(1, Lacos.fatorial(0));
        assertEquals(120, Lacos.fatorial(5));
        assertEquals(2432902008176640000L, Lacos.fatorial(20));
        assertThrows(IllegalArgumentException.class, () -> Lacos.fatorial(21));
    }

    @Test
    void digitos() {
        assertEquals(10, Lacos.somaDosDigitos(1234));
        assertEquals(10, Lacos.somaDosDigitos(-1234));
        assertEquals(1, Lacos.quantidadeDeDigitos(0));
        assertEquals(4, Lacos.quantidadeDeDigitos(1000));
    }

    @Test
    void primos() {
        assertFalse(Lacos.primo(1));
        assertTrue(Lacos.primo(2));
        assertTrue(Lacos.primo(97));
        assertFalse(Lacos.primo(91));
        assertTrue(Lacos.primo(2147483647));
    }
}

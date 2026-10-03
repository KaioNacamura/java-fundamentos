package fundamentos.condicionais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NotasTest {

    @Test
    void situacaoNosLimites() {
        assertEquals("aprovado", Notas.situacao(7.0));
        assertEquals("exame", Notas.situacao(6.9));
        assertEquals("exame", Notas.situacao(4.0));
        assertEquals("reprovado", Notas.situacao(3.9));
    }

    @Test
    void mediaForaDaEscalaDaErro() {
        assertThrows(IllegalArgumentException.class, () -> Notas.situacao(10.5));
        assertThrows(IllegalArgumentException.class, () -> Notas.situacao(-1));
    }

    @Test
    void conceitos() {
        assertEquals('A', Notas.conceito(9));
        assertEquals('B', Notas.conceito(7));
        assertEquals('C', Notas.conceito(5));
        assertEquals('D', Notas.conceito(0));
        assertThrows(IllegalArgumentException.class, () -> Notas.conceito(11));
    }

    @Test
    void anosBissextos() {
        assertTrue(Notas.bissexto(2024));
        assertTrue(Notas.bissexto(2000));
        assertFalse(Notas.bissexto(1900));
        assertFalse(Notas.bissexto(2026));
    }

    @Test
    void parOuImpar() {
        assertEquals("par", Notas.parOuImpar(0));
        assertEquals("ímpar", Notas.parOuImpar(-3));
    }
}

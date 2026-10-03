package fundamentos.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PessoaTest {

    @Test
    void mesmoCpfEhIgualMasNaoEhOMesmoObjeto() {
        Pessoa a = new Pessoa("123", "Ana");
        Pessoa b = new Pessoa("123", "Ana Lima");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotSame(a, b);
    }

    @Test
    void duasVariaveisApontandoProMesmoObjeto() {
        Pessoa a = new Pessoa("123", "Ana");
        Pessoa apelido = a;
        apelido.setNome("Ana Maria");
        assertSame(a, apelido);
        assertEquals("Ana Maria", a.getNome());
    }

    @Test
    void setterValidaONome() {
        Pessoa a = new Pessoa("123", "Ana");
        assertThrows(IllegalArgumentException.class, () -> a.setNome("   "));
        assertEquals("Ana", a.getNome());
    }
}

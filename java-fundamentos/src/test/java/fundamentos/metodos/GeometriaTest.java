package fundamentos.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeometriaTest {

    @Test
    void sobrecargaEscolhePelaQuantidadeDeParametros() {
        assertEquals(9.0, Geometria.area(3), 1e-9);
        assertEquals(12.0, Geometria.area(3, 4), 1e-9);
        assertEquals(15.0, Geometria.area(6, 4, 3), 1e-9);
    }

    @Test
    void varargs() {
        assertEquals(0, Geometria.somar());
        assertEquals(6, Geometria.somar(1, 2, 3));
    }
}

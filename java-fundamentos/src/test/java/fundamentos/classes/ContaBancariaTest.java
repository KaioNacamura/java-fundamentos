package fundamentos.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContaBancariaTest {

    @Test
    void depositoInicialPeloConstrutor() {
        ContaBancaria conta = new ContaBancaria("001", "Ana", 10_000);
        assertEquals(10_000, conta.getSaldoCentavos());
        assertEquals(1, conta.getExtrato().size());
    }

    @Test
    void naoSacaMaisDoQueTem() {
        ContaBancaria conta = new ContaBancaria("001", "Ana", 5_000);
        assertThrows(IllegalStateException.class, () -> conta.sacar(5_001));
        assertEquals(5_000, conta.getSaldoCentavos());
    }

    @Test
    void transferenciaMexeNasDuasContas() {
        ContaBancaria origem = new ContaBancaria("001", "Ana", 10_000);
        ContaBancaria destino = new ContaBancaria("002", "Bruno");
        origem.transferir(destino, 2_500);
        assertEquals(7_500, origem.getSaldoCentavos());
        assertEquals(2_500, destino.getSaldoCentavos());
    }

    @Test
    void transferenciaSemSaldoNaoMexeEmNada() {
        ContaBancaria origem = new ContaBancaria("001", "Ana", 1_000);
        ContaBancaria destino = new ContaBancaria("002", "Bruno");
        assertThrows(IllegalStateException.class, () -> origem.transferir(destino, 2_000));
        assertEquals(1_000, origem.getSaldoCentavos());
        assertEquals(0, destino.getSaldoCentavos());
    }

    @Test
    void valoresInvalidos() {
        ContaBancaria conta = new ContaBancaria("001", "Ana");
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> conta.transferir(conta, 100));
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("", "Ana"));
    }

    @Test
    void extratoNaoPodeSerAlteradoPorFora() {
        ContaBancaria conta = new ContaBancaria("001", "Ana", 100);
        assertThrows(UnsupportedOperationException.class, () -> conta.getExtrato().clear());
    }
}

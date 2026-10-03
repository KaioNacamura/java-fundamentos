package fundamentos.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aulas de classes, construtores e encapsulamento.
 * O saldo é privado: só muda por depósito, saque ou transferência,
 * e cada um confere a regra antes de mexer no valor.
 * Valores em centavos para não ter erro de arredondamento.
 */
public class ContaBancaria {

    private final String numero;
    private final String titular;
    private long saldoCentavos;
    private final List<String> extrato = new ArrayList<>();

    public ContaBancaria(String numero, String titular) {
        this(numero, titular, 0);
    }

    /** Construtor sobrecarregado: abre a conta já com um depósito inicial. */
    public ContaBancaria(String numero, String titular, long depositoInicialCentavos) {
        if (numero == null || numero.isBlank() || titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Número e titular são obrigatórios");
        }
        this.numero = numero;
        this.titular = titular;
        if (depositoInicialCentavos > 0) {
            depositar(depositoInicialCentavos);
        }
    }

    public void depositar(long centavos) {
        if (centavos <= 0) {
            throw new IllegalArgumentException("Depósito precisa ser positivo");
        }
        saldoCentavos += centavos;
        extrato.add("depósito " + centavos);
    }

    public void sacar(long centavos) {
        if (centavos <= 0) {
            throw new IllegalArgumentException("Saque precisa ser positivo");
        }
        if (centavos > saldoCentavos) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldoCentavos -= centavos;
        extrato.add("saque " + centavos);
    }

    /** Só tira da origem se o destino for uma conta diferente e o saldo der. */
    public void transferir(ContaBancaria destino, long centavos) {
        if (destino == null || destino == this) {
            throw new IllegalArgumentException("Conta de destino inválida");
        }
        sacar(centavos);
        destino.depositar(centavos);
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public long getSaldoCentavos() {
        return saldoCentavos;
    }

    /** Devolve uma lista só de leitura, para ninguém apagar linha do extrato por fora. */
    public List<String> getExtrato() {
        return Collections.unmodifiableList(extrato);
    }
}

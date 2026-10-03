package fundamentos.classes;

import java.util.Objects;

/**
 * Identidade x igualdade: dois objetos Pessoa com o mesmo CPF são "iguais" (equals),
 * mas continuam sendo objetos diferentes na memória (==).
 */
public class Pessoa {

    private final String cpf;
    private String nome;

    public Pessoa(String cpf, String nome) {
        this.cpf = Objects.requireNonNull(cpf);
        setNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        this.nome = nome.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o instanceof Pessoa outra && cpf.equals(outra.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}

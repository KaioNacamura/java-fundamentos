# java-fundamentos

Exercícios de Java da disciplina Programação de Sistemas I (Sistemas de Informação, Mackenzie), organizados por aula e com testes em JUnit 5.

Cada exercício tem um teste que confere o resultado, inclusive nos casos de limite (média exatamente 7, fatorial de 0, vetor vazio). O GitHub Actions roda tudo a cada push.

## Conteúdo

| Pacote | Aula | O que tem |
| --- | --- | --- |
| `condicionais` | if/else, switch, ternário | situação pela média, conceito com `switch` de expressão, ano bissexto, par ou ímpar |
| `repeticao` | for, while, do-while | tabuada, fatorial, soma e contagem de dígitos, número primo |
| `arrays` | vetores e matrizes | média, maior valor, vetor invertido, transposta, soma das linhas de matriz irregular |
| `metodos` | métodos estáticos e sobrecarga | `area` com 1, 2 ou 3 parâmetros, `somar` com varargs |
| `classes` | classes, construtores e encapsulamento | `ContaBancaria` com saldo privado e construtor sobrecarregado; `Pessoa` mostrando a diferença entre `equals` e `==` |

Algumas escolhas que valem comentar:

- O saldo da `ContaBancaria` fica em centavos (`long`), porque `double` erra em conta de dinheiro.
- `getExtrato()` devolve uma lista só de leitura. Sem isso, quem chamasse o método poderia apagar linhas do extrato por fora da classe.
- Uma transferência sem saldo não mexe em nenhuma das duas contas.
- `PessoaTest` mostra duas variáveis apontando para o mesmo objeto: mudar o nome por uma muda pela outra.

## Rodando

Precisa de Java 21 e Maven.

```bash
mvn test
```

Para rodar só uma aula:

```bash
mvn test -Dtest=LacosTest
```

## Estrutura

```
src/main/java/fundamentos/<aula>/   exercícios
src/test/java/fundamentos/<aula>/   testes
```

package br.com.alura.estoque.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {
    private Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> parans) {
        // 1) Pegar todos os métodos da classe.
        // 2) Filtrar todos os métodos de modo que:
        // 2.1) Tenham o mesmo nome informado pelo usuário;
        // 2.2) Tenham a mesma quantidade de parâmetros passados na URL;
        // 2.3) E que cada um dos parâmetros tenham os mesmos nomes e tipos iguais aos passados na URL.
        // 3) Lançar uma RuntimeException caso nenhum método seja encontrado.

        Stream<Method> methods = Stream.of(instancia.getClass().getDeclaredMethods());
        Method metodoSelecionado = methods.filter(metodo -> true)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Método não encontrado"));
        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(instancia, metodo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

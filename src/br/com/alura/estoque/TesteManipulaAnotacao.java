package br.com.alura.estoque;

import br.com.alura.estoque.alurator.anotacao.NomeTagXml;
import br.com.alura.estoque.modelo.Produto;

public class TesteManipulaAnotacao {

    public static void main(String[] args) {
        Produto produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> classe = produto.getClass();

        System.out.println(classe.getDeclaredAnnotation(NomeTagXml.class).value());
    }
}

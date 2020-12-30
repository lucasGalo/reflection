package br.com.alura.estoque;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
    public static void main(String[] args) throws Exception{
        Class<?> controleClasse = Class.forName("br.com.alura.estoque.alurator.controle.Controle");

        Constructor<?> constructorPadrao = controleClasse.getDeclaredConstructor();

        Object controle = constructorPadrao.newInstance();

        Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class);

        Object retorno = m.invoke(controle, "Pintassilgo do Agreste");

        System.out.println(retorno);
    }
}

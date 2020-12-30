package br.com.alura.estoque;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametros {
    public static void main(String[] args) throws Exception{
        Class<?> subControleClasse = Class.forName("br.com.alura.estoque.sub.SubControle");

        Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
        construtorPadrao.setAccessible(true);// obtem os construtores de uma classe

        Object subControle = construtorPadrao.newInstance();

        for(Method m : subControleClasse.getMethods()){
            System.out.println(m);
        }
        System.out.println();

        for (Method m : subControleClasse.getDeclaredMethods()){
            System.out.println(m);
        }

        System.out.println();

        Method m = subControle.getClass().getDeclaredMethod("metodoSubControle1");
        m.setAccessible(true);
        m.invoke(subControle);
    }
}

package br.com.alura.estoque.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {
    private Constructor<?> constructor;

    public ManipuladorConstrutor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Object invoca() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException  e) {
            e.printStackTrace();
            return new RuntimeException("Erro no contrutor!");
        }catch (InvocationTargetException e){
            e.printStackTrace();
            return new RuntimeException("Erro no contrutor!", e.getTargetException());
        }
    }
}

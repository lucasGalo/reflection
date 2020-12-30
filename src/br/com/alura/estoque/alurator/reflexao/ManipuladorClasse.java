package br.com.alura.estoque.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

    private Class<?> classe;

    public ManipuladorClasse(Class<?> classe) {

        this.classe = classe;
    }

    public ManipuladorConstrutor getContrutorPadrao() {
        try {
            Constructor<?> constructorPadrao = classe.getDeclaredConstructor();
            return new ManipuladorConstrutor(constructorPadrao);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ManipuladorObjeto criaInstancia(){
        Object instancia = getContrutorPadrao().invoca();
        return new ManipuladorObjeto(instancia);
    }
}

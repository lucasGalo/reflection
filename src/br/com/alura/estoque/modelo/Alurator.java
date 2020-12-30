package br.com.alura.estoque.modelo;

import br.com.alura.estoque.alurator.protocolo.Request;
import br.com.alura.estoque.alurator.reflexao.Reflexao;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
//        String[] partesUrl = url.replaceFirst("/", "").split("/");
//        String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0)) +
//                partesUrl[0].substring(1) + "Controller";

        Request request = new Request(url);

        String nomeControler = request.getNomeControler();
        String nomeMetodo = request.getNomeMetodo();

//        try {

//        Object retorno = new Reflexao()
//                .refleteClasse(pacoteBase + nomeControler)
//                .getContrutorPadrao()
//                .invoca();

        Object retorno = new Reflexao()
                .refleteClasse(pacoteBase + nomeControler)
                .criaInstancia()
                .getMetodo(nomeMetodo)
                .invoca();

//            Class<?> classeControle = Class.forName(pacoteBase + nomeControler);
//            Object retorno = classeControle.getDeclaredConstructor().newInstance();

        System.out.println(retorno);
        return retorno;
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//                | IllegalArgumentException | NoSuchMethodException | SecurityException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Erro no construtor!", e.getTargetException());
//        }
    }
}

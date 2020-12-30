package br.com.alura.estoque.modelo;

import br.com.alura.estoque.alurator.protocolo.Request;
import br.com.alura.estoque.alurator.reflexao.Reflexao;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        Request request = new Request(url);

        String nomeControler = request.getNomeControler();
        String nomeMetodo = request.getNomeMetodo();

        Object retorno = new Reflexao()
                .refleteClasse(pacoteBase + nomeControler)
                .criaInstancia()
                .getMetodo(nomeMetodo)
                .invoca();

        System.out.println(retorno);
        return retorno;
    }
}

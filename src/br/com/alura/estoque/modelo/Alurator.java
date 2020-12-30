package br.com.alura.estoque.modelo;

import br.com.alura.estoque.alurator.protocolo.Request;
import br.com.alura.estoque.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        Request request = new Request(url);

        String nomeControler = request.getNomeControler();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> parans = request.getQueryParans();

        Object retorno = new Reflexao()
                .refleteClasse(pacoteBase + nomeControler)
                .criaInstancia()
                .getMetodo(nomeMetodo, parans)
                .invoca();

        System.out.println(retorno);
        return retorno;
    }
}

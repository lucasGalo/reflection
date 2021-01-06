package br.com.alura.estoque.modelo;

import br.com.alura.estoque.alurator.conversor.ConversorXML;
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
                .comTratamentoDeExcecao((metodo, e) -> {
                    System.out.println("Erro no método " + metodo.getName() + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n");
                    throw new RuntimeException("ERRO!");
                })
                .invoca();

        System.out.println(retorno);

        retorno = new ConversorXML().converte(retorno);
        return retorno;
    }
}

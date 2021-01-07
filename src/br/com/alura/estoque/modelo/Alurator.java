package br.com.alura.estoque.modelo;

import br.com.alura.estoque.alurator.conversor.ConversorXML;
import br.com.alura.estoque.alurator.ioc.ContainerIoc;
import br.com.alura.estoque.alurator.protocolo.Request;
import br.com.alura.estoque.alurator.reflexao.ManipuladorObjeto;
import br.com.alura.estoque.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;
    private ContainerIoc container;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.container = new ContainerIoc();
    }

    public Object executa(String url) {
        Request request = new Request(url);

        String nomeControler = request.getNomeControler();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> parans = request.getQueryParans();

        Class<?> classeControle = new Reflexao().getClasse(pacoteBase + nomeControler);
        Object instanciaControle = container.getInstancia(classeControle);
        Object retorno = new ManipuladorObjeto(instanciaControle)
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

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        container.registra(tipoFonte, tipoDestino);
    }
}

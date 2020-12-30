package br.com.alura.estoque.alurator.protocolo;

import br.com.alura.estoque.alurator.utils.QueryParamsBuilder;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String nomeControler;
    private String nomeMetodo;
    private Map<String, Object> queryParans;

    public Request(String url) {
        // /nomeControle/nomeMetodo
        /*
         * Casos possíveis:
         * /controlador/metodo
         * /controlador/metodo?param1=valor1&param2=valor2
         *
         */
        String[] partesUrl = url.replaceFirst("/", "").split("[?]");

        String[] controleEMetodo = partesUrl[0].split("/");

        nomeControler = Character.toUpperCase(controleEMetodo[0].charAt(0)) +
                controleEMetodo[0].substring(1) + "Controller";

        nomeMetodo = controleEMetodo[1];

        queryParans = partesUrl.length > 1
                ? new QueryParamsBuilder().comParametros(partesUrl[1]).build()
                : new HashMap<String, Object>();
    }

    public String getNomeControler() {
        return nomeControler;
    }


    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Map<String, Object> getQueryParans() {
        return queryParans;
    }
}

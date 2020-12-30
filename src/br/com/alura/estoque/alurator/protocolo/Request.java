package br.com.alura.estoque.alurator.protocolo;

public class Request {

    private String nomeControler;
    private String nomeMetodo;

    public Request(String url) {
        // /nomeControle/nomeMetodo
        String[] partesUrl = url.replaceFirst("/", "").split("/");
        nomeControler = Character.toUpperCase(partesUrl[0].charAt(0)) +
                partesUrl[0].substring(1) + "Controller";
    }

    public String getNomeControler() {
        return nomeControler;
    }


    public String getNomeMetodo(){
        return nomeMetodo;
    }
}

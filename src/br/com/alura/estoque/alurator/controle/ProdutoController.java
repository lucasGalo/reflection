package br.com.alura.estoque.alurator.controle;

import br.com.alura.estoque.dao.ProdutoDaoMock;

public class ProdutoController {


    private ProdutoDaoMock produtoDao;

    //Código atual.
    public ProdutoController() {
        this.produtoDao = new ProdutoDaoMock();
    }

    //O que queremos.
    public ProdutoController(ProdutoDaoMock produtoDao) {
        this.produtoDao = produtoDao;

    }
}
package com.dio.exemple_rest;

import com.dio.exemple_rest.Entity.Produto;
import com.dio.exemple_rest.Exception.ProductPriceException;
import com.dio.exemple_rest.Service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void verificaValorNegativoNoProduto() throws Exception{
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(-10.0);

       assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
    }
}

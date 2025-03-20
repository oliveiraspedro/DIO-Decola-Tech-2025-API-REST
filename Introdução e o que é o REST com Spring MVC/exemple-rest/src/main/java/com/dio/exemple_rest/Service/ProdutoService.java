package com.dio.exemple_rest.Service;

import com.dio.exemple_rest.Entity.Produto;
import com.dio.exemple_rest.Exception.ProductNullException;
import com.dio.exemple_rest.Exception.ProductPriceException;
import com.dio.exemple_rest.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) throws Exception{
        if (produto.getNome() == null || produto.getPreco() == null){
            throw new ProductNullException();
        }
        if (produto.getPreco() < 0){
            throw new ProductPriceException();
        }
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

}

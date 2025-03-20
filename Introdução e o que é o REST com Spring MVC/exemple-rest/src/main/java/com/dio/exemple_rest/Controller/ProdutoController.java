package com.dio.exemple_rest.Controller;

import com.dio.exemple_rest.Entity.Produto;
import com.dio.exemple_rest.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto") // Endpoint /produto
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {
        produto = service.save(produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos(){
        List<Produto> produto = service.findAll();
        return ResponseEntity.ok(produto);
    }

}

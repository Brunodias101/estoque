package com.example.produto.controller;

import com.example.produto.entity.ProdutoEntity;
import com.example.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/cadastrar")
    public ProdutoEntity cadastrarProduto(@RequestBody ProdutoEntity produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping
    public List<ProdutoEntity> buscarTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoEntity> buscarProdutosId(@PathVariable Long id) {
        return produtoService.buscarProdutosId(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProdutoEntity atualizarProduto(@PathVariable Long id, @RequestBody ProdutoEntity produtoEntity) {
        return produtoService.atualizarProduto(id, produtoEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }


}

package com.example.produto.service;

import com.example.produto.entity.ProdutoEntity;
import com.example.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity cadastrarProduto(ProdutoEntity novoProduto){
        ProdutoEntity produtoCadastrado = produtoRepository.save(novoProduto);
        return produtoCadastrado;
    }

    public List<ProdutoEntity> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoEntity> buscarProdutosId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produtoEntity){
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente informado por Id não encontrado"));
        produto.setNome(produtoEntity.getNome());
        produto.setDescricao(produtoEntity.getDescricao());
        produto.setCategoria(produtoEntity.getCategoria());
        produto.setQuantidade(produtoEntity.getQuantidade());
        produto.setValor(produtoEntity.getValor());

        return produtoRepository.save(produto);
    }


    public void  excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }
}

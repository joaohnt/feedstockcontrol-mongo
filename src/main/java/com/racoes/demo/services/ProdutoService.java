package com.racoes.demo.services;

import com.racoes.demo.domain.Produto;
import com.racoes.demo.dto.ProdutoDTO;
import com.racoes.demo.repositories.ProdutoRepository;
import com.racoes.demo.resources.ProdutoResource;
import com.racoes.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public List<Produto> findAll() {
        return repo.findAll();
    }

    public Produto findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public Produto insert (Produto produto) {
        return repo.insert(produto);
    }

    public void delete(String id) {
        findById(id); // p lançar a execao
        repo.deleteById(id);
    }

    public Produto update(Produto produto) {
        Produto newObj = repo.findById(produto.getId()).orElseThrow(() -> new ObjectNotFoundException(produto.getId()));
        updateData(newObj, produto);
        return repo.save(produto);
    }

    private void updateData(Produto newObj, Produto produto) {
        newObj.setNome(produto.getNome());
        newObj.setDescricao(produto.getDescricao());
        newObj.setPreco(produto.getPreco());

    }

    public Produto fromDTO(ProdutoDTO objDto) {
        return new Produto(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getPreco());
    }

}

package com.racoes.demo.services;

import com.racoes.demo.domain.Lote;
import com.racoes.demo.domain.Produto;
import com.racoes.demo.repositories.LoteRepository;
import com.racoes.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {
    @Autowired
    private LoteRepository repo;

    @Autowired
    private ProdutoService produtoService;

    // Método para obter todos os lotes
    public List<Lote> findAll() {
        return repo.findAll(); // Retorna a lista de lotes diretamente do repositório
    }

    // Método para encontrar um lote por ID
    public Lote findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id)); // Lança exceção se não encontrar o lote
    }

    // Método para inserir um novo lote
    public Lote insert(Lote lote) {
        // O lote pode já ter um produto associado via DBRef, então apenas salvamos
        return repo.insert(lote);
    }

    // Método para deletar um lote por ID
    public void delete(String id) {
        findById(id); // Lança a exceção se não encontrar o lote
        repo.deleteById(id); // Deleta o lote
    }

    // Método para atualizar um lote existente
    public Lote update(Lote lote) {
        Lote existingLote = repo.findById(lote.getId())
                .orElseThrow(() -> new ObjectNotFoundException(lote.getId()));
        // Atualiza os dados do lote
        existingLote.setQuantidade(lote.getQuantidade());
        existingLote.setDataValidade(lote.getDataValidade());
        // Retorna o lote atualizado
        return repo.save(existingLote);
    }
}

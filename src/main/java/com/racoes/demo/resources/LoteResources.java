package com.racoes.demo.resources;

import com.racoes.demo.domain.Lote;
import com.racoes.demo.domain.Produto;
import com.racoes.demo.dto.ProdutoDTO;
import com.racoes.demo.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/lotes")
public class LoteResources {

    @Autowired
    private LoteService service;

    @GetMapping
    public ResponseEntity<List<Lote>> findAll() {
        List<Lote> list = service.findAll();  // Obtém todos os lotes
        return ResponseEntity.ok().body(list); // Retorna a lista de lotes
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Lote> findById(@PathVariable String id) {
        Lote lote = service.findById(id);
        return ResponseEntity.ok().body(lote);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Lote lote) {
        lote = service.insert(lote);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lote.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody Lote lote, @PathVariable String id) {
        lote.setId(id);  // Definindo o ID do lote recebido para atualizar o lote correto
        lote = service.update(lote);
        return ResponseEntity.noContent().build();
    }

}

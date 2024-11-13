package com.racoes.demo.config;

import com.racoes.demo.domain.Lote;
import com.racoes.demo.domain.Produto;
import com.racoes.demo.repositories.LoteRepository;
import com.racoes.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner{
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LoteRepository loteRepository;

    @Override
    public void run(String... args) throws Exception {

        produtoRepository.deleteAll();
        loteRepository.deleteAll();

        Produto racao1 = new Produto(null, "Pedigree", "Ração de cachorro pedigree frango", 25.0);
        Produto racao2 = new Produto(null, "Whiskas", "Ração de gato whiskas", 10.0);
        Produto racao3 = new Produto(null, "Megazoo", "Ração de calopsita megazoo", 7.99);

        Lote lote1 = new Lote(null,100, LocalDate.of(2024,12,31), racao1);
        Lote lote2 = new Lote(null,160, LocalDate.of(2024,05,24), racao2);
        Lote lote3 = new Lote(null,489, LocalDate.of(2024,01,02), racao1);

        produtoRepository.saveAll(Arrays.asList(racao1, racao2, racao3));
        loteRepository.saveAll(Arrays.asList(lote1, lote2, lote3));
    }
}

package com.racoes.demo.config;

import com.racoes.demo.domain.Produto;
import com.racoes.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner{
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        produtoRepository.deleteAll();

        Produto racao1 = new Produto(null, "Pedigree", "Ração de cachorro pedigree frango", 25.0);
        Produto racao2 = new Produto(null, "Whiskas", "Ração de gato whiskas", 10.0);
        Produto racao3 = new Produto(null, "Megazoo", "Ração de calopsita megazoo", 7.99);

        produtoRepository.saveAll(Arrays.asList(racao1, racao2, racao3));
    }
}

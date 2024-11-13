package com.racoes.demo.repositories;

import com.racoes.demo.domain.Lote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoteRepository  extends MongoRepository<Lote, String> {
}

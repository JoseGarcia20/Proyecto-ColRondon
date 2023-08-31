package com.juanJoseRondon.app.repository;

import com.juanJoseRondon.app.entity.docente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface docenteRepository extends MongoRepository<docente, String> {
	
}

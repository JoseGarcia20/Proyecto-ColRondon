package com.juanJoseRondon.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.juanJoseRondon.app.entity.comentariosForo;

public interface comentarioForoRepository extends MongoRepository<comentariosForo, String>{
	
	@Query("{'foroAcademico.id': ?0}")
	List<comentariosForo> findByComentariosForo (String id);

}

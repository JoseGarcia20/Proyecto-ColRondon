package com.juanJoseRondon.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.juanJoseRondon.app.entity.estudiantes;

public interface estudiantesRepository extends MongoRepository<estudiantes, String>{
	
	@Query("{'acudiente.id': ?0}")
	estudiantes findByAcudienteEstudiante (String id);
	
	@Query("{'grado.id': ?0}")
	List<estudiantes> findByEstudiantesGrado (String id);
	
}


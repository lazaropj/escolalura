package br.com.alura.escolalura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.escolalura.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

}

package educa.ead.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educa.ead.modelos.Aluno;
import educa.ead.repository.RepositoryAlunoJpa;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicesJpaRepositoyAluno {

	@Autowired
	RepositoryAlunoJpa alunoJpa;

	public Aluno saveAluno(Aluno aluno) {
		return alunoJpa.save(aluno);

	}

}

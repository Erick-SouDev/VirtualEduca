package educa.ead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import educa.ead.modelos.Aluno;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface RepositoryAlunoJpa extends  JpaRepository<Aluno, Long> {


}

package br.com.rest.repository;

import br.com.rest.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public class Repository {
    public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    }
}

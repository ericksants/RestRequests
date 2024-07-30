package br.com.rest.repository;

import br.com.rest.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }


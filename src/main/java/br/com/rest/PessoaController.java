package br.com.rest;

import br.com.rest.entity.Pessoa;
import br.com.rest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/req/rest")
public class PessoaController {
    @Autowired
    private PessoaRepository _pessoaRepository;


    @GetMapping(value = "/check")
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/pessoa")
    public List<Pessoa> Get() {
        return _pessoaRepository.findAll();
    }


}

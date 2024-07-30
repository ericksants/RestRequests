package br.com.rest;

import br.com.rest.entity.Pessoa;
import br.com.rest.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/req/rest")
public class PessoaController {
    @Autowired
    private Repository.PessoaRepository _pessoaRepository;

    //private static final logger log = LoggerFactory.getLogger(PessoaController.class);

    @GetMapping(value = "/check")
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/pessoa")
    public List<Pessoa> Get() {
        return _pessoaRepository.findAll();
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/pessoa")
    public Pessoa Post(@Validated @RequestBody Pessoa pessoa)
    {
        return _pessoaRepository.save(pessoa);
    }

    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            _pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            _pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

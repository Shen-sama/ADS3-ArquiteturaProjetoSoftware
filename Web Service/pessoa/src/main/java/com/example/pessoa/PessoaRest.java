package com.example.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaRest {

    private final PessoaApplication pessoaApplication;

    private final HelloRest helloRest;

    @Autowired
    private PessoaDao pessoaDao;

    PessoaRest(HelloRest helloRest, PessoaApplication pessoaApplication) {
        this.helloRest = helloRest;
        this.pessoaApplication = pessoaApplication;
    }

    @GetMapping
    public List<Pessoa> get(){
        return pessoaDao.findAll();
    }

    @PostMapping
    public void post( @RequestBody Pessoa pessoa){
        pessoaDao.save(pessoa);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (pessoaDao.existsById(id)) {
            pessoaDao.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }  
}

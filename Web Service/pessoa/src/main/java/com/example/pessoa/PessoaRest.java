package com.example.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaRest {

    private final PessoaApplication pessoaApplication;

    private final HelloRest helloRest;

    private List<Pessoa> pessoas = new ArrayList<>();

    PessoaRest(HelloRest helloRest, PessoaApplication pessoaApplication) {
        this.helloRest = helloRest;
        this.pessoaApplication = pessoaApplication;
    }

    @GetMapping
    public List<Pessoa> get(){
        return pessoas;
    }

    @PostMapping
    public void post( @RequestBody Pessoa pessoa){
       this.pessoas.add(pessoa); 
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete (@PathVariable String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                pessoas.remove(p);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }    
}

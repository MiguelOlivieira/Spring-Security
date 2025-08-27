package br.springSecurity.controller;


import br.springSecurity.model.UsuarioModel;
import br.springSecurity.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController{

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository  repository){
        this.repository = repository;
    }


    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario) {// permite receber um json e converter para um objeto


        return ResponseEntity.ok(repository.save(usuario));

    }
}

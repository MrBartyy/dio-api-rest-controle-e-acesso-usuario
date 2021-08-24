package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.exception.EntityNotFoundException;
import com.digitalinnovationone.live.model.Usuario;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if(!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(usuarioOptional.get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id) throws EntityNotFoundException {
        return this.usuarioService.updateUsuario(usuario, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.usuarioService.deleteById(id);
    }
}

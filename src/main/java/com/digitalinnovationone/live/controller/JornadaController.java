package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.exception.EntityNotFoundException;
import com.digitalinnovationone.live.model.JornadaTrabalho;
import com.digitalinnovationone.live.model.RecordNotFoundException;
import com.digitalinnovationone.live.model.Usuario;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.service.JornadaService;
import com.digitalinnovationone.live.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornada")
public class JornadaController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> findAll(){
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> findById(@PathVariable Long id) {
        Optional<JornadaTrabalho> jornadaTrabalhoOptional = jornadaService.findById(id);
        if(!jornadaTrabalhoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(jornadaTrabalhoOptional.get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO updateUsuario(@RequestBody JornadaTrabalho jornadaTrabalho, @PathVariable("id") Long id) throws EntityNotFoundException {
        return this.jornadaService.updateJornada(jornadaTrabalho, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.jornadaService.deleteById(id);
    }
}

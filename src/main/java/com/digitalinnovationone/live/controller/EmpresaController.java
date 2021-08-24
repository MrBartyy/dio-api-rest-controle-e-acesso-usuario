package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.exception.EntityNotFoundException;
import com.digitalinnovationone.live.model.Empresa;
import com.digitalinnovationone.live.model.JornadaTrabalho;
import com.digitalinnovationone.live.model.Usuario;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.service.EmpresaService;
import com.digitalinnovationone.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.createEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> findAll(){
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        Optional<Empresa> empresaOptional = empresaService.findById(id);
        if(!empresaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(empresaOptional.get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO updateUsuario(@RequestBody Empresa empresa, @PathVariable("id") Long id) throws EntityNotFoundException {
        return this.empresaService.updateJornada(empresa, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.empresaService.deleteById(id);
    }
}

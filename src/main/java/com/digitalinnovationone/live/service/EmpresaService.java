package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.Empresa;
import com.digitalinnovationone.live.model.JornadaTrabalho;
import com.digitalinnovationone.live.repository.EmpresaRepository;
import com.digitalinnovationone.live.repository.JornadaRepository;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.util.MensagemResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> findById(Long id){
        return empresaRepository.findById(id);
    }

    public MensagemRespostaDTO updateJornada(Empresa empresa, Long id) throws EntityNotFoundException {
        verificarSeExiste(id);
        Empresa updateById = this.empresaRepository.save(empresa);
        return MensagemResposta.create("Update feito "+ updateById.getId());
    }

    public MensagemRespostaDTO deleteById(Long id)throws EntityNotFoundException {
        verificarSeExiste(id);
        this.empresaRepository.deleteById(id);
        return MensagemResposta.create("Deletando jornada de trabalho: " + id);
    }

    private Empresa verificarSeExiste(Long id) throws EntityNotFoundException {
        return this.empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jornada" + id));
    }
}

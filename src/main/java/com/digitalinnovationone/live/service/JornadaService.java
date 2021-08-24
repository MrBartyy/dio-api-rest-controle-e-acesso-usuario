package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.JornadaTrabalho;
import com.digitalinnovationone.live.model.Usuario;
import com.digitalinnovationone.live.repository.JornadaRepository;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.util.MensagemResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {
    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll(){
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> findById(Long id){
        return jornadaRepository.findById(id);
    }

    public MensagemRespostaDTO updateJornada(JornadaTrabalho jornadaTrabalho, Long id) throws EntityNotFoundException{
        verificarSeExiste(id);
        JornadaTrabalho updateById = this.jornadaRepository.save(jornadaTrabalho);
        return MensagemResposta.create("Update feito "+ updateById.getId());
    }

    public MensagemRespostaDTO deleteById(Long id)throws EntityNotFoundException {
        verificarSeExiste(id);
        this.jornadaRepository.deleteById(id);
        return MensagemResposta.create("Deletando jornada de trabalho: " + id);
    }

    private JornadaTrabalho verificarSeExiste(Long id) throws EntityNotFoundException {
        return this.jornadaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jornada" + id));
    }

}

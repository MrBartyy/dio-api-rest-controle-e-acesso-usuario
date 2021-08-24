package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.Usuario;
import com.digitalinnovationone.live.repository.UsuarioRepository;
import com.digitalinnovationone.live.response.MensagemRespostaDTO;
import com.digitalinnovationone.live.util.MensagemResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    public MensagemRespostaDTO updateUsuario(Usuario usuario, Long id) throws EntityNotFoundException{
        verificarSeExiste(id);
        Usuario updateById = this.usuarioRepository.save(usuario);
         return MensagemResposta.create("Update feito "+ updateById.getId());
    }

    public MensagemRespostaDTO deleteById(Long id)throws EntityNotFoundException{
        verificarSeExiste(id);
        this.usuarioRepository.deleteById(id);
        return MensagemResposta.create("Deletando Usuario de id: " + id);
    }

    private Usuario verificarSeExiste(Long id) throws EntityNotFoundException {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario" + id));
    }
}

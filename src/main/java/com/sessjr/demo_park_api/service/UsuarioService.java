package com.sessjr.demo_park_api.service;

import com.sessjr.demo_park_api.entity.Usuario;
import com.sessjr.demo_park_api.exception.EntityNotFoundException;
import com.sessjr.demo_park_api.exception.PasswordInvalidException;
import com.sessjr.demo_park_api.exception.UsernameUniqueViolationException;
import com.sessjr.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("O username '%s' ja esta sendo utilizado", usuario.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario obterPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id='%s' não localizado", id))
        );
    }

    @Transactional
    public Usuario updatePassword(Long id, String senhaAtual, String novaSenha, String confirmacaoSenha) {
        if(!novaSenha.equals(confirmacaoSenha)) {
            throw new PasswordInvalidException("As senhas não correspondem entre si");
        }

        Usuario user = obterPorId(id);

        if(!senhaAtual.equals(user.getPassword())) {
            throw new PasswordInvalidException("A senha atual não corresponde a senha cadastrada");
        }

        user.setPassword(novaSenha);

        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
}

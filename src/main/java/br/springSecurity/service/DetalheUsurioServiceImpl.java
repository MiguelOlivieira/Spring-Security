package br.springSecurity.service;

import br.springSecurity.data.DetalheUsuarioData;
import br.springSecurity.model.UsuarioModel;
import br.springSecurity.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsurioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsurioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsuarioModel> usuario = repository.findByLogin(username);

        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario [" + username + "] não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }


}

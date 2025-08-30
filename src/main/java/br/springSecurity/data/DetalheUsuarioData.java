package br.springSecurity.data;

import br.springSecurity.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<UsuarioModel> usuario;

    public DetalheUsuarioData(Optional<UsuarioModel> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){ //Permissões do usuario
        return new ArrayList<>();
    }


    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioModel()).getPassword();  //Caso o usuario esteja vazio, cria-se um usuario de qualquer forma
    }

    @Override
    public String getUsername(){
        return usuario.orElse(new UsuarioModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

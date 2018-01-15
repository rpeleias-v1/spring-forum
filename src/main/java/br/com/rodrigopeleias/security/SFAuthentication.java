package br.com.rodrigopeleias.security;

import br.com.rodrigopeleias.model.PermissaoUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class SFAuthentication implements Authentication {

    private final Usuario usuario;
    private List<PermissaoUsuario> permissoes;
    private boolean autenticado;

    public SFAuthentication(Usuario usuario, List<PermissaoUsuario> permissoes) {
        this.usuario = usuario;
        this.permissoes = permissoes;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissoes;
    }

    public Object getCredentials() {
        return usuario != null ? usuario.getHashSenha() : null;
    }

    public Object getDetails() {
        return usuario;
    }

    public Object getPrincipal() {
        return usuario != null ? usuario.getLogin() : null;
    }

    public boolean isAuthenticated() {
        return this.autenticado;
    }

    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.autenticado = authenticated;
    }

    public String getName() {
        return usuario != null ? usuario.getLogin() : null;
    }
}

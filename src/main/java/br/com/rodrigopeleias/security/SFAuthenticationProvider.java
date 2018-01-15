package br.com.rodrigopeleias.security;

import br.com.rodrigopeleias.dao.DAOPermissaoUsuario;
import br.com.rodrigopeleias.dao.DAOUsuario;
import br.com.rodrigopeleias.model.PermissaoUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public class SFAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private DAOUsuario daoUsuario;

    @Autowired
    private DAOPermissaoUsuario daoPermissaoUsuario;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String login = token.getName();
        String senha = token.getCredentials() != null ? token.getCredentials().toString() : null;
        Usuario usuario = daoUsuario.getUsuario(login, senha);
        if (usuario == null) {
            return null;
        }
        List<PermissaoUsuario> permissoes = daoPermissaoUsuario.getPermissoesUsuario(usuario);
        SFAuthentication resultado = new SFAuthentication(usuario, permissoes);
        resultado.setAuthenticated(usuario != null);
        return resultado;
    }

    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

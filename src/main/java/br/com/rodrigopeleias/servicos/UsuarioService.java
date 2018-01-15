package br.com.rodrigopeleias.servicos;

import br.com.rodrigopeleias.model.Usuario;
import org.springframework.security.access.annotation.Secured;

public class UsuarioService {

    @Secured(" hasRole('ROLE_ADMIN')")
    public void banir(Usuario usuario) {
    }

    @Secured({"ROLE_ADMIN", "ROLE_MODERADOR"})
    public void advertir(Usuario usuario, String mensagem) {
    }
}

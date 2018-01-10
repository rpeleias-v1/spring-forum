package br.com.rodrigopeleias.dao;

import br.com.rodrigopeleias.model.PermissaoUsuario;
import br.com.rodrigopeleias.model.Usuario;

import java.util.List;

public interface DAOPermissaoUsuario {

    List<PermissaoUsuario> getPermissoesUsuario(Usuario usuario);

    void addRole(String role, Usuario usuario);
}

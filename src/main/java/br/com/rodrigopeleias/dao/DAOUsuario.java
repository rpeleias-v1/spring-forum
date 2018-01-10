package br.com.rodrigopeleias.dao;

import br.com.rodrigopeleias.model.Usuario;


public interface DAOUsuario extends DAOBase<Usuario>{

    Usuario getUsuario(String login, String senha);

    Usuario getUsuario(String login);
}

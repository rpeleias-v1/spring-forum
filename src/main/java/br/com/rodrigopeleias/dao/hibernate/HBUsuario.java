package br.com.rodrigopeleias.dao.hibernate;

import br.com.rodrigopeleias.dao.DAOUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoUsuario")
public class HBUsuario extends HBDAO<Usuario> implements DAOUsuario {

    public Usuario getUsuario(String login, String senha) {
        Query query = getSession().createQuery("from Usuario usr where usr.login = ? and usr.hashSenha = ?");
        query.setString(0, login);
        query.setString(1, senha);
        return (Usuario)query.uniqueResult();
    }

    public Usuario getUsuario(String login) {
        Query query = getSession().createQuery("from Usuario usr where usr.login = ?");
        query.setString(0, login);
        return (Usuario)query.uniqueResult();
    }

    protected Class getClazz() {
        return Usuario.class;
    }
}

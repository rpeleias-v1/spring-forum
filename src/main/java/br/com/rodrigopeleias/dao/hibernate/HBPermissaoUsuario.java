package br.com.rodrigopeleias.dao.hibernate;

import br.com.rodrigopeleias.dao.DAOPermissaoUsuario;
import br.com.rodrigopeleias.model.PermissaoUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("daoPermissaoUsuario")
public class HBPermissaoUsuario implements DAOPermissaoUsuario {

    @Autowired
    private SessionFactory sessionFactory;

    public List<PermissaoUsuario> getPermissoesUsuario(Usuario usuario) {
        if (usuario == null) {
            return new ArrayList<PermissaoUsuario>();
        }
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from PermissaoUsuario pu where pu.usuario = ?");
        query.setEntity(0, usuario);
        return query.list();
    }

    public void addRole(String role, Usuario usuario) {
        if (role != null && usuario != null) {
            PermissaoUsuario permissao = new PermissaoUsuario();
            permissao.setRole(role);
            permissao.setUsuario(usuario);
            sessionFactory.getCurrentSession().saveOrUpdate(permissao);
        }
    }
}

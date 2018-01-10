package br.com.rodrigopeleias.dao.hibernate;

import br.com.rodrigopeleias.dao.DAOTopico;
import br.com.rodrigopeleias.model.Assunto;
import br.com.rodrigopeleias.model.Topico;
import br.com.rodrigopeleias.model.Usuario;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HBTopico extends HBDAO<Topico> implements DAOTopico {

    public List<Topico> getTopicosPorAutor(Usuario usuario) {
        return null;
    }

    public List<Topico> getTopicosPorAssunto(Assunto assunto, int offset, int max) {
        Query busca = getSession().createQuery("from Topico topico where topico.assunto = ?");
        busca.setEntity(0, assunto);
        busca.setMaxResults(max);
        busca.setFirstResult(offset);
        return busca.list();
    }

    protected Class getClazz() {
        return Topico.class;
    }
}

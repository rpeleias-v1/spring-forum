package br.com.rodrigopeleias.dao.hibernate;

import br.com.rodrigopeleias.dao.DAOAssunto;
import br.com.rodrigopeleias.model.Assunto;
import org.springframework.stereotype.Repository;

@Repository
public class HBAssunto extends HBDAO<Assunto> implements DAOAssunto {

    protected Class getClazz() {
        return Assunto.class;
    }
}


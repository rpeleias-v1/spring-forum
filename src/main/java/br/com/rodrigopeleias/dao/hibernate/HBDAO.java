package br.com.rodrigopeleias.dao.hibernate;


import br.com.rodrigopeleias.dao.DAOBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS)
public abstract class HBDAO<T> implements DAOBase<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected abstract Class getClazz();

    public List<T> list(int offset, int max) {
        return (List<T>) getSession()
                .createCriteria(getClazz())
                .setMaxResults(max)
                .setFirstResult(offset).list();
    }

    public void persistir(T objeto) {
        getSession().saveOrUpdate(objeto);
    }

    public void excluir(T objeto) {
        getSession().delete(objeto);
    }

    public T get(Long id) {
        return (T) getSession().get(getClazz(), id);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
}

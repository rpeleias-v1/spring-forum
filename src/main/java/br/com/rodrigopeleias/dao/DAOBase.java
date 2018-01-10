package br.com.rodrigopeleias.dao;

import java.util.List;

public interface DAOBase<T> {

    List<T> list(int offset, int max);

    void persistir(T objeto);

    void excluir(T objeto);

    T get(Long id);
}

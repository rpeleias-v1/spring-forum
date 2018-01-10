package br.com.rodrigopeleias.dao;

import br.com.rodrigopeleias.model.Assunto;
import br.com.rodrigopeleias.model.Topico;
import br.com.rodrigopeleias.model.Usuario;

import java.util.List;

public interface DAOTopico extends DAOBase<Topico>{

    List<Topico> getTopicosPorAutor(Usuario usuario);

    List<Topico> getTopicosPorAssunto(Assunto assunto, int offset, int max);

}

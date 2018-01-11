package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.dao.DAOAssunto;
import br.com.rodrigopeleias.dao.DAOTopico;
import br.com.rodrigopeleias.model.Assunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssuntoController {

    @Autowired
    private DAOAssunto daoAssunto;

    @Autowired
    private DAOTopico daoTopico;

    @RequestMapping("/assunto/{id}")
    public ModelAndView show(Long id) {
        ModelAndView resultado = new ModelAndView();

        resultado.addObject("assunto", daoAssunto.get(id));
        resultado.addObject("topicos",
                daoTopico.getTopicosPorAssunto((Assunto) resultado.getModel().get("assunto"), 0, 20));
        resultado.setViewName("assunto/show");

        return resultado;
    }
}

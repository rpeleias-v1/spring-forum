package br.com.rodrigopeleias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class OlaMundoController {

    @RequestMapping("/ola")
    public ModelAndView olaMundo() {
        ModelAndView resultado = new ModelAndView("mundo");
        resultado.addObject("data", new Date());
        return resultado;
    }
}

package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.dao.DAOUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class Autenticacao {

    @Autowired
    private DAOUsuario daoUsuario;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String login, String senha, HttpSession sessao) {
        Usuario usuario = daoUsuario.getUsuario(login, senha);
        if (usuario == null) {
            return "loginFalho";
        } else {
            usuario.setUltimoLogin(new Date());
            daoUsuario.persistir(usuario);
            sessao.setAttribute(" usuario", usuario);

            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

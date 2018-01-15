package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.dao.DAOTopico;
import br.com.rodrigopeleias.dao.DAOUsuario;
import br.com.rodrigopeleias.model.Topico;
import br.com.rodrigopeleias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private DAOUsuario daoUsuario;

    @Autowired
    private DAOTopico daoTopico;

    @RequestMapping("/usuario/show/{id}")
    public ModelAndView usuario(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        System.out.println("Vou export o usuário");
        Usuario usuario = daoUsuario.get(id);
        System.out.println("Usuário encontrado: " + usuario);
        mav.getModel().put("usuario", usuario);
        mav.setViewName("usuario/show");
        return mav;
    }

    @RequestMapping("/usuario/autenticado")
    public ModelAndView infoAutenticado(Usuario usuario) {
        ModelAndView mav = new ModelAndView("usuario/show");
        mav.getModel().put("usuario", usuario);
        return mav;
    }

    @RequestMapping("/usuario/avatar/{login}")
    @ResponseBody
    public byte[] avatar(@PathVariable("login") String login) throws IOException {
        File arquivo = new File("/springForum/avatares/" + login + ".png");

        if (!arquivo.exists()) {
            arquivo = new File("/springForum/avatares/avatar.png");
        }
        byte[] resultado = new byte[(int) arquivo.length()];
        FileInputStream input = new FileInputStream(arquivo);
        input.read(resultado);
        input.close();

        return resultado;
    }

    @RequestMapping("/usuario/posts/{login}")
    public String topicosUsuario(@PathVariable("login") String login, Map<String, Object> model) {
        model.put("topicos", daoTopico.getTopicosPorAutor(daoUsuario.getUsuario(login)));
        return "usuario/posts";
    }

    @RequestMapping("/usuario/postsJSON/{login}")
    @ResponseBody
    public List<Topico> topicosUsuarioJson(@PathVariable("login") String login) {
        return daoTopico.getTopicosPorAutor(daoUsuario.getUsuario(login));
    }
}

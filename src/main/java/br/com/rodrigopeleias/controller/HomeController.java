package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.dao.DAOAssunto;
import br.com.rodrigopeleias.dao.DAOPermissaoUsuario;
import br.com.rodrigopeleias.dao.DAOUsuario;
import br.com.rodrigopeleias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DAOUsuario daoUsuario;


    @Autowired
    private DAOAssunto daoAssunto;

    @Autowired
    private DAOPermissaoUsuario daoPermissaoUsuario;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("assuntos", daoAssunto.list(0, 100));
        model.put("usuarios", daoUsuario.list(0, 100));
        return "index";
    }

    @RequestMapping("/registro")
    public String registro(Map<String, Object> model) {
        if (model.get("usuario") == null) {
            Usuario usr = new Usuario();
            model.put("usuario", usr);
        }
        return "registro";
    }

    @RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
    public String executarRegistro(@Valid Usuario usuario,
                                   BindingResult bindingResult,
                                   HttpSession sessao,
                                   MultipartFile avatar) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("usuario", usuario);
            return registro(model);
        }
        daoUsuario.persistir(usuario);
        daoPermissaoUsuario.addRole("ROLE_MEMBRO", usuario);

        if (!avatar.isEmpty()) {
            processarAvatar(usuario, avatar);
        }

        sessao.setAttribute("usuario", usuario);
        return "redirect:/";
    }

    private void processarAvatar(Usuario usuario, MultipartFile avatar) {
        File diretorio = new File("/springForum/avatares");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
        try {
            FileOutputStream arquivo = new FileOutputStream(diretorio.getAbsoluteFile() + "/" + usuario.getLogin() + ".png");
            arquivo.write(avatar.getBytes());
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

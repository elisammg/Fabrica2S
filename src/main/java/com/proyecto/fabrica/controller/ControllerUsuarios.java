package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.consumeAPI.NetCliente;
import com.proyecto.fabrica.interfaceService.IUsuarioService;
import com.proyecto.fabrica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControllerUsuarios {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/listausuarios")
    public String listar(Model model)
    {
        List<Usuario>usuarios=service.listar();
        model.addAttribute("lusuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/nuevousuario")
    public String agregar(Model modelo){
        NetCliente cli = new NetCliente();
        String res = cli.MetodoGet("http://localhost:8080/pedidosapi");
        System.out.println(res);
        modelo.addAttribute("usuarios", new Usuario());
        return "usuariosnuevo";
    }
    
    @GetMapping("/loginusuario")
    public String login(Model modelo){
        modelo.addAttribute("usuarios", new Usuario());
        modelo.addAttribute("msj", "");
        return "usuarioslogin";
    }
    
    @GetMapping("/")
    public String Home(Model modelo){
        modelo.addAttribute("usuarios", new Usuario());
        modelo.addAttribute("msj", "");
        return "usuarioslogin";
    }

    @PostMapping("/guardarusuario")
    public String save(@Valid Usuario c, Model model){
        service.save(c);
        return "redirect:/listausuarios";
    }
        
    @PostMapping("/validarusuario")
    public String validar(@Valid Usuario c, Model model){
        Optional<Usuario>usuario=service.listarId(c.getId());
        if (usuario.isEmpty()) {
            model.addAttribute("usuarios", c);
            model.addAttribute("msj", "Usuario o contraseña inválidos");
            return "usuarioslogin";
        } else {
            if (usuario.get().getPassword().equals(c.getPassword())){
                return "redirect:/productos";
            } else {
                model.addAttribute("usuarios", c);
                model.addAttribute("msj", "Usuario o contraseña inválidos");
                return "usuarioslogin";
            }
        }
    }

    @GetMapping("/editarusuario/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Usuario>usuario=service.listarId(id);
        modelo.addAttribute("usuarios", usuario);
        return "usuariosnuevo";
    }

    @GetMapping("/eliminarusuario/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/listausuarios";
    }
}

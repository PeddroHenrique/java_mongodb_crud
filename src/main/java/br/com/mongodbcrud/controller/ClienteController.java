/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mongodbcrud.controller;

import br.com.mongodbcrud.model.Cliente;
import br.com.mongodbcrud.service.ClienteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Pedro
 */
@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/listar-clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }
    
    @GetMapping("/adicionar-cliente")
    public String adicionarCliente(Cliente cliente) {
        return "adicionar";
    }
    
    @PostMapping("/salvar-cliente")
    public String salvarCliente(@ModelAttribute("cliente")Cliente cliente, @RequestParam("avatarFile")MultipartFile avatarFile) {
        
        if (avatarFile != null && !avatarFile.isEmpty()) {
            try {
                cliente.setAvatar(avatarFile.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        clienteService.save(cliente);
        return "redirect:/listar-clientes";
    }
    
    @GetMapping("/alterar-cliente/{id}")
    public String alterarCliente(@PathVariable("id")String id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "alterar";
    }
    
    @PostMapping("/deletar-cliente/{id}")
    public String deletarCliente(@PathVariable("id")String id) {
        clienteService.deleteById(id);
        return "redirect:/listar-clientes";
    }
}

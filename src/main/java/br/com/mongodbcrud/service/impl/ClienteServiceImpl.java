/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mongodbcrud.service.impl;

import br.com.mongodbcrud.model.Cliente;
import br.com.mongodbcrud.repository.ClienteRepository;
import br.com.mongodbcrud.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente findClienteByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public long count() {
        return clienteRepository.count();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(String id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }
}

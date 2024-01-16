/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.mongodbcrud.service;

import br.com.mongodbcrud.model.Cliente;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ClienteService {
    
    void deleteById(String id);
    Cliente findById(String id);
    Cliente save(Cliente cliente);
    Cliente findClienteByNome(String nome);
    List<Cliente> findAll();
    long count();
}

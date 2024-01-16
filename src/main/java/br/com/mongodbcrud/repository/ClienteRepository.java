/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.mongodbcrud.repository;

import br.com.mongodbcrud.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro
 */
@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
    @Query("{nome:'?0'}")
    Cliente findByNome(String nome);
}

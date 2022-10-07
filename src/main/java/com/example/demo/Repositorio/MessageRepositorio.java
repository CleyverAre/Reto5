/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.MessageInterface;
import com.example.demo.Modelo.Machine;
import com.example.demo.Modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CleyverAlonsoArevalo
 */
@Repository

public class MessageRepositorio {
     @Autowired
     private MessageInterface messageCrudRepository;
     
     public List<Message> getAll(){
         return (List<Message>)messageCrudRepository.findAll();
}
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save (Message message){
        return messageCrudRepository.save(message);
    }
           public void delete (Message message){
        messageCrudRepository.delete(message);
    } 
}
    

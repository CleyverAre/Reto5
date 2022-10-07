/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CleyverAlonsoArevalo
 */
@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;
    
     
     public List<Category> getAll() {
        return categoryRepositorio.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepositorio.getCategory(categoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepositorio.save(category);
        } else {
            Optional<Category> category1 = categoryRepositorio.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepositorio.save(category);
            } else {
                return category;
            }
        }
    }
    
       public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepositorio.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepositorio.save(g.get());
            }
        }
        return category;
    }


        
    public boolean deleteCategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            categoryRepositorio.delete(category);
            return true;
        }).orElse(false);
        return d;
    
    }
    
    }
    


    
    


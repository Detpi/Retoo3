
package com.advs.WebApp;

import Model.Mensajes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Vargas
 */
@Service
public class ServicesMsg {
    @Autowired
    private RepositoryMsg metodosCrud;
    
    public List<Mensajes> getAll(){
        return metodosCrud.getAll();
    }
    public Optional <Mensajes> getMensajes(int id){
        return metodosCrud.getMensajes(id);
    }
    public Mensajes save(Mensajes mensajes){
        if(mensajes.getIdMessage()==null){
            return metodosCrud.save(mensajes);
        }else{
            Optional <Mensajes> evt=metodosCrud.getMensajes(mensajes.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(mensajes);
            }else{
                return mensajes;
            }
        }
        
    }    
    
}

package com.advs.WebApp;

import Model.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Vargas
 */
@Service
public class ServicesClientes {
    
    @Autowired
    private RepositoryClientes metodosCrud;
    
    public List<Clientes> getAll(){
        return metodosCrud.getAll();
    }
    public Optional <Clientes> getClientes(int id){
        return metodosCrud.getClientes(id);
    }
    public Clientes save(Clientes clientes){
        if(clientes.getIdClient()==null){
            return metodosCrud.save(clientes);
        }else{
            Optional <Clientes> evt=metodosCrud.getClientes(clientes.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(clientes);
            }else{
                return clientes;
            }
        }
        
    }
    
}

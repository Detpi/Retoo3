
package com.advs.WebApp;

import Model.Categorias;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Vargas
 */
@Service
public class ServicesCtgr {
    @Autowired
    private RepositoryCtgr metodosCrud;
    
    public List<Categorias> getAll(){
        return metodosCrud.getAll();
    }
    public Optional <Categorias> getCategorias(int id){
        return metodosCrud.getCategorias(id);
    }
    public Categorias save(Categorias categorias){
        if(categorias.getId()==null){
            return metodosCrud.save(categorias);
        }else{
            Optional <Categorias> evt=metodosCrud.getCategorias(categorias.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(categorias);
            }else{
                return categorias;
            }
        }
        
    }    
    
}

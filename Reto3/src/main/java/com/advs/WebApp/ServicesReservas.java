
package com.advs.WebApp;

import Model.Reservas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Vargas
 */
@Service
public class ServicesReservas {
    @Autowired
    private RepositoryReservas metodosCrud;
    
    public List<Reservas> getAll(){
        return metodosCrud.getAll();
    }
    public Optional <Reservas> getReservas(int id){
        return metodosCrud.getReservas(id);
    }
    public Reservas save(Reservas reservas){
        if(reservas.getIdReservation()==null){
            return metodosCrud.save(reservas);
        }else{
            Optional <Reservas> evt=metodosCrud.getReservas(reservas.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(reservas);
            }else{
                return reservas;
            }
        }
        
    }    
    
}

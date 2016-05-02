package modelos;

import javax.persistence.Entity;

@Entity
public class UsuarioVip  extends Usuario{
    
    public int getPrazo() {
        return  10;
    }



}

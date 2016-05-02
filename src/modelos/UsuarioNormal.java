package modelos;

import javax.persistence.Entity;

@Entity
public class UsuarioNormal extends Usuario {
    
    public int getPrazo() {
        return 5;
    }
    
}

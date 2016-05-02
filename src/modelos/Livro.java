package modelos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livro {
	@Id
    String codigo;
	
    String nome;
    String autor;
    String descricao;
    
    @OneToMany(mappedBy="codLivro")
    private Map<String,Reserva> reservas;
    
    
public void addReserva(Reserva reserva) {
    	
    	reservas.put(reserva.getCodLivro().codigo,reserva);
    }
    
    public Reserva getReserva(Reserva reserva) {
    	
    	return reservas.get(reserva.getCodLivro());
    }

    
    public Map<String, Reserva> getReservas() {
		return reservas;
	}

	
	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}   
    
	public Livro() {
		reservas = new HashMap<>();
	}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}

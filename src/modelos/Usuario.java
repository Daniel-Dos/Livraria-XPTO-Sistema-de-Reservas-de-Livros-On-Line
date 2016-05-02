package modelos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Usuario {

	@Id
	private String login;

	private String senha;
	private String nome;
	private String telefone;
	private String email;

	@OneToMany(mappedBy = "usuario")
	private Map<String, Reserva> reservas;

	public void addReserva(Reserva reserva) {

		reservas.put(reserva.getUsuario().login, reserva);
	}

	public Reserva getReserva(Reserva reserva) {

		return reservas.get(reserva.getUsuario());
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	/**
	 * @param reservas
	 *            the reservas to set
	 */
	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

	public Usuario() {
		reservas = new HashMap<>();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract int getPrazo();

}

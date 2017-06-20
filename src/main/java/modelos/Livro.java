/*
 * Copyright © 2017 Daniel Dias (daniel.dias.analistati@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package modelos;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Entity
public class Livro {
	@Id
	String codigo;

	String nome;
	String autor;
	String descricao;

	@OneToMany(mappedBy = "codLivro")
	private Map<String, Reserva> reservas;

	public void addReserva(Reserva reserva) {

		reservas.put(reserva.getCodLivro().codigo, reserva);
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
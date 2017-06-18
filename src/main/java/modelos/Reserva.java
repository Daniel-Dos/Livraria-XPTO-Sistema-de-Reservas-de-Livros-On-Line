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
/**
 * 
 */
package modelos;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Daniel.Dias
 *
 */

@Entity
@IdClass(ReservaId.class)
public class Reserva {
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="usuario",nullable=false, insertable=false, updatable=false)
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="codLivro",nullable=false, insertable=false, updatable=false)
	private Livro codLivro;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(Livro codLivro) {
		this.codLivro = codLivro;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	

}

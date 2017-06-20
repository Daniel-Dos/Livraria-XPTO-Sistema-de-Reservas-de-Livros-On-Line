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
package persistencia;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import modelos.Reserva;
import modelos.Usuario;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class UsuarioHibernate implements GenericDAO<Usuario> {

	private EntityManagerFactory emf;
	private EntityManager manager;

	public UsuarioHibernate() {
		this.emf = DAOFactoyHibernate.getEntityManagerFactory();
	}

	@Override
	public void incluir(Usuario entidade) throws SQLException {

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(entidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

	@Override
	public void excluir(Usuario entidade) throws SQLException {

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();

			String consulta = "DELETE FROM RESERVA a WHERE  a.usuario =:usuario";
			
			Query query = manager.createNativeQuery(consulta, Reserva.class);
			query.setParameter("usuario", entidade.getLogin());
			query.executeUpdate();

			entidade = manager.getReference(Usuario.class, entidade.getLogin());
			manager.remove(entidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

	@Override
	public void alterar(Usuario entidade) throws SQLException {
		Usuario id = null;

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			
			id = manager.getReference(Usuario.class, entidade.getLogin());

			entidade.setLogin(id.getLogin());
			entidade.setSenha(id.getSenha());

			manager.merge(entidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

	@Override
	public Usuario consultar(Usuario entidade) throws SQLException {

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
	
			Usuario id = manager.getReference(Usuario.class, entidade.getLogin());
			
			entidade.setLogin(id.getLogin());
			entidade.setNome(id.getNome());
			entidade.setEmail(id.getEmail());
			entidade.setTelefone(id.getTelefone());
			
			manager.getTransaction().commit();
			return entidade;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Usuario> getAllUsers() throws SQLException {return null;}

	@Override
	public Usuario lembrarSenha(Usuario entidade) throws SQLException {

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();

			String consulta = "SELECT * FROM Usuario a where a.email =:email";
			Query query = manager.createNativeQuery(consulta, Usuario.class);
			query.setParameter("email", entidade.getEmail());

			Usuario logado = (Usuario) query.getSingleResult();

			manager.getTransaction().commit();
			return logado;
		} finally {
			manager.close();
		}
	}

	@Override
	public Usuario consultarLoginSenha(Usuario entidade) throws SQLException {

		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();

			String consulta = "SELECT * FROM Usuario  where login =:login and senha =:senha";

			Query query = manager.createNativeQuery(consulta, Usuario.class);
			query.setParameter("login", entidade.getLogin());
			query.setParameter("senha", entidade.getSenha());

			Usuario logado = (Usuario) query.getSingleResult();
			manager.getTransaction().commit();
			return logado;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Usuario> getUser(Usuario entidade) throws SQLException {
		return null;
	}
}
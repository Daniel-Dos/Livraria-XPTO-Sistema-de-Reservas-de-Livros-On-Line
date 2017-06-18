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

import modelos.Livro;
import modelos.Reserva;

/**
 * @author Daniel Dias
 *
 */
public class LivroHibernate implements GenericDAO<Livro> {

	private EntityManagerFactory emf;
	private EntityManager manager;

	/**
	 * 
	 */
	public LivroHibernate() {
		// TODO Auto-generated constructor stub
		this.emf = DAOFactoyHibernate.getEntityManagerFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.GenericDAO#incluir(java.lang.Object)
	 */
	@Override
	public void incluir(Livro entidade) throws SQLException {
		// TODO Auto-generated method stub

		try {

			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(entidade);
			// manager.flush();
			// manager.clear();
			manager.getTransaction().commit();
		} finally {

			manager.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.GenericDAO#excluir(java.lang.Object)
	 */
	@Override
	public void excluir(Livro  entidade) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
                        
                        String consulta = "DELETE FROM RESERVA a WHERE  a.codLivro =:codLivro";
			Query query = manager.createNativeQuery(consulta,Reserva.class);
                        query.setParameter("codLivro", entidade.getCodigo());
			query.executeUpdate();
                        
			entidade = manager.find(Livro.class, entidade.getCodigo());
			
			manager.remove(entidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.GenericDAO#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Livro  entidade) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Livro id = manager.find(Livro.class, entidade.getCodigo());
		entidade.setCodigo(id.getCodigo());
		manager.merge(entidade);
		manager.getTransaction().commit();
		
	} finally {
		manager.close();
	}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.GenericDAO#consultar(java.lang.Object)
	 */
	@Override
	public Livro consultar(Livro entidade) throws SQLException {
	
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			Livro id = manager.find(Livro.class, entidade.getCodigo());
			entidade.setCodigo(id.getCodigo());
			manager.getTransaction().commit();
			return entidade;
		} finally {
			manager.close();
		}
		
		
	}

	 @Override
	    public List<Livro> getAllUsers() throws SQLException {
	        
		
		 try {
			 manager = emf.createEntityManager();
			 manager.getTransaction().begin();
			 //Listando Tudo
			List<Livro> listaLivros = manager.createQuery("from Livro order by codigo", Livro.class).getResultList();
			
			 manager.getTransaction().commit();
		    return listaLivros;
			 
		 } 
		 finally {
			 manager.close();
		 }
		 
	 }

	    @Override
	    public Livro lembrarSenha(Livro entidade) throws SQLException {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public Livro consultarLoginSenha(Livro entidade) throws SQLException {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public List<Livro> getUser(Livro entidade) throws SQLException {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	    
}

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

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Daniel Dias
 *
 */
public class DAOFactoyHibernate  extends DAOFactory {
	
	
	private static EntityManagerFactory emf;
	
	
	//HibernateDAOFactory() {}

		public static EntityManagerFactory getEntityManagerFactory() {
			if(emf == null) {
				emf = Persistence.createEntityManagerFactory("DAO");
			}
			return emf;
		}
		
		public static void closeEntityManagerFactory() {
			if(emf != null && emf.isOpen()) emf.close();
		
		}
	

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOUsuario()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOLivro()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOReserva()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOUsuarioHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new UsuarioHibernate();
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOLivroHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new LivroHibernate();
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOReservaHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new ReservaHibernate();
	}

}

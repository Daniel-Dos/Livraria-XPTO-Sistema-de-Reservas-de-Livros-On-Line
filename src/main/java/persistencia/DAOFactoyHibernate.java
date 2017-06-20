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
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class DAOFactoyHibernate extends DAOFactory {

	private static EntityManagerFactory emf;

	DAOFactoyHibernate() {}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("DAO");
		}
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null && emf.isOpen())
			emf.close();
	}

	@Override
	public GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception {
		return null;
	}

	@Override
	public GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception {
		return null;
	}

	@Override
	public GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception {
		return null;
	}

	@Override
	public GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception {
		return new UsuarioHibernate();
	}

	@Override
	public GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception {
		return new LivroHibernate();
	}

	@Override
	public GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception {
		return new ReservaHibernate();
	}
}
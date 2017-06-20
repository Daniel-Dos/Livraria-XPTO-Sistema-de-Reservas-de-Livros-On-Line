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

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public abstract class DAOFactory {

	public final static int DERBY = 1;
	public final static int ORACLE = 2;
	public static final int HIBERNATE = 3;

	public static DAOFactory getDaoFactory(int x) throws ClassNotFoundException, SQLException {

		if (x == DERBY)
			return new DAOFactoryDerby();
		else if (x == ORACLE)
			return new DAOFactoryOracle();
		if (x == HIBERNATE)
			return new DAOFactoyHibernate();
		else
			return null;
	}

	public abstract GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception;
	public abstract GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception;
	public abstract GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception;
	public abstract GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception;
	public abstract GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception;
	public abstract GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception;
}
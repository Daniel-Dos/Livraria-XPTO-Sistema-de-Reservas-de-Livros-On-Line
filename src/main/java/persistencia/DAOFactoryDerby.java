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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class DAOFactoryDerby extends DAOFactory {

	public DAOFactoryDerby() throws ClassNotFoundException, SQLException {
		createConnection();
	}

	public static Connection createConnection() {

		Connection conexao = null;

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BDLivro", "seuUsuario", "suaSenha");
		} catch (SQLException e) {
			System.out.println("Erro de SQL :" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada :" + e.getMessage());
		}
		return conexao;
	}

	@Override
	public GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception {
		return new DAOGenericoUsuario();
	}

	@Override
	public GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception {
		return new DAOGenericoLivro();
	}

	@Override
	public GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception {
		return new DAOGenerioReserva();
	}

	@Override
	public GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception {
		return null;
	}

	@Override
	public GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception {
		return null;
	}

	@Override
	public GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception {
		return null;
	}
}
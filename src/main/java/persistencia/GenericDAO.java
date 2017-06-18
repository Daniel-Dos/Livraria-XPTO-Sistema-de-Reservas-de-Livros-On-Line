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
import modelos.Reserva;

/**
 * @author Daniel Dias
 *
 */
public interface GenericDAO<T> {

	void incluir(T entidade) throws SQLException;
	void excluir(T entidade) throws SQLException;
	void alterar(T entidade) throws SQLException;
	T consultar(T entidade) throws SQLException;
	List<T> getAllUsers() throws SQLException;
        T lembrarSenha(T entidade) throws SQLException; // para retornar a senha e o nome do usuario
        T consultarLoginSenha(T entidade) throws SQLException;
        List<T> getUser(T entidade) throws SQLException;
       

   
}

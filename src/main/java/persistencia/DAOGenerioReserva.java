package persistencia;
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

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelos.Livro;
import modelos.Reserva;
import modelos.Usuario;
import modelos.UsuarioVip;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class DAOGenerioReserva implements GenericDAO<Reserva> {

	private PreparedStatement stm = null;
	private Connection conexao = null;
	private ResultSet resultado = null;

	public DAOGenerioReserva() {
		conexao = DAOFactoryOracle.createConnection();
	}

	@Override
	public void incluir(Reserva entidade) throws SQLException {

		stm = conexao.prepareStatement("INSERT INTO RESERVA VALUES(?,?,?)");
		stm.setString(1, entidade.getUsuario().getLogin());
		stm.setString(2, entidade.getCodLivro().getCodigo());
		stm.setDate(3, new Date(entidade.getDataCadastro().getTimeInMillis()));
		stm.executeUpdate();
		stm.close();
	}

	@Override
	public void excluir(Reserva entidade) throws SQLException {

		stm = conexao.prepareStatement("DELETE FROM RESERVA WHERE DATARESERVA = ? AND USUARIO = ? AND CODLIVRO = ?");
		stm.setDate(1, new Date(entidade.getDataCadastro().getTimeInMillis()));
		stm.setString(2, entidade.getUsuario().getLogin());
		stm.setString(3, entidade.getCodLivro().getCodigo());
		stm.executeUpdate();
		stm.close();
	}

	@Override
	public void alterar(Reserva entidade) throws SQLException {

		stm = conexao.prepareStatement("UPDATE RESERVA SET DATARESERVA = ? WHERE USUARIO = ? AND CODLIVRO = ? ");
		stm.setDate(1, new Date(entidade.getDataCadastro().getTimeInMillis()));
		stm.setString(2, entidade.getUsuario().getLogin());
		stm.setString(3, entidade.getCodLivro().getCodigo());
		stm.executeUpdate();
		stm.close();
	}

	@Override
	public Reserva consultar(Reserva entidade) throws SQLException {

		Reserva aux = null;
		Usuario usuario = null;
		Livro livro = null;

		stm = conexao.prepareStatement("SELECT * FROM RESERVA WHERE USUARIO = ?");
		stm.setString(1, entidade.getUsuario().getLogin());

		resultado = stm.executeQuery();

		while (resultado.next()) {
			usuario = new UsuarioVip();
			livro = new Livro();
			aux = new Reserva();

			usuario.setLogin(resultado.getString(1));
			aux.setUsuario(usuario);

			livro.setCodigo(resultado.getString(2));
			aux.setCodLivro(livro);

			Calendar data = Calendar.getInstance();
			data.setTime(resultado.getDate(3));
			aux.setDataCadastro(data);
		}
		stm.close();
		return aux;
	}

	@Override
	public List<Reserva> getAllUsers() throws SQLException {

		List<Reserva> users = new ArrayList<Reserva>();

		stm = conexao.prepareStatement("SELECT * FROM RESERVA ORDER BY CODLIVRO");
		resultado = stm.executeQuery();

		while (resultado.next()) {
			Reserva reserva = new Reserva();
			Livro livro = new Livro();
			Usuario usuario = new UsuarioVip();

			usuario.setLogin(resultado.getString(1));
			reserva.setUsuario(usuario);

			livro.setCodigo(resultado.getString(2));
			reserva.setCodLivro(livro);

			Calendar data = Calendar.getInstance();
			data.setTime(resultado.getDate(3));
			reserva.setDataCadastro(data);

			users.add(reserva);
		}
		return users;
	}

	@Override
	public Reserva lembrarSenha(Reserva entidade) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Reserva consultarLoginSenha(Reserva entidade) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public List<Reserva> getUser(Reserva entidade) throws SQLException {

		List<Reserva> user = null;
		Reserva aux = null;
		Usuario usuario = null;
		Livro livro = null;

		stm = conexao.prepareStatement("SELECT * FROM RESERVA WHERE USUARIO = ?");
		stm.setString(1, entidade.getUsuario().getLogin());

		resultado = stm.executeQuery();
		user = new ArrayList<Reserva>();

		while (resultado.next()) {
			aux = new Reserva();
			livro = new Livro();
			usuario = new UsuarioVip();

			usuario.setLogin(resultado.getString(1));
			aux.setUsuario(usuario);

			livro.setCodigo(resultado.getString(2));
			aux.setCodLivro(livro);

			Calendar data = Calendar.getInstance();
			data.setTime(resultado.getDate(3));
			aux.setDataCadastro(data);

			user.add(aux);
		}
		return user;
	}
}
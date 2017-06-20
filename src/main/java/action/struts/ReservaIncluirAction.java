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
package action.struts;

import action.form.bean.LivroForm;
import action.form.bean.ReservaForm;
import action.form.bean.UsuarioForm;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Livro;
import modelos.Reserva;
import modelos.Usuario;
import modelos.UsuarioVip;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class ReservaIncluirAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Reserva reserva = null;
		Usuario usuario = null;
		Livro livro = null;
		DAOFactory df = null;

		String mensagem = null;

		GenericDAO<Reserva> daoReserva = null;
		GenericDAO<Usuario> daoUsuario = null;
		GenericDAO<Livro> daoLivro = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);

			daoReserva = (GenericDAO<Reserva>) df.getGenericoDAOReservaHibernate();
			daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();
			daoLivro = (GenericDAO<Livro>) df.getGenericoDAOLivroHibernate();

			reserva = new Reserva();
			usuario = new UsuarioVip();

			usuario.setLogin(request.getParameter("login"));

			reserva.setUsuario(usuario);
			usuario.addReserva(reserva);

			livro = new Livro();
			livro.setCodigo(request.getParameter("codigo"));

			reserva.setCodLivro(livro);
			livro.addReserva(reserva);

			String dataForm = request.getParameter("dataCadastro");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date data = formatter.parse(dataForm);

			Calendar c = Calendar.getInstance();

			c.setTime(data);

			reserva.setDataCadastro(c);

			daoReserva.incluir(reserva);

			mensagem = "Reserva feita!!";

		} catch (ClassNotFoundException e) {
			mensagem = "Erro de Driver";
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			mensagem = "Não existe livro com este código.";
			System.out.println(e.getMessage());
		} catch (Exception e) {
			mensagem = "Erro";
			System.out.println(e.getMessage());
		}
		request.setAttribute("aux", mensagem);
		return mapping.findForward("sucessoIncluirReserva");
	}
}
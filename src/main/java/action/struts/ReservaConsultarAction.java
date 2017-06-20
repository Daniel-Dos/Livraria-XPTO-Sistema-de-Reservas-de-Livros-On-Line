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

import action.form.bean.ReservaForm;
import action.form.bean.UsuarioForm;
import java.sql.SQLException;
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
public class ReservaConsultarAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Reserva reserva = null;
		String msg = null;
		Usuario usuario = null;
		DAOFactory df = null;
		Livro livro = null;

		GenericDAO<Reserva> daoReserva = null;
		GenericDAO<Usuario> daoUsuario = null;
		GenericDAO<Livro> daoLivro = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
			daoLivro = (GenericDAO<Livro>) df.getGenericoDAOLivroHibernate();
			daoReserva = (GenericDAO<Reserva>) df.getGenericoDAOReservaHibernate();
			daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();

			reserva = new Reserva();
			usuario = new UsuarioVip();

			usuario.setLogin(request.getParameter("login"));

			request.setAttribute("usuario", daoUsuario.consultar(usuario));

			reserva.setUsuario(usuario);
			usuario.addReserva(reserva);

			request.setAttribute("al", daoReserva.getUser(reserva));

			msg = "Consulta de Reserva realizada com sucesso";

		} catch (ClassNotFoundException e) {
			msg = "Erro de Driver";
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			msg = "Erro de SQL";
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			msg = "Erro generico";
			System.out.println(e.getMessage());
		}
		request.setAttribute("msg", msg);
		return mapping.findForward("sucessoConsultaReserva");
	}
}
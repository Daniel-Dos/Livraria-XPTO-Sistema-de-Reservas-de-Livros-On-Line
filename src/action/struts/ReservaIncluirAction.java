/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Daniel Dias
 */
public class ReservaIncluirAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	// private static final String SUCCESS = "success";
	/**
	 * This is the action called from the Struts framework.
	 *
	 * @param mapping
	 *            The ActionMapping used to select this instance.
	 * @param form
	 *            The optional ActionForm bean for this request.
	 * @param request
	 *            The HTTP Request we are processing.
	 * @param response
	 *            The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */
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
		} catch (SQLException e) {
			mensagem = "Não existe livro com este código.";
			e.printStackTrace();
		} catch (Exception e) {
			mensagem = "Erro";

			e.printStackTrace();
		}

		request.setAttribute("aux", mensagem);
		return mapping.findForward("sucessoIncluirReserva");
	}
}

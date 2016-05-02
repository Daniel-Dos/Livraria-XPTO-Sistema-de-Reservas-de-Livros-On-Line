/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.struts;

import action.form.bean.UsuarioForm;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Usuario;
import modelos.UsuarioVip;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 *
 * @author Daniel Dias
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    // private static final String SUCCESS = "success";
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     *
     *
     *
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Usuario usuario = null;
        DAOFactory df = null;
        String msg = null, msg1 = null;

        GenericDAO<Usuario> daoUsuario = null;

        try {
 
            df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
            daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();

            usuario = new UsuarioVip();
            BeanUtils.copyProperties(usuario, (UsuarioForm) form);

            usuario = daoUsuario.consultarLoginSenha(usuario);

            String acao = request.getParameter("acao");

            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario);
                acao = "V";
            }

            if (acao.equals("V")) {
                //Verificação
                HttpSession session = request.getSession();
                if (session.getAttribute("usuario") != null) {
                    msg = "Seja Bem Vindo  ";
                    request.setAttribute("msg", msg);
                } else {
                    request.getSession().invalidate();
                    msg1 = "Usuario/Senha não existe ou não Cadastrado!!";
                    request.setAttribute("msg1", msg1);

                    return mapping.findForward("erroLogin");
                }
            }

        } catch (ClassNotFoundException e) {
            msg1 = "Erro de Driver";
            //e.printStackTrace();
            request.setAttribute("msg1", msg1);
            return mapping.findForward("erroLogin");

        } catch (SQLException | ConnectException e) {
            msg1 = "Erro de SQL - Erro ao conectar no servidor 'localhost' porta '1527";
            //e.printStackTrace();
            request.setAttribute("msg1", msg1);
            return mapping.findForward("erroLogin");
        } catch (Exception e) {
            msg1 = "Erro generico";
            e.printStackTrace();
            request.setAttribute("msg1", msg1);
            return mapping.findForward("erroLogin");
        }

        return mapping.findForward("logado");
    }

}

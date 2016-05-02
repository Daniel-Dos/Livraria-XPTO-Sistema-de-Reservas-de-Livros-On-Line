/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.struts;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Daniel Dias
 */
public class LogoutAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
  //  private static final String SUCCESS = "success";
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String acao = request.getParameter("acao");
        if (acao.equals("R")) {
            //Logout
            request.getSession().invalidate();
            request.setAttribute("msg2", "Deslogado !!");
        }

        return mapping.findForward("logout");
    }

    /*
     private void redirecione(HttpServletRequest request,
     HttpServletResponse response, String pagina)
     throws ServletException, IOException {
     RequestDispatcher rd = request.getRequestDispatcher(pagina);
     rd.forward(request, response);
     }*/
}

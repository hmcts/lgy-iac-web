package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Util.QueryBuilder;

public class BasketFunctions extends Action {
    /**
     * log4j logging solution
     */
    static Logger logger = Logger.getLogger(BasketFunctions.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {

        try {
            String operation = request.getParameter("operation").toString();
            logger.debug(">>>>>>>" + operation);
            String number = operation.substring(operation.length() - 1, operation.length());
            logger.debug(">>>" + number);
            String token = QueryBuilder.gettoken(Integer.parseInt(number), request);

            operation = operation.substring(0, operation.length() - 1);
            logger.debug(">>>" + operation);
            request.getSession().setAttribute("token", token);

            if (operation.equals("review")) {
                logger.debug("Coming to review");
                return mapping.findForward("printPDF");
            } else if (operation.equals("edit")) {
                request.getSession().setAttribute("FeePayable", null);
                return mapping.findForward("retrieve");
            } else if (operation.equals("delete")) {
                return mapping.findForward("delete");
            }


            return mapping.findForward("failure");
        } catch (Exception ex) {
            logger.error("BasketFunctions.execute - ", ex);
            return mapping.findForward("failure");
        }

    }

}
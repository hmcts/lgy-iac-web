package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MOJICT.IACFee.Util.SecurityToken;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class WelcomeAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(WelcomeAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {
		logger.info("WelcomeAction.execute");
		request.getSession().setAttribute("token", SecurityToken.generateCode());
		// TODO: Fix this token output so it is the actual token that the user will see otherwise this is confusing as it logs the wrong token
		logger.debug("cmg here token"+ SecurityToken.generateCode());
		request.getSession().setAttribute("token1", null);
		request.getSession().setAttribute("Form", mapping.getParameter());
		return mapping.findForward("success");

	}
}

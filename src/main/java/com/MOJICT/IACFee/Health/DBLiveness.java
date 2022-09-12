package com.MOJICT.IACFee.Health;

import com.MOJICT.IACFee.Util.DBConnection;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DBLiveness extends Action {
    static Logger logger = Logger.getLogger(DBLiveness.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        DBConnection dbConnection = new DBConnection();
        Boolean result = false;

        try {
            result = dbConnection.checkDBConnection(dbConnection.getConnection(), "fees");
        } catch (Exception e) {
            logger.error("DBLiveness.execute", e);
        }

        if (result) {
            response.setStatus(200);
        } else {
            response.setStatus(404);
        }

        return null;
    }

}

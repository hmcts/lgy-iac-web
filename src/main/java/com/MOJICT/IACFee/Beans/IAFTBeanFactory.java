package com.MOJICT.IACFee.Beans;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Util.*;
import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Util.*;

public class IAFTBeanFactory implements BeanProperties {

	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IAFTBeanFactory.class);
	private static DataSource ds = null;

	/**
	 * Factory method to retrieve bean instances according to the type of
	 * submission
	 * 
	 * @param frm
	 * @param token
	 * @param datasource
	 * @param request
	 * @return bean implementing the IAFTBean interface or where no matching
	 *         been is found.
	 */
	public static IAFTBean getBeanInstance(String token, DataSource datasource, HttpServletRequest request) {
		logger.info("IAFTBeanFactory.getBeanInstance - GetBeanInstance for token:" + token);
		IAFTBean iBean = null;
		if (null == ds) {
			ds = datasource;
		}

		if (beanType(token).equals(IAFT1)) {
			logger.debug("\t\tIAFT1 Bean");
			iBean = new IAFT1Bean();
			iBean = QueryBuilder.IAFT1_1((IAFT1Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT1 Bean found");
		} else if (beanType(token).equals(IAFT2)) {
			logger.debug("\t\tIAFT2 Bean");
			iBean = new IAFT2Bean();
			iBean = QueryBuilder2.IAFT2_1((IAFT2Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT2 Bean found");
		} else if (beanType(token).equals(IAFT3)) {
			logger.debug("IAFT3 Bean");
			iBean = new IAFT3Bean();
			iBean = QueryBuilder3.IAFT3_1((IAFT3Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT3 Bean found");
		}else if (beanType(token).equals(IAFT5)) {
			logger.debug("IAFT5 Bean");
			iBean = new IAFT5Bean();
			iBean = QueryBuilder5.IAFT5_1((IAFT5Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT5 Bean found");
		}
		else if (beanType(token).equals(IAFT6)) {
			logger.debug("IAFT6 Bean");
			iBean = new IAFT6Bean();
			iBean = QueryBuilder6.IAFT6_1((IAFT6Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT6 Bean found");
		}
		else if (beanType(token).equals(IAFT7)) {
			logger.debug("IAFT7 Bean");
			iBean = new IAFT7Bean();
			iBean = QueryBuilder7.IAFT7_1((IAFT7Bean) iBean, "retrieve", datasource, token, request);
			logger.debug("\t\tIAFT7 Bean found");
		}
		else {
			logger.debug("\t\tNo Bean found");
			iBean = null;
			
		}
		return iBean;
	}

	/**
	 * Retrieve from the database the type of submission.
	 * 
	 * @return
	 */
	private static String beanType(String securityToken) {
		String type = QueryBuilder.getFormBeanBySecurityToken(securityToken, ds).getFormName();
		logger.info("IAFTBeanFactory.beanType - Bean type being requested:" + type);
		logger.debug("Query: select formname, securitytoken from formsdata where securitytoken="+securityToken);
		return type;
	}
}

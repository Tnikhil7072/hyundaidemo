package com.hyundai.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;

/**
 * @author T Nikhil
 * 
 *         By using this servlet class displaying the current page title by
 *         using page path; The code is a servlet that extends the
 *         SlingSafeMethodsServlet class. * 
 */

/**
 * in these below properties i have used GET Method , and given the registered
 * the servlet as resource type' and given the extensions as json....
 *
 */
@Component(service = Servlet.class,

		property = { Constants.SERVICE_DESCRIPTION + "=page title Demo Servlet",
				"sling.servlet.methods=" + HttpConstants.METHOD_GET,
				"sling.servlet.resourceTypes=" + "hyundaidemo/components/page", "sling.servlet.extensions=" + "txt" })

public class GettingPageTitleByServlet  extends SlingSafeMethodsServlet{
	
	private static final Logger LOG = LoggerFactory.getLogger(GettingPageTitleByServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 
		 * The doGet() method of this servlet will be called when an HTTP GET request is
		 * made to the page named
		 */

		LOG.debug("\n====Method Excuting==========");
		final Resource resource = request.getResource();
		/**
		 * This method first gets the resource from the request and then writes out some
		 * text on it
		 */
		LOG.debug("\n========Getting request from the resource===========");
		response.setContentType("text/plain");
		LOG.debug("\n===============Executing==========================");
		LOG.debug("title coming in the logs is : " + resource.getValueMap().get(JcrConstants.JCR_TITLE).toString());
		response.getWriter().write(resource.getValueMap().get(JcrConstants.JCR_TITLE).toString());

	}

}

package com.exigent.leopard.webapp;

import static com.exigent.leopard.webapp.RequestUtil.getSessionCurrentUser;
import static com.exigent.leopard.webapp.RequestUtil.getSessionLocale;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import com.exigent.leopard.core.*;

public class ProjectController {
	private static final Logger LOG = LoggerFactory.getLogger(ProjectController.class);
	public static Route serveProject = (Request request, Response response) -> {
		LOG.info("in1");
		String projectCode;
		//System.out.println(request.queryString());
		if(request.params(":code") != null){
			LOG.info(request.params(":code"));
			projectCode = request.params(":code");
			LoginController.ensureUserIsLoggedIn(request, response);
			MongoWrapper dbWrapper = new MongoWrapper();
			Project project = dbWrapper.getProjectByCode(projectCode);
			Map<String, Object> model = new HashMap<>();
	        model.put("project", project);
	        model.put("clientip", request.ip());
	        model.put("basedata", request.attributes());
	        model.put("msg", new MessageBundle(getSessionLocale(request)));
	        model.put("currentUser", getSessionCurrentUser(request));
	        model.put("WebPath", Path.Web.class); // Access application URLs from templates
	        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.PROJECT));
		}
		LOG.info("not in");
		//redirect
		return request;
		};

}

package com.exigent.leopard.webapp;

import static com.exigent.leopard.webapp.RequestUtil.getSessionCurrentUser;
import static com.exigent.leopard.webapp.RequestUtil.getSessionLocale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import com.exigent.leopard.core.*;

public class DashController {
	public static Route serveDashboard = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		MongoWrapper dbWrapper = new MongoWrapper();
		ArrayList<Project> projects = new ArrayList<Project>();
		projects = dbWrapper.getAllProjects();
        Map<String, Object> model = new HashMap<>();
        model.put("projects", projects);
        model.put("clientip", request.ip());
        model.put("basedata", request.attributes());
        model.put("msg", new MessageBundle(getSessionLocale(request)));
        model.put("currentUser", getSessionCurrentUser(request));
        model.put("WebPath", Path.Web.class); // Access application URLs from templates
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, Path.Template.DASHBOARD)
            );
       // return ViewUtil.render(request, model, Path.Template.INDEX);
    };

}

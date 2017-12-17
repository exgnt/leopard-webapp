package com.exigent.leopard.webapp;



import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;


public class IndexController {
	 public static Route serveIndexPage = (Request request, Response response) -> {
	        Map<String, Object> model = new HashMap<>();
	        return new VelocityTemplateEngine().render(
	                new ModelAndView(model, Path.Template.INDEX)
	            );
	       // return ViewUtil.render(request, model, Path.Template.INDEX);
	    };

}

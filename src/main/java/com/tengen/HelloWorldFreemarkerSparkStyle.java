package com.tengen;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


public class HelloWorldFreemarkerSparkStyle {
	
	public static void main( String[] args ) 
    {
      final Configuration config = new Configuration ();
      config.setClassForTemplateLoading(HelloWorldFreemarkerSparkStyle.class, "/");
      //http://localhost:4567/
  
      Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter writer = new StringWriter();
				try {
					Template t = config.getTemplate("hello.ftl");
					
					Map <String,Object> map = new HashMap <String,Object> ();
					map.put("name", "david");
					t.process(map, writer);
					//System.out.println(writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
			
				return writer;
			}
		});
      
      
     
      
        
       
    }

}

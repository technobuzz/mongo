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


public class HelloWorldFreemarkerStyle {
	
	public static void main( String[] args ) 
    {
      Configuration c = new Configuration ();
      c.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
      //http://localhost:4567/
      
      
      try {
		Template t = c.getTemplate("hello.ftl");
		StringWriter writer = new StringWriter();
		Map <String,Object> map = new HashMap <String,Object> ();
		map.put("name", "david");
		t.process(map, writer);
		System.out.println(writer);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TemplateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
        
       
    }

}

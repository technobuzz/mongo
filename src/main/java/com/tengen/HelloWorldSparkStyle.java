package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


public class HelloWorldSparkStyle {
	
	public static void main( String[] args ) 
    {
    	
      //http://localhost:4567/
        Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
			
				return "Hello Spark World!";
			}
		});
       
    }

}

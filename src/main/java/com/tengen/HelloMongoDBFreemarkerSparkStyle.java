package com.tengen;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Hello world!
 *
 */
public class HelloMongoDBFreemarkerSparkStyle 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	
    	final Configuration config = new Configuration ();
    	MongoClient mongoStyleClient = new MongoClient(new ServerAddress("localhost", 27017));
    	DB db = mongoStyleClient.getDB("test");
    	
        config.setClassForTemplateLoading(HelloWorldFreemarkerSparkStyle.class, "/");
        //http://localhost:4567/
        
        final DBCollection coll = db.getCollection("mycollections");
        
       
    
        Spark.get(new Route("/") {
  			
  			@Override
  			public Object handle(Request arg0, Response arg1) {
  				StringWriter writer = new StringWriter();
  				try {
  					Template t = config.getTemplate("monghello.ftl");
  					
  					DBObject document1 = coll.findOne();
  					 System.out.println(document1);
  					 

                    /*
                     *  http://api.mongodb.org/java/2.0/com/mongodb/BasicDBObject.html
                     * 
                     * C:\mongodb226>mongo
                         MongoDB shell version: 2.2.6
                         connecting to: test
                       > db
                       test
                       > show collections
                       mycollections
                       system.indexes
                       >  db.mycollections.find()
                       { "_id" : ObjectId("5254c64c2488183e2c3d49f8"), "text" : "hello world" }
                   >*/

  					 
  					
  					t.process(document1, writer);
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

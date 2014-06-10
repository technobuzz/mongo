package com.tengen;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Hello world!
 *
 */
public class HelloMongoDB 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	MongoClient mongoStyleClient = new MongoClient(new ServerAddress("localhost", 27017));
    	DB db = mongoStyleClient.getDB("test");
        System.out.println( "Hello World!" );
        DBCollection coll = db.getCollection("mycollections");
        DBObject document1 = coll.findOne();
        System.out.println(document1);
    }
}

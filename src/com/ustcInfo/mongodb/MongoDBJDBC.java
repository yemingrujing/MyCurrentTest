package com.ustcInfo.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * MongoDB测试
 * @author guang.wei
 * @datetime 2018年5月5日 下午3:32:02
 */
public class MongoDBJDBC {

	public static void main(String[] args) {
		try {
			//连接到mongdb服务
			MongoClient mongoClient = new MongoClient("192.168.139.129",27017);
			//连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
			System.out.println("connect to database successfully");
			//创建集合
//			mongoDatabase.createCollection("col3");
//			System.out.println("创建集合成功");
			MongoCollection<Document> collection = mongoDatabase.getCollection("col3");
			System.out.println("集合col3选择成功");
			
			//删除文档
			deleteDocument(collection);
			
			//插入文档
			/**
			 * 1.创建文档org.bson.Document参数为key-value的格式
			 * 2.创建文档集合List<Document>
			 * 3.将文档集合插入数据库集合中mongoCollection.insertMany(List<Document>)
			 * 插入单个文档可以用mongoCollection.insertOne(Document)
			 */
			insertDocument(collection);
			findFirst(collection);
			findAll(collection);
			
			//更新文档,将文档中likes=100文档修改为likes=200
			collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
			findFirst(collection);
			findAll(collection);
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ":" + e.getMessage());
		}
	}
	
	public static void findFirst(MongoCollection<Document> collection) {
		Document myDoc = collection.find().first();
//		myDoc = collection.find(Filters.eq("likes", 100)).first();
		System.out.println("获取集合第一个文档" + myDoc.toJson());
	}
	
	public static void findAll(MongoCollection<Document> collection) {
		//检索所有文档
		/**
		 * 1.获取迭代器FindIterable<Document>
		 * 2.获取游标MongoCursor<Document>
		 * 3.通过游标遍历检索出的文档集合
		 */
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while(mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next().toJson());
		}
	}
	
	public static void insertDocument(MongoCollection<Document> collection) {
		//插入文档
		/**
		 * 1.创建文档org.bson.Document参数为key-value的格式
		 * 2.创建文档集合List<Document>
		 * 3.将文档集合插入数据库集合中mongoCollection.insertMany(List<Document>)
		 * 插入单个文档可以用mongoCollection.insertOne(Document)
		 */
		Document document = new Document("title","MongoDB").
				append("description", "database").
				append("likes", 100).
				append("info", new Document("x", 203).append("y", 102)).
				append("by", "GuangWei");
		List<Document> documents = new ArrayList<Document>();
		documents.add(document);
		collection.insertMany(documents);
		System.out.println("文档插入成功");
	}
	
	public static void deleteDocument(MongoCollection<Document> collection) {
		//删除符合条件的第一个文档
		collection.deleteOne(Filters.eq("likes",200));
		//删除所有符合条件的文档
		collection.deleteMany(Filters.eq("likes", 200));
	}
}

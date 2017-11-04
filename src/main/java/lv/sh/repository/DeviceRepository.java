package lv.sh.repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;
import lv.sh.beans.Device;
import lv.sh.utils.AppUtils;

public class DeviceRepository {

    private MongoClient client;
    private DBCollection deviceCollection;
    private String dbName;
    private String collectionName;
    private DBCollection table;

    public DeviceRepository() {

        
        String uriString = "mongodb://user1:user1@ds249025.mlab.com:49025/sh";
        MongoURI uri = new MongoURI(uriString);

     //   DB db = null;
      //  try {
       //     db = uri.connectDB();
       // } catch (UnknownHostException e) {
       //     e.printStackTrace();
        //}

        //table = db.getCollection("devices");


    }

    public void insert(Device device){
        table.insert(AppUtils.toDBObject(device));
    }
}
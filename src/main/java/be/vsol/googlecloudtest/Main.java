package be.vsol.googlecloudtest;

import be.vsol.commons.http.HttpServer;
import be.vsol.database.connection.MySQL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world");

        MySQL mySQL = new MySQL("35.233.127.16", 3306, "root", "vsolutions1");
        mySQL.start();

        Db db = new Db(mySQL, "google_cloud_test_db");
        db.connect();

        HttpServer restServer = new HttpServer("GoogleCloudTest REST Server");
        restServer.start(9000, new RestApi(db));

    }
}

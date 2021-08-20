package be.vsol.googlecloudtest;

import be.vsol.commons.tools.json;
import be.vsol.database.db;
import be.vsol.database.model.DbRecord;

public class Client extends DbRecord {

    @db @json private String name;
    @db @json private int age;

    public Client() {

    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public String toString() {
        return name + " (" + age + ")";
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}
}

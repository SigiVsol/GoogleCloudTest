package be.vsol.googlecloudtest;

import be.vsol.database.connection.DbDriver;
import be.vsol.database.model.Database;
import be.vsol.database.model.DbTable;

public class Db extends Database {

    private final DbTable<Client> clients;

    public Db(DbDriver driver, String name) {
        super(driver, name);

        clients = new DbTable<>(this, "clients", Client::new);
    }

    public DbTable<Client> getClients() { return clients; }
}

package ru.dbpractice.learnup.db.Service;

import ru.dbpractice.learnup.db.entity.Client;

import java.util.List;

public interface ClientService {

     List<Client> getAllClients();

     Client getClientById(int id);

     void saveClient(Client client);

     void deleteClient(int id);

}

package ru.dbpractice.learnup.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbpractice.learnup.db.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}

package ru.dbpractice.learnup.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbpractice.learnup.db.entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

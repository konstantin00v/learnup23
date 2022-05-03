package ru.dbpractice.learnup.db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.dbpractice.learnup.db.model.Author;
import ru.dbpractice.learnup.db.model.Book;


import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        Configuration configuration = new Configuration().addAnnotatedClass(Author.class)
                .configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public List<Book> findAllBook() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();
        session.close();
        return books;
    }

    public List<Author> findAllAuthor() {
        Session session = sessionFactory.openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return authors;
    }



    public void save(Object object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

}

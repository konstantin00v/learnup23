package ru.dbpractice.learnup;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dbpractice.learnup.db.DbHelper;
import ru.dbpractice.learnup.db.Service.AuthorService;
import ru.dbpractice.learnup.db.Service.AuthorServiceImpl;
import ru.dbpractice.learnup.db.Service.BookService;
import ru.dbpractice.learnup.db.Service.BookServiceImpl;
import ru.dbpractice.learnup.db.model.*;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LearnupApplication {

	public static void main(String[] args) {

//		SpringApplication.run(LearnupApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(LearnupApplication.class, args);

		AuthorService authorService = context.getBean(AuthorServiceImpl.class);
		authorService.saveAuthor(new Author("Франц Кафка"));

		System.out.println(authorService.getAllAuthors());


//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Author.class)
//				.addAnnotatedClass(Book.class)
//				.addAnnotatedClass(OrderDetails.class)
//				.addAnnotatedClass(Order.class)
//				.addAnnotatedClass(Client.class)
//				.addAnnotatedClass(BookStock.class)
//				.buildSessionFactory();
//		Session session = null;


		/*
		try {

			session = factory.getCurrentSession(); //открываем сессию
			Author bukowski = new Author("Bukowski");
			Book book = new Book("BlueBird", bukowski, 1865, 100, 800);
			BookStock bookStock = new BookStock(2, book);
			Client shopper = new Client("Milena", 1999);
			Order orderBook = new Order(shopper, 800);
			OrderDetails orderDetails = new OrderDetails(orderBook, 2, 1802, book);

//			Открываем транзакцию
			session.beginTransaction();

			session.save(bukowski);
			session.save(bookStock);
			session.save(orderDetails);
			session.save(shopper);
			session.save(orderBook);
// 			закрываем транзакцию
			session.getTransaction().commit();

			DbHelper dbhlpr = new DbHelper();
			//Выводим названия книг
			System.out.println(dbhlpr.findAllBook());

		} finally {
			session.close();
			factory.close();
		}

		 */


	}

}

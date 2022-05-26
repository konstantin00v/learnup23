package ru.dbpractice.learnup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dbpractice.learnup.db.Service.AuthorService;
import ru.dbpractice.learnup.db.Service.AuthorServiceImpl;
import ru.dbpractice.learnup.db.Service.OrderService;
import ru.dbpractice.learnup.db.Service.OrderServiceImpl;
import ru.dbpractice.learnup.db.entity.Author;
import ru.dbpractice.learnup.db.entity.Book;
import ru.dbpractice.learnup.db.entity.BookStock;
import ru.dbpractice.learnup.db.entity.Client;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LearnupApplication {

	public static void main(String[] args) {

//		SpringApplication.run(LearnupApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(LearnupApplication.class, args);

		AuthorService authorService = context.getBean(AuthorServiceImpl.class);
		OrderService orderService = context.getBean(OrderServiceImpl.class);

//		authorService.saveAuthor(new Author("Франц Кафка"));

//		System.out.println(authorService.getAllAuthors());
		Author bukowski = new Author("Bukowski");
		Book book = new Book("BlueBird", bukowski, 1865, 100, 800);

		BookStock store = new BookStock(book, 1);


		Client client0 = new Client("Milena", "18 февраля 2000");
		Client client1 = new Client("Yana", "12 января 1999");

		new Thread(() -> {
			((OrderServiceImpl) orderService).addOrder(book.getBook_id(), client1, 1, store);
		}).start();

		new Thread(() -> {
			((OrderServiceImpl) orderService).addOrder(book.getBook_id(), client0, 1, store);
		}).start();
























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

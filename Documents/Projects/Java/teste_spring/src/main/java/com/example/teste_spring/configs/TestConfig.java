package com.example.teste_spring.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.teste_spring.entities.Category;
import com.example.teste_spring.entities.Order;
import com.example.teste_spring.entities.OrderItem;
import com.example.teste_spring.entities.Payment;
import com.example.teste_spring.entities.Product;
import com.example.teste_spring.entities.User;
import com.example.teste_spring.entities.enums.OrderStatus;
import com.example.teste_spring.repositories.CategoryRepository;
import com.example.teste_spring.repositories.OrderItemRepository;
import com.example.teste_spring.repositories.OrderRepository;
import com.example.teste_spring.repositories.ProductRepository;
import com.example.teste_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"a1","a1@email.com","1199999999","1234");
		User u2 = new User(null,"a2","a2@email.com","2199999999","4321");
		
		Order o1 = new Order(null,Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null,Instant.parse("2020-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null,Instant.parse("2021-06-20T19:53:07Z"),OrderStatus.CANCELED,u1);
		
		Category c1 = new Category(null,"category1");
		Category c2 = new Category(null,"category2");
		Category c3 = new Category(null,"category3");
		
		Product p1 = new Product(null,"p1","p1 description",1100.00,"url do p1");
		Product p2 = new Product(null,"p2","p2 description",1200.00,"url do p2");
		Product p3 = new Product(null,"p3","p3 description",1300.00,"url do p3");
		Product p4 = new Product(null,"p4","p4 description",1400.00,"url do p4");
		Product p5 = new Product(null,"p5","p5 description",1500.00,"url do p5");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.now(),o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
	
	
}

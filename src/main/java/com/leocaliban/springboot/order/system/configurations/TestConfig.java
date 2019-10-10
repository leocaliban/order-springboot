package com.leocaliban.springboot.order.system.configurations;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leocaliban.springboot.order.system.entities.Category;
import com.leocaliban.springboot.order.system.entities.Order;
import com.leocaliban.springboot.order.system.entities.OrderItem;
import com.leocaliban.springboot.order.system.entities.Payment;
import com.leocaliban.springboot.order.system.entities.Product;
import com.leocaliban.springboot.order.system.entities.User;
import com.leocaliban.springboot.order.system.entities.enums.OrderStatus;
import com.leocaliban.springboot.order.system.repositories.CategoryRepository;
import com.leocaliban.springboot.order.system.repositories.OrderItemRepository;
import com.leocaliban.springboot.order.system.repositories.OrderRepository;
import com.leocaliban.springboot.order.system.repositories.ProductRepository;
import com.leocaliban.springboot.order.system.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

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
		User u1 = User.builder().name("Jack").password("6876").phone("95989599898").email("jack@gmail.com").build();
		User u2 = User.builder().name("Carla").password("3123").phone("839184111465").email("carla@gmail.com").build();

		Order o1 = Order.builder().moment(Instant.parse("2019-09-09T12:00:00Z")).orderStatus(OrderStatus.PAID)
				.client(u1).build();
		Order o2 = Order.builder().moment(Instant.parse("2019-07-10T12:00:00Z")).orderStatus(OrderStatus.PAID)
				.client(u2).build();
		Order o3 = Order.builder().moment(Instant.parse("2019-07-20T12:00:00Z")).orderStatus(OrderStatus.CANCELED)
				.client(u1).build();

		Category c1 = Category.builder().name("Eletronics").build();
		Category c2 = Category.builder().name("Books").build();
		Category c3 = Category.builder().name("Computers").build();

		Product p1 = Product.builder().name("The Lord of the Rings")
				.description("Lorem ipsum dolor sit amet, consectetur.").price(90.5).imgUrl("").build();
		Product p2 = Product.builder().name("Smart TV").description("Nulla eu imperdiet purus. Maecenas ante.")
				.price(2190.0).imgUrl("").build();
		Product p3 = Product.builder().name("Macbook Pro").description("Nam eleifend maximus tortor, at mollis.")
				.price(1250.0).imgUrl("").build();
		Product p4 = Product.builder().name("PC Gamer").description("Donec aliquet odio ac rhoncus cursus.")
				.price(1200.0).imgUrl("").build();
		Product p5 = Product.builder().name("Rails for Dummies")
				.description("Cras fringilla convallis sem vel faucibus.").price(100.99).imgUrl("").build();

		p1.addCategory(c2);
		p2.addCategory(c1);
		p2.addCategory(c3);
		p3.addCategory(c3);
		p4.addCategory(c3);
		p5.addCategory(c2);

		repository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = OrderItem.builder().order(o1).product(p1).quantity(2).price(p1.getPrice()).build();
		OrderItem oi2 = OrderItem.builder().order(o1).product(p3).quantity(1).price(p3.getPrice()).build();
		OrderItem oi3 = OrderItem.builder().order(o2).product(p3).quantity(2).price(p3.getPrice()).build();
		OrderItem oi4 = OrderItem.builder().order(o3).product(p5).quantity(2).price(p5.getPrice()).build();

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = Payment.builder().moment(Instant.parse("2019-09-09T15:00:00Z")).order(o1).build();
		o1.setPayment(pay1);

		orderRepository.save(o1);

	}
}

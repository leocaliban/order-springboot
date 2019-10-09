package com.leocaliban.springboot.order.system.configurations;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leocaliban.springboot.order.system.entities.Order;
import com.leocaliban.springboot.order.system.entities.User;
import com.leocaliban.springboot.order.system.repositories.OrderRepository;
import com.leocaliban.springboot.order.system.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = User.builder().name("Jack").password("6876").phone("95989599898").email("jack@gmail.com").build();
		User u2 = User.builder().name("Carla").password("3123").phone("839184111465").email("carla@gmail.com").build();

		Order o1 = Order.builder().moment(Instant.parse("2019-09-09T12:00:00Z")).client(u1).build();
		Order o2 = Order.builder().moment(Instant.parse("2019-07-10T12:00:00Z")).client(u2).build();
		Order o3 = Order.builder().moment(Instant.parse("2019-07-20T12:00:00Z")).client(u1).build();

		repository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}

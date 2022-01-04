package com.example.tickets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
//@EnableSwagger2
public class TicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}


//
//	@EventListener
//	public void seed(ContextRefreshedEvent contextRefreshedEvent) {
//		seedUsersTable();
//
//	}

//	private void seedUsersTable() {
//
//		if(u == null || u.size() <= 0) {
//			User user = new User();
//			user.setName("Spring Blog");
//			user.setUsername("admin");
//			user.setEmail("test@test.com");
//			user.setPassword(new BCryptPasswordEncoder().encode("test123"));
//			user.setRole(Roles.SUPER_ADMIN.toString());
//
//			userRepository.save(user);
//			logger.info("Users Seeded");
//		} else {
//			logger.info("Users Seeding Not Required");
//		}
//	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}
	

}
//package pl.pilaf.tgl;
//
//import org.fest.assertions.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//import pl.pilaf.enums.UserType;
//import pl.pilaf.inz.config.AppConfig;
//import pl.pilaf.inz.model.User;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = { AppConfig.class })
//@WebIntegrationTest("server.port:9998")
//public class HomeControllerIntegrationTests {
//
//	RestTemplate restTemplate = new TestRestTemplate();
//
//	@Test
//	public void shouldAdd_AppUser_ToDb() {
////		ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:9998/user/create",
////				new User(0, "Jan", "Kowalski", null, null, UserType.USER, "Janek", "Janek", null, null, User.class));
////		final User appUser = responseEntity.getBody();
////		Assertions.assertThat(appUser).isNotNull();
////		Assertions.assertThat(appUser.getFirstName()).equals("Janek");
////		Assertions.assertThat(appUser.getLastName()).equals("Kowalski");
//
//	}
//}

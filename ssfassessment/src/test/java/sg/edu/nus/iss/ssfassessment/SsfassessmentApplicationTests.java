package sg.edu.nus.iss.ssfassessment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsfassessmentApplicationTests {

	@Test
	void contextLoads() {
	}

}


/* @SpringBootApplication
public class NewsapiApplication implements CommandLineRunner {

	@Autowired
	private NewsService newsSvc;

	public static void main(String[] args) {
		SpringApplication.run(NewsapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CountryCode> codes = newsSvc.getCountryCode();

		System.out.printf("---- country code: %s\n", codes);
	}
}
 */
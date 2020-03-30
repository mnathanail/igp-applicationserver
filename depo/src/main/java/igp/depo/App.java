package igp.depo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import igp.depo.repo.ForeasDao;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ForeasDao.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

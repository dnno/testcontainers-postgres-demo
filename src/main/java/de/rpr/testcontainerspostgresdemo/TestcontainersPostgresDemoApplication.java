package de.rpr.testcontainerspostgresdemo;

import de.rpr.testcontainerspostgresdemo.repository.MyEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MyEntityRepository.class)
public class TestcontainersPostgresDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestcontainersPostgresDemoApplication.class, args);
  }
}

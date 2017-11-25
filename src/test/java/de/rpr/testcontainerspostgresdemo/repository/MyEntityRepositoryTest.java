package de.rpr.testcontainerspostgresdemo.repository;

import de.rpr.testcontainerspostgresdemo.TestcontainersPostgresDemoApplication;
import de.rpr.testcontainerspostgresdemo.entity.MyEntity;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestcontainersPostgresDemoApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyEntityRepositoryTest {

  @Autowired
  ApplicationContext applicationContext;
  @Autowired
  MyEntityRepository repository;

  @ClassRule
  public static PostgreSQLContainer postgres = new PostgreSQLContainer();

  @Test
  public void should_load_context() {
    assertThat(applicationContext).isNotNull();
  }

  @Test
  public void persisted_entity_should_be_loadable() {
    repository.save(new MyEntity(1L));
    assertThat(repository.findOne(1L)).isNotNull();
  }
}

package de.rpr.testcontainerspostgresdemo.repository;

import de.rpr.testcontainerspostgresdemo.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}

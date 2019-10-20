package ee.taltech.team7.calculator.repository;

import ee.taltech.team7.calculator.entities.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepo extends JpaRepository<ResponseEntity,Long> {
}

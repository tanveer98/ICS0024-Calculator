package ee.taltech.team7.calculator.repository;

import ee.taltech.team7.calculator.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {

    @Query(value = "SELECT COUNT(id) FROM request where :param_min = min_val AND :param_max = max_val;", nativeQuery = true)
    public long findExisting(@Param("param_min") long min,@Param("param_max") long max);


}

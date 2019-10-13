package ee.taltech.team7.calculator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long minval;
    Long maxVal;

   public Request(Long min, Long max) {
        this.minval = min;
        this.maxVal = max;
    }

}

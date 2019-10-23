package ee.taltech.team7.calculator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Request")
public class RequestEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "minVal")
    Long minval;
    @Column(name = "maxVal")
    Long maxVal;

   public RequestEntity(Long min, Long max) {
        this.minval = min;
        this.maxVal = max;
    }

}

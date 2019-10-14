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
@Table(uniqueConstraints = @UniqueConstraint(columnNames ={"minVal","maxVal"}))
public class Request {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "minVal")
    Long minval;
    @Column(name = "maxVal")
    Long maxVal;

   public Request(Long min, Long max) {
        this.minval = min;
        this.maxVal = max;
    }

}

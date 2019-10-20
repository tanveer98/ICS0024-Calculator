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
@Table(name = "Response")
public class ResponseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    Long squaredVal;

    public ResponseEntity(Long val) {
        this.squaredVal = val;
    }
}

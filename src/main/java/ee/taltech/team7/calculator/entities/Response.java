package ee.taltech.team7.calculator.entities;

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
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long squaredVal;

    public Response(Long val) {
        this.squaredVal = val;
    }
}

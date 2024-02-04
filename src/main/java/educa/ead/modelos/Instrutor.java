package educa.ead.modelos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "instrutor")
@DiscriminatorValue(value = "instrutor")
public class Instrutor {

}

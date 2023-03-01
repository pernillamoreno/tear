ackage com.example.awesomerouteplaner_municipaltransport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter@Setter
@Entity
public class Route {


    @GeneratedValue
    @Id
    private Long id;


    private String startLocation;


    private String endLocation;


    private String travelTime;


    private int changes;


    private boolean isFavoriteTravelRoute;
    //@Column(nullable = false)
    //private LocalDateTime startTime;

}

package kodlama.mk.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plaka",unique = true)

    private String plaka;

    @Column(name = "modelYılı")
    private int modelYili;

    @Column(name = "durumu")
    private int durumu;

    @Column(name = "dailyFiyat")
    private double dailyFiyat;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}

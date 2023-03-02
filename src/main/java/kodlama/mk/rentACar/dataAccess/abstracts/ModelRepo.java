package kodlama.mk.rentACar.dataAccess.abstracts;

import kodlama.mk.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model,Integer> {

}

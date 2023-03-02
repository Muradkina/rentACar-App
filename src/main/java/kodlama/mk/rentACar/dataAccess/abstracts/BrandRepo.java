package kodlama.mk.rentACar.dataAccess.abstracts;

import kodlama.mk.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepo  extends JpaRepository<Brand,Integer> {

    boolean existsByName (String name);
}
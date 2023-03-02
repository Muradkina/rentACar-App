package kodlama.mk.rentACar.rules;

import kodlama.mk.rentACar.dataAccess.abstracts.BrandRepo;
import kodlama.mk.rentACar.exception.BrandNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepo brandRepo;

    public void checkIfBrandNameExists(String name) {
        if (this.brandRepo.existsByName(name)) {
            throw new BrandNotFoundException("Brand name already exists");

        }

    }
}

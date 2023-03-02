package kodlama.mk.rentACar.business.abstracts;

import kodlama.mk.rentACar.request.brand.CreateBrandsRequest;
import kodlama.mk.rentACar.request.brand.UpdateBrandRequest;
import kodlama.mk.rentACar.responses.brand.GetAllBrandsResponse;
import kodlama.mk.rentACar.responses.brand.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandsRequest createBrandsRequest);

    GetByIdBrandResponse getByIdBrandResponse(int id);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}

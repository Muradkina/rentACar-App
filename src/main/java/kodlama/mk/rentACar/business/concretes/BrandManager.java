package kodlama.mk.rentACar.business.concretes;

import kodlama.mk.rentACar.business.abstracts.BrandService;
import kodlama.mk.rentACar.dataAccess.abstracts.BrandRepo;
import kodlama.mk.rentACar.entities.concretes.Brand;
import kodlama.mk.rentACar.mapper.ModelMapperService;
import kodlama.mk.rentACar.request.brand.CreateBrandsRequest;
import kodlama.mk.rentACar.request.brand.UpdateBrandRequest;
import kodlama.mk.rentACar.responses.brand.GetAllBrandsResponse;
import kodlama.mk.rentACar.responses.brand.GetByIdBrandResponse;
import kodlama.mk.rentACar.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepo brandRepo;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;


    @Override

    public List<GetAllBrandsResponse> getAll() {


        List<Brand> brands = brandRepo.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(b -> this.modelMapperService.forResponse()
                        .map(b, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponses;
    }

     /* return brandRepo.findAll().stream()
                .map(brand -> new GetAllBrandsResponse(brand.getId(), brand.getName()))
                .collect(Collectors.toList());
                 //stream() metodu kullanarak veritabanından gelen markaları diziye dönüştürdüm
        //map() metodu kullanarak her bir markayı GetAllBrandsResponse nesnesine dönüştürüyoruz
        //collect() metodu kullanarak dönüştürülen nesneleri bir liste haline getiriyoruz.
*/


    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());

      /*  Brand brand = new Brand();
        brand.setName(createBrandsRequest.getName());*/
        Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest, Brand.class);
        this.brandRepo.save(brand);

        //  brandRepo.save(new Brand(createBrandsRequest.getName()));

    }

    @Override
    public GetByIdBrandResponse getByIdBrandResponse(int id) {

      /*  Brand brand = this.brandRepo.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;*/
        Brand brand = brandRepo.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepo.save(brand);

    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));

        brandRepo.delete(brandToDelete);
    }
}

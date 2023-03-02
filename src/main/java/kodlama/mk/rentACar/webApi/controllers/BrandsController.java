package kodlama.mk.rentACar.webApi.controllers;

import kodlama.mk.rentACar.business.abstracts.BrandService;
import kodlama.mk.rentACar.request.brand.CreateBrandsRequest;
import kodlama.mk.rentACar.request.brand.UpdateBrandRequest;
import kodlama.mk.rentACar.responses.brand.GetAllBrandsResponse;
import kodlama.mk.rentACar.responses.brand.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;


    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getByIdBrandResponse(id);
    }


     @PutMapping
     public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
         this.brandService.update(updateBrandRequest);
     }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createModel(@RequestBody()  @Valid CreateBrandsRequest createBrandsRequest) {
        this.brandService.add(createBrandsRequest);
    }



  /*  @PutMapping
    public ResponseEntity updateAccount(@PathVariable String id,@RequestBody UpdateBrandRequest updateBrandRequest) {
        return ResponseEntity.ok(this.brandService.update(id,updateBrandRequest));
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

}

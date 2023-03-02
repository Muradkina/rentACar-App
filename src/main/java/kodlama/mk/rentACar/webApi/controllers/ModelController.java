package kodlama.mk.rentACar.webApi.controllers;

import kodlama.mk.rentACar.business.abstracts.ModelService;
import kodlama.mk.rentACar.request.CreateModelRequest;
import kodlama.mk.rentACar.responses.model.GetAllModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {


    private final ModelService modelService;

    public ModelController(ModelService  modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<GetAllModelResponse> getAllModels() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createModel(@RequestBody()  @Valid CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}

package kodlama.mk.rentACar.business.concretes;

import kodlama.mk.rentACar.business.abstracts.ModelService;
import kodlama.mk.rentACar.dataAccess.abstracts.ModelRepo;
import kodlama.mk.rentACar.entities.concretes.Model;
import kodlama.mk.rentACar.mapper.ModelMapperService;
import kodlama.mk.rentACar.request.CreateModelRequest;
import kodlama.mk.rentACar.responses.model.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepo modelRepo;
    private final ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> modelList = modelRepo.findAll();

        List<GetAllModelResponse> modelResponse = modelList.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelResponse.class)).collect(Collectors.toList());

        return modelResponse;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model =this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        modelRepo.save(model);

    }
}

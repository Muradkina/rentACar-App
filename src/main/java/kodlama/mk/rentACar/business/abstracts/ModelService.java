package kodlama.mk.rentACar.business.abstracts;

import kodlama.mk.rentACar.request.CreateModelRequest;
import kodlama.mk.rentACar.responses.model.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse>getAll();
    void add(CreateModelRequest createModelRequest);
}

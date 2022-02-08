package services;

import entities.Dataset;
import repositories.IRepository;

public class CreateService implements ICreationService {

    IRepository repository;

    public CreateService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public String create(Dataset dataset) {
         repository.save(dataset);
         return dataset.getDatasetId();
    }
}

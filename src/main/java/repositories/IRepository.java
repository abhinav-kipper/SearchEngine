package repositories;

import entities.Dataset;
import entities.Document;
import entities.RepoSearchResponse;

public interface IRepository {

    void save(Dataset dataset);

    void update(Dataset inputDataset, Document document);

    RepoSearchResponse search(String pattern, Dataset inputDataset);
}

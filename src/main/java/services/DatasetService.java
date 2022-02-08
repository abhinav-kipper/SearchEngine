package services;

import java.util.List;

import entities.Dataset;
import entities.Document;

public class DatasetService {

    ICreationService creationService;
    IUpdationService updationService;
    IDeletionService deletionService;
    ISearchService searchService;


    public DatasetService(ICreationService creationService, ISearchService searchService) {
        this.creationService = creationService;
        this.searchService = searchService;
    }

    public String create(Dataset dataset) {
        return creationService.create(dataset);

    }

    public void insertDocument(Dataset dataset, Document document) {
                updationService.update(dataset, document);
    }

    public void insertDocuments(Dataset dataset, List<Document> documents) {
        for (Document document : documents)
            insertDocument(dataset, document);

    }

    /**
     * @return list of document ids
     */
    public List<Document> search(String pattern, Dataset dataset) {
                return searchService.search(pattern, dataset);
    }



}

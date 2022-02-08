import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.Dataset;
import entities.Document;
import repositories.IRepository;
import repositories.InMemoryRepository;
import services.CacheService;
import services.CreateService;
import services.DatasetService;
import services.ICacheService;
import services.ICreationService;
import services.ISearchService;
import services.SearchService;

public class Driver {
    public static void main(String[] args) {

        Document doc1 = new Document("apple is a fruit , type");
        Document doc2 = new Document("apple apple come on.");
        Document doc3 = new Document("oranges are sour");
        Document doc4 = new Document("apple is sweet");
        Set<Document> documentSet = new HashSet<>();
        documentSet.add(doc1); documentSet.add(doc2); documentSet.add(doc3); documentSet.add(doc4);
        Dataset dataset = new Dataset(documentSet);

        IRepository repository = new InMemoryRepository();
        ICacheService cacheService = new CacheService();
        ICreationService creationService  = new CreateService(repository);
        ISearchService searchService = new SearchService(cacheService, repository);
        DatasetService datasetService = new DatasetService(creationService, searchService);


        datasetService.create(dataset);
        List<Document> apple_fruit = datasetService.search(" apple", dataset);
        print(apple_fruit);

    }
    static void print(List<Document> documents) {
        for (Document document: documents) {
            System.out.println(document.getText());
        }
    }
}

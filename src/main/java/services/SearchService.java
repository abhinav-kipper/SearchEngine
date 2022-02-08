package services;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import entities.CacheResponse;
import entities.Dataset;
import entities.Document;
import entities.RepoSearchResponse;
import repositories.IRepository;

public class SearchService implements ISearchService {

    ICacheService cacheService;

    IRepository repository;

    public SearchService(ICacheService cacheService, IRepository repository) {
        this.cacheService = cacheService;
        this.repository = repository;
    }

    public List<Document> search(String pattern, Dataset dataset) {
        CacheResponse cacheResponse = cacheService.search(pattern, dataset);
        if (Objects.nonNull(cacheResponse.getReducedPattern()) && cacheResponse.getReducedPattern().equals("")) {
            return cacheResponse.getFoundDocuments();
        }
        RepoSearchResponse repoResponse = repository.search(cacheResponse.getReducedPattern(), dataset);
        Map<String, List<Document>> wordWiseDocs = repoResponse.getWordWiseDocs();
        Set<String> wordsFound = wordWiseDocs.keySet();
        for (String word: wordsFound) {
            cacheService.save(word, wordWiseDocs.get(word), dataset);
        }
        return repoResponse.getFoundDocs();
    }
}

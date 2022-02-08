package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.xml.crypto.Data;

import entities.CacheResponse;
import entities.Dataset;
import entities.Document;

public class CacheService implements ICacheService {

    private Map<String, Map<String, Set<Document>>> datasetsCached = new HashMap<>();

    public void save(String word, List<Document> documentList, Dataset dataset) {
        Map<String, Set<Document>> wordDocs = datasetsCached.getOrDefault(dataset.getDatasetId(), new HashMap<>());
        Set<Document> wordDocumentsSet = wordDocs.getOrDefault(word, new HashSet<>());
        wordDocumentsSet.addAll(documentList);
        wordDocs.put(word, wordDocumentsSet);
        datasetsCached.put(dataset.getDatasetId(), wordDocs);
    }

    public CacheResponse search(String pattern, Dataset dataset) {
        List<Document> foundDocuments = new ArrayList<>();
        String reducedPattern = "";
        String[] wordsInPattern = pattern.split(" ");
        Map<String, Set<Document>> wordCached = datasetsCached.get(dataset.getDatasetId());
        for (String word : wordsInPattern) {
            if (Objects.nonNull(wordCached) && wordCached.containsKey(word)) {
                foundDocuments.addAll(wordCached.get(word));
            } else reducedPattern += " " + word;
        }
       return new CacheResponse(reducedPattern, foundDocuments);
    }
}

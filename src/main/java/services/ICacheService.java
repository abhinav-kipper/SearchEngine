package services;

import java.util.List;

import entities.CacheResponse;
import entities.Dataset;
import entities.Document;

public interface ICacheService {

    void save(String word, List<Document> documentList, Dataset dataset);
    CacheResponse search(String pattern, Dataset dataset);

}

package services;

import java.util.List;

import entities.Dataset;
import entities.Document;

public interface ISearchService {
    List<Document> search(String pattern, Dataset dataset);
}

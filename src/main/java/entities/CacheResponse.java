package entities;

import java.util.List;

public class CacheResponse {
    String reducedPattern;
    List<Document> foundDocuments;

    public CacheResponse(String reducedPattern, List<Document> foundDocuments) {
        this.reducedPattern = reducedPattern;
        this.foundDocuments = foundDocuments;
    }

    public CacheResponse(StringBuilder reducedPattern, List<Document> foundDocuments) {
    }

    public String getReducedPattern() {
        return reducedPattern;
    }

    public void setReducedPattern(String reducedPattern) {
        this.reducedPattern = reducedPattern;
    }

    public List<Document> getFoundDocuments() {
        return foundDocuments;
    }

    public void setFoundDocuments(List<Document> foundDocuments) {
        this.foundDocuments = foundDocuments;
    }
}

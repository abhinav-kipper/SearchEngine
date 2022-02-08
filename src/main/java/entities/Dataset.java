package entities;

import java.util.HashSet;
import java.util.Set;

public class Dataset {
    private static Long counter = 0L;
    private String datasetId;
    private Set<Document> documents = new HashSet<>();

    public Dataset(Set<Document> documents) {
        this.documents = documents;
        this.datasetId = new StringBuilder().append("doc").append(++counter).toString();
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        documents.add(document);
    }
}

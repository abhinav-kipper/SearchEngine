package entities;

import java.util.List;
import java.util.Map;

public class RepoSearchResponse {
    List<Document> foundDocs;
    Map<String, List<Document>> wordWiseDocs;

    public RepoSearchResponse(List<Document> foundDocs, Map<String, List<Document>> wordWiseDocs) {
        this.foundDocs = foundDocs;
        this.wordWiseDocs = wordWiseDocs;
    }

    public List<Document> getFoundDocs() {
        return foundDocs;
    }

    public void setFoundDocs(List<Document> foundDocs) {
        this.foundDocs = foundDocs;
    }

    public Map<String, List<Document>> getWordWiseDocs() {
        return wordWiseDocs;
    }

    public void setWordWiseDocs(Map<String, List<Document>> wordWiseDocs) {
        this.wordWiseDocs = wordWiseDocs;
    }
}

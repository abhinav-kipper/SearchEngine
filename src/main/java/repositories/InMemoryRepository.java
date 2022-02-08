package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import entities.Dataset;
import entities.Document;
import entities.RepoSearchResponse;

public class InMemoryRepository implements IRepository {

    private Map<String, Dataset> datasets = new HashMap<String, Dataset>();


    public void save(Dataset dataset) {
        datasets.put(dataset.getDatasetId(), dataset);
    }

    public void update(Dataset inputDataset, Document document) {
        Dataset dataset = datasets.get(inputDataset.getDatasetId());
        if (Objects.nonNull(dataset)) {
             dataset.addDocument(document);
        }
    }

    public RepoSearchResponse search(String pattern, Dataset inputDataset) {
        List<Document> resultDocs = new ArrayList<>();
        Dataset dataset = datasets.get(inputDataset.getDatasetId());
        Map<String, List<Document>> wordWiseDocs = new HashMap<>();
        if (Objects.nonNull(dataset)) {
            Set<Document> documents = inputDataset.getDocuments();
            String[] wordsInPattern = pattern.split(" ");
            for (Document document: documents) {
                String documentText = document.getText();
                boolean present = true;
                for (String word : wordsInPattern) {
                    present = documentText.contains(word);
                    if (present) {
                        List<Document> docsForWord = wordWiseDocs.getOrDefault(word, new ArrayList<>());
                        docsForWord.add(document);
                        wordWiseDocs.put(word, docsForWord);
                    }

                    if (!present)
                        break;
                }
                if (present)
                    resultDocs.add(document);
            }
        }

        return new RepoSearchResponse(resultDocs, wordWiseDocs);
    }
}

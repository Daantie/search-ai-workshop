package eu.luminis.searchai.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.Metadata;
import eu.luminis.searchai.service.IngestService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingest")
public class IngestController {

    private final IngestService ingestService;

    public IngestController(IngestService ingestService) {
        this.ingestService = ingestService;
    }

    @GetMapping
    public String startIngestion() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<BlogPost> documents = mapper.readValue(ResourceUtils.getFile("classpath:data/all_documents.json"), new TypeReference<>() {
            });
            List<Document> documentList = documents.stream().map(blogPost -> {
//                Metadata metadata = new Metadata();
//                metadata.add("postId", blogPost.post_id());
//                metadata.add("title", blogPost.title());
//                metadata.add("url", blogPost.url());
//                metadata.add("updatedAt", blogPost.updated_at());
//                metadata.add("body", blogPost.body());
//                metadata.add("tags", String.join(",", blogPost.tags()));
//                metadata.add("categories", String.join(",", blogPost.categories()));
                return Document.from(blogPost.title());
            }).toList();

            ingestService.ingestDocuments(documentList);

        } catch (IOException e) {
            e.printStackTrace();
            return "ERRORRRRRRRRR";
        }
        return "Ingestion started";
    }
}

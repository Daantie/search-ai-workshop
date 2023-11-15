package eu.luminis.searchai.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.opensearch.OpenSearchEmbeddingStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RAGConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        // TODO: Initiate embedding model
        return new AllMiniLmL6V2EmbeddingModel();
    }

    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {
        // TODO: Initiate embedding store
        return OpenSearchEmbeddingStore.builder()
                .indexName("embedding-store")
                .build();
    }

    @Bean
    public EmbeddingStoreRetriever embeddingStoreRetriever(EmbeddingStore<TextSegment> embeddingStore) {
        // TODO: Initiate retriever
        return EmbeddingStoreRetriever.from(embeddingStore, embeddingModel());
    }

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        // TODO: Initiate chat model
        return null;
    }
}

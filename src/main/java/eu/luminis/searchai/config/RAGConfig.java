package eu.luminis.searchai.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RAGConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        // TODO: Initiate embedding model
        return null;
    }

    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {
        // TODO: Initiate embedding store
        return null;
    }

    @Bean
    public EmbeddingStoreRetriever embeddingStoreRetriever(EmbeddingStore<TextSegment> embeddingStore) {
        // TODO: Initiate retriever
        return null;
    }

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        // TODO: Initiate chat model
        return null;
    }
}

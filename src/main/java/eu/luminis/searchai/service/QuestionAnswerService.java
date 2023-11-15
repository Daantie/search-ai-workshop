package eu.luminis.searchai.service;

import java.util.ArrayList;
import java.util.List;

import dev.langchain4j.chain.ConversationalRetrievalChain;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import eu.luminis.searchai.web.Message;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerService {
    private final ChatLanguageModel chatLanguageModel;
    private final EmbeddingStoreRetriever retriever;
    private final ConversationalRetrievalChain chain;
    private final List<Message> messages = new ArrayList<>();

    public QuestionAnswerService(ChatLanguageModel chatLanguageModel, EmbeddingStoreRetriever retriever) {
        this.chatLanguageModel = chatLanguageModel;
        this.retriever = retriever;
        this.chain = createRetrievalChain();
    }

    private ConversationalRetrievalChain createRetrievalChain() {
        // TODO: Create chain
        return null;
    }

    private PromptTemplate createPromptTemplate() {
        // TODO: Prompt engineering
        return PromptTemplate.from("{{question}} {{information}}");
    }

    public void answerQuestion(String question) {
        messages.add(new Message("You", question));

        String answer = null; // TODO: Get the answer from the chain

        messages.add(new Message("System", answer));
    }

    public List<Message> getConversationHistory() {
        return messages;
    }
}

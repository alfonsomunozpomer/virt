package com.spotqa.virtuoso;


import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

public class RagRetriever {
  @Produces
  @ApplicationScoped
  public RetrievalAugmentor create(EmbeddingStore store, EmbeddingModel model) {
    var contentRetriever = EmbeddingStoreContentRetriever.builder()
        .embeddingModel(model)
        .embeddingStore(store)
        .maxResults(3)
        .build();

    return DefaultRetrievalAugmentor.builder()
        .contentRetriever(contentRetriever)
        .contentInjector(
            (list, userMessage) -> {
              StringBuffer prompt = new StringBuffer(userMessage.singleText());
              prompt.append("\nPlease, only use the following information and the path between parenthesis to build the links:\n");
              list.forEach(
                  content -> {
                    var absolutePath = content.textSegment().metadata().getString("absolute_directory_path");
                    var text = content.textSegment().text();
                    prompt.append("- ").append(text).append(" (").append(absolutePath).append(")").append("\n");
                  });
              return new UserMessage(prompt.toString());
            })
        .build();
  }
}

package com.spotqa.virtuoso;

import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@SessionScoped
@RegisterAiService
public interface VirtAgent {
    String chat(String userMessage);
}
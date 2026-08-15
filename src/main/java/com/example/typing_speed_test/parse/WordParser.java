package com.example.typing_speed_test.parse;
import tools.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public class WordParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> getWords(InputStream inputStream) throws Exception {
        WordWrapper wrapper = objectMapper.readValue(inputStream, WordWrapper.class);
        return wrapper.getWords();
    }

}

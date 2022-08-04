package org.tadalabs.orchestra.internal.ops;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OperationMapperLoader {

    public String read(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines( Paths.get(
                getClass().getClassLoader().getResource(filePath).getFile()
        ), StandardCharsets.UTF_8);
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        return contentBuilder.toString();
    }

    public JSONObject load(String filePath) throws IOException {
        String json = this.read(filePath);
        return new JSONObject(json);
    }
}

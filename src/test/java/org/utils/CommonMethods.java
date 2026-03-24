package org.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import org.domain.PostPayload;

/**
 * Utility methods for JSON parsing, serialization, and response checks.
 */
public class CommonMethods {
    static final ObjectMapper mapper = new ObjectMapper();
    /**
     * Parses a JSON string and returns the value of the specified attribute.
     * Throws a RuntimeException if the attribute is not found.
     */
    public static String parseJson(String response, String attribute) {
        try {
            JsonNode jsonNode = mapper.readTree(response);
            return jsonNode.get(attribute).asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse payload to JSON", e);
        }
    }

    /**
     * Serializes a PostPayload object to a JSON string.
     */
    public static String payloadToJson(PostPayload payload) {
        try {
            return mapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize payload to JSON", e);
        }
    }

    /**
     * Checks if the response has content (not empty or empty array).
     */
    public static boolean hasContent(ValidatableResponse response) {
        String parsedResponse = response.extract().asString().trim();
        return !parsedResponse.isEmpty() && !parsedResponse.equals("[]");
    }
}

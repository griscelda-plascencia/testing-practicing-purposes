package org.tests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import org.tests.TestMethods.GetMethods;
import org.tests.TestMethods.ModifyMethods;
import org.utils.CommonMethods;

import static org.junit.Assert.*;

/**
 * author: Griscelda Plascencia
 */

public class CommentsTests extends GetMethods {


    /**
     * This test is getting information by postId as QueryParameter specified: /comments?postId={param}
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldGetCommentsById() {
        String id = "6";
        ValidatableResponse response = getCommentsByQueryParameter(id, "postId");
        response.assertThat().statusCode(200);
    }

    /**
     * This test is getting information by email as QueryParameter specified: /comments?email={param}
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldGetCommentsByEmail() {
        String email = "Ronny@rosina.org";
        ValidatableResponse response = getCommentsByQueryParameter(email, "email");
        response.assertThat().statusCode(200);
    }

    /**
     * This test is NOT getting information by email as QueryParameter specified: /comments?email={param}
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldNotGetCommentsByEmail() {
        String email = "gris@g.test"; //This email is not registered
        ValidatableResponse response = getCommentsByQueryParameter(email, "email");
        response.assertThat().statusCode(200);
        // Assert that the response body is an empty array
        String responseBody = response.extract().asString();
        assertTrue("Expected empty response for invalid email", responseBody.equals("[]") || responseBody.trim().equals(""));
    }

}
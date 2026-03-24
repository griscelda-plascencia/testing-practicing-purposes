package org.tests.TestMethods;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import org.domain.EndPoints;

/**
 * author: Griscelda Plascencia
 */

public class GetMethods {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    static {
        RestAssured.baseURI= BASE_URL;
    }

    public ValidatableResponse getPosts() {
        return given().contentType("application/json")
                .when().get(EndPoints.POSTS)
                .then().log().all();
    }

    public ValidatableResponse getPostsById(String parameter) {
        return given().contentType("application/json")
                .when().get(String.format(EndPoints.POST_PARAM, parameter))
                .then().log().all();
    }

    public ValidatableResponse getPostsByIdComments(String parameter) {
        return given().contentType("application/json")
                .when().get(String.format(EndPoints.POST_PARAM_COMMENTS, parameter))
                .then().log().all();
    }

    public ValidatableResponse getCommentsByQueryParameter(String value, String queryParameter) {
        return given()
                .contentType("application/json")
                .queryParam(queryParameter, value)
                .when().get(EndPoints.COMMENTS)
                .then().log().all();
    }

}
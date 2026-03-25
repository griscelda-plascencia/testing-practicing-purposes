package org.domain.testMethods;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.domain.EndPoints;
import org.domain.PostPayload;

import static io.restassured.RestAssured.given;

public class ModifyMethods {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    static {
        RestAssured.baseURI= BASE_URL;
    }

    public ValidatableResponse createPost(PostPayload payload) {
        return given().contentType("application/json")
                .body(payload)
                .when().post(EndPoints.POSTS)
                .then().log().all();
    }

    public ValidatableResponse updatePostsIdById(PostPayload payload, String parameterId) {
        return given().contentType("application/json")
                .body(payload)
                .when().put(EndPoints.POST_PARAM, parameterId)
                .then().log().all();
    }

    public ValidatableResponse deletePostById(String id) {
        return given().contentType("application/json")
                .when().delete(EndPoints.POST_PARAM, id)
                .then().log().all();
    }
}

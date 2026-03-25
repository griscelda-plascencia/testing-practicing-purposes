package org.tests;

import io.restassured.response.*;
import org.domain.testMethods.ModifyMethods;
import org.domain.PostPayload;
import org.utils.CommonMethods;
import org.testng.annotations.Test;
import org.domain.testMethods.GetMethods;

import static org.testng.Assert.*;

/**
 * author: Griscelda Plascencia
 */

public class PostsTests extends GetMethods {
    final ModifyMethods modifyMethods = new ModifyMethods();

    /**
     * This test is getting all information of the endpoint /posts.
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldGetPostsInformation() {
        ValidatableResponse response = getPosts();
        response.assertThat().statusCode(200);
    }

    /**
     * This test is getting information by the ID specified: /posts/{param}.
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldGetPostsById() {
        String id = "2";
        ValidatableResponse response = getPostsById(id);
        response.assertThat().statusCode(200);
    }

    /**
     * This test is NOT getting information by the ID specified: /posts/{param}
     *      as the resource ID does not exists.
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldNotGetPostsById() {
        String id = "5000";
        ValidatableResponse response = getPostsById(id);
        response.assertThat().statusCode(404);
    }

    /**
     * This test is getting information by the ID specified: /posts/{param}/comments
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldGetPostsCommentsInformation() {
        String id = "3";
        ValidatableResponse response = getPostsByIdComments(id);
        response.assertThat().statusCode(200);
    }

    /**
     * This test is getting information by the ID specified: /posts/{param}/comments
     * Validates that statusCode matches expected and the response is not null
     */
    @Test
    public void shouldGetPostsCommentsInformationAndNotNull() {
        String id = "4";
        ValidatableResponse response = getPostsByIdComments(id);
        response.assertThat().statusCode(200);
        assertTrue(CommonMethods.hasContent(response));
    }

    /**
     * This test is NOT getting information by the ID specified: /posts/{param}/comments
     * Validates that the response is null
     */
    @Test
    public void shouldNotGetPostsCommentsInformationAsNull() {
        String id = "40000"; //This resource id is empty
        ValidatableResponse response = getPostsByIdComments(id);
        assertFalse(CommonMethods.hasContent(response));
    }

    /**
     * This test is posting new record with specific payload into /posts/
     * Validates that statusCode matches expected and that response contains new title
     */
    @Test
    public void shouldPostNewRecord() {
        String titleToBePosted = "This is the title of new record to be posted";
        String bodyToBePosted =  "This is the body of new record to be posted";
        int userIdToBePosted = 700;
        PostPayload payload = new PostPayload(userIdToBePosted, 888, titleToBePosted, bodyToBePosted);

        ValidatableResponse response = modifyMethods.createPost(payload);
        response.assertThat().statusCode(201);

        System.out.println("This is teh response: -" + response.extract().body().toString()+"-");
        String titleUpdated = CommonMethods.parseJson(response.extract().asString(), "title");
        assertEquals(titleToBePosted, titleUpdated);
    }

    /**
     * This test is updating through put a record by resourceNumber : /posts/{param}
     * Validates that statusCode matches expected and that response contains new body
     */
    @Test
    public void shouldPutInRecordById() {
        String titleToBeUpdated = "This is the title of record to be updated";
        String bodyToBeUpdated =  "This is the body of record to be updated";
        String resourceNumber = "2";
        PostPayload payload = new PostPayload(Integer.parseInt(resourceNumber), 888, titleToBeUpdated, bodyToBeUpdated);

        ValidatableResponse response = modifyMethods.updatePostsIdById(payload, resourceNumber);
        response.assertThat().statusCode(200);

        String bodyUpdated = CommonMethods.parseJson(response.extract().asString(), "body");
        assertEquals(bodyToBeUpdated, bodyUpdated);
    }

    /**
     * This test is NOT updating through put a record by resourceNumber : /posts/{param}
     *      as the record does not exist
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldNotPutInRecordById() {
        String titleToBeUpdated = "This is the title of record to be updated";
        String bodyToBeUpdated =  "This is the body of record to be updated";
        String resourceNumber = "200000";
        PostPayload payload = new PostPayload(Integer.parseInt(resourceNumber), 888, titleToBeUpdated, bodyToBeUpdated);

        ValidatableResponse response = modifyMethods.updatePostsIdById(payload, resourceNumber);
        response.assertThat().statusCode(500);
    }

    /**
     * This test is deleting by resource Number: /posts/{param}
     * Validates that statusCode matches expected
     */
    @Test
    public void shouldDeleteRecordById() {
        String id = "2";
        ValidatableResponse response = modifyMethods.deletePostById(id);
        response.assertThat().statusCode(200);
    }

}

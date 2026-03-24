package org.domain;

/**
 * Centralized API endpoint definitions for JSONPlaceholder.
 */
public class EndPoints {
    /** GET all posts */
    public static final String POSTS = "/posts";
    /** GET all comments */
    public static final String COMMENTS = "/comments";
    /** GET, PUT, PATCH, DELETE a post by ID */
    public static final String POST_PARAM = "/posts/%s";
    /** GET comments for a post by ID */
    public static final String POST_PARAM_COMMENTS = "/posts/%s/comments";
}
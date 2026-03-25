package org.domain;

/**
 * Record representing a Post payload for JSONPlaceholder.
 */
public record PostPayload(int userId, int id, String title, String body) {}
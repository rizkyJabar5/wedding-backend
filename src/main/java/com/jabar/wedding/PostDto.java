package com.jabar.wedding;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
public record PostDto(String name, Boolean status, String comment) implements Serializable {
}
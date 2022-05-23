package com.efecte.postit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * NotesException for custom exception
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesException extends Exception {
    private int status;
    private String message;

    public NotesException(String message) {
        super(message);
    }

}

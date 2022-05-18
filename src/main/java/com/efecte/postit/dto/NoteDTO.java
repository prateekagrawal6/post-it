package com.efecte.postit.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * NoteDTO for Data Transfer Object
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long id;

    @NotNull
    private String note;
}

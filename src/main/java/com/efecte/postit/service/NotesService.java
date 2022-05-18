package com.efecte.postit.service;

import com.efecte.postit.dto.NoteDTO;

import java.util.List;

/**
 * NotesService for the CRUD operation of a Post (Note)
 */
public interface NotesService {
    /**
     * create method to add or create a Post (Note)
     *
     * @param note NoteDTO as parameter
     * @return returns NoteDTO with corresponding ID as creating in repository
     */
    NoteDTO create(NoteDTO note);

    /**
     * get method to fetch a Post (Note)
     *
     * @param id Id as a parameter
     * @return returns NoteDTO ( the corresponding Post )
     */
    NoteDTO get(Long id);

    /**
     * update method to update a Post (Note)
     *
     * @param note NoteDTO as a parameter
     * @return returns NoteDTO after the update is successful
     */
    NoteDTO update(NoteDTO note);

    /**
     * delete method to remove a Post (Note)
     *
     * @param id id as a parameter
     * @return returns a string
     */
    String delete(Long id);

    /**
     * deleteAll method to remove all the Posts (Notes)
     *
     * @return returns a string
     */
    String deleteAll();

    /**
     * list method to fetch all the Posts (Notes)
     *
     * @return returns a list of Post (Note) via NoteDTO
     */
    List<NoteDTO> list();
}

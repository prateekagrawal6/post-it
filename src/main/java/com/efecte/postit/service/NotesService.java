package com.efecte.postit.service;

import com.efecte.postit.dto.NoteDTO;

import java.util.List;

public interface NotesService {
    NoteDTO create(NoteDTO note);

    NoteDTO get(Long id);

    NoteDTO update(NoteDTO note);

    String delete(Long id);

    String deleteAll();

    List<NoteDTO> list();
}

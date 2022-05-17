package com.efecte.postit.service.impl;

import com.efecte.postit.dto.NoteDTO;
import com.efecte.postit.model.Note;
import com.efecte.postit.repository.NotesRepository;
import com.efecte.postit.service.NotesService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepository notesRepository;

    @Override
    public NoteDTO create(@NotNull NoteDTO note) {
        Note _note = notesRepository.save(getNote(note));
        return getNoteDTO(_note);
    }

    @Override
    public NoteDTO get(@NotNull Long id) {
        Note note = notesRepository.getById(id);
        return getNoteDTO(note);
    }

    @Override
    public NoteDTO update(@NotNull NoteDTO note) {
        Note _note = notesRepository.save(getNote(note));
        return getNoteDTO(_note);
    }

    @Override
    public String delete(@NotNull Long id) {
        notesRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public List<NoteDTO> list() {
        List<NoteDTO> notes = new ArrayList<>();
        List<Note> notesList = notesRepository.findAll();
        if (!notesList.isEmpty())
            notes = notesList.stream().map(note -> new NoteDTO(note.getId(), note.getNote())).collect(Collectors.toList());
        return notes;
    }

    @Override
    public String deleteAll() {
        notesRepository.deleteAll();
        return "Deleted Successfully";
    }

    Note getNote(NoteDTO noteDTO) {
        Note note = new Note();
        if (noteDTO.getId() != null)
            note.setId(noteDTO.getId());
        note.setNote(noteDTO.getNote());
        return note;
    }

    NoteDTO getNoteDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setNote(note.getNote());
        return noteDTO;
    }
}

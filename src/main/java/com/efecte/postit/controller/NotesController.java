package com.efecte.postit.controller;

import com.efecte.postit.dto.NoteDTO;
import com.efecte.postit.service.NotesService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
@Slf4j
public class NotesController {

    @Autowired
    NotesService notesService;

    @PostMapping("/create")
    ResponseEntity<NoteDTO> create(@RequestBody NoteDTO noteDTO) {
        log.info("Create request received with data {}", noteDTO);
        NoteDTO note = notesService.create(noteDTO);
        log.info("Create request served successfully with data {}", note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<NoteDTO> get(@NotNull @PathVariable("id") long id) {
        log.info("Get request received with data {}", id);
        NoteDTO note = notesService.get(id);
        log.info("Get request served with response {}", note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("update")
    ResponseEntity<NoteDTO> update(@NotNull @RequestBody NoteDTO noteDTO) {
        log.info("Update request received with data {}", noteDTO);
        NoteDTO note = notesService.update(noteDTO);
        log.info("Update request served with data {}", note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<HttpStatus> delete(@NotNull @PathVariable("id") long id) {
        log.info("Delete request received with data {}", id);
        notesService.delete(id);
        log.info("Delete request served successfully for id {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/")
    ResponseEntity<HttpStatus> deleteAll() {
        log.info("Delete All request received");
        notesService.deleteAll();
        log.info("Delete All request served successfully");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    ResponseEntity<List<NoteDTO>> list() {
        ResponseEntity<List<NoteDTO>> response;
        log.info("Default list request received");
        List<NoteDTO> list = notesService.list();
        log.info("List request served successfully with list {}", list);
        if (list.isEmpty()) {
            response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(list, HttpStatus.OK);
        }
        return response;
    }
}

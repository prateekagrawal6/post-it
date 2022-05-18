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

/**
 * NotesController to handle or control the requests for a Post (Note)
 */
@RestController
@RequestMapping("note")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {

    /**
     * notesService bean to access the service
     */
    @Autowired
    NotesService notesService;

    /**
     * create method to handle a HTTPPost request of a Post (Note) creation
     * @param noteDTO as a parameter
     * @return  returns a response entity with NoteDTO
     */
    @PostMapping("/create")
    ResponseEntity<NoteDTO> create(@RequestBody NoteDTO noteDTO) {
        log.info("Create request received with data {}", noteDTO);
        NoteDTO note = notesService.create(noteDTO);
        log.info("Create request served successfully with data {}", note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    /**
     * get method to handle a HTTPGet request to fetch a Post (Note)
     * @param id id as a parameter
     * @return  returns a response entity with NoteDTO
     */
    @GetMapping("{id}")
    ResponseEntity<NoteDTO> get(@NotNull @PathVariable("id") long id) {
        log.info("Get request received with data {}", id);
        NoteDTO note = notesService.get(id);
        log.info("Get request served with response {}", note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * update method to handle HTTPPut request of a Post (Note)
     * @param noteDTO noteDTO as a parameter
     * @return  returns an updated NoteDTO
     */
    @PutMapping("update")
    ResponseEntity<NoteDTO> update(@NotNull @RequestBody NoteDTO noteDTO) {
        log.info("Update request received with data {}", noteDTO);
        NoteDTO note = notesService.update(noteDTO);
        log.info("Update request served with data {}", note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * delete method to handle HTTPDelete request of a Post (Note)
     * @param id id as a parameter
     * @return  returns a response entity with an HttpStatus
     */
    @DeleteMapping("{id}")
    ResponseEntity<HttpStatus> delete(@NotNull @PathVariable("id") long id) {
        log.info("Delete request received with data {}", id);
        notesService.delete(id);
        log.info("Delete request served successfully for id {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * deleteAll method to handle HTTPDelete request of a Post (Note)
     * @return returns a response entity with an HttpStatus
     */
    @DeleteMapping("/")
    ResponseEntity<HttpStatus> deleteAll() {
        log.info("Delete All request received");
        notesService.deleteAll();
        log.info("Delete All request served successfully");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * list method to handle HTTPGet request of a Post (Note)
     * @return  returns a response entity with a list of NoteDTO
     */
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

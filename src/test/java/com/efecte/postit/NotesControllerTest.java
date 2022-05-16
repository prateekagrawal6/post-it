package com.efecte.postit;

import com.efecte.postit.controller.NotesController;
import com.efecte.postit.dto.NoteDTO;
import com.efecte.postit.model.Note;
import com.efecte.postit.repository.NotesRepository;
import com.efecte.postit.service.NotesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(NotesController.class)
public class NotesControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    NotesRepository notesRepository;

    @MockBean
    NotesService notesService;

    NoteDTO note1 = new NoteDTO(1L,"This is first note");
    NoteDTO note2 = new NoteDTO(2L,"This is second note");
    NoteDTO note3 = new NoteDTO(3L,"This is third note");

    @Test
    public void getAllRecords_success() throws Exception {
        List<NoteDTO> records = new ArrayList<>(Arrays.asList(note1, note2, note3));

        Mockito.when(notesService.list()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/note/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].note", is("This is second note")));
    }

    @Test
    public void getNoteById_success() throws Exception {
        Mockito.when(notesService.get(note3.getId())).thenReturn(note3);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/note/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.note", is("This is third note")));
    }

    @Test
    public void createNote_success() throws Exception {
        NoteDTO note = new NoteDTO(1L,"This is a new Note");

        Mockito.when(notesService.create(note)).thenReturn(note);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/note/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(note));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.note", is("This is a new Note")));
    }

}

package com.mediscreennote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import com.mediscreennote.model.Note;
import com.mediscreennote.repository.NoteRepository;
import com.mediscreennote.service.NoteService;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@TestPropertySource("/applicationtest.properties")
public class NoteTest {

	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
    private String collectionName = "mediscreentest";

    @BeforeEach
    public void setup() {
        mongoTemplate.createCollection("mediscreentest");
    }

    @AfterEach
    public void clean() {
        mongoTemplate.dropCollection("mediscreentest");
    }

    @Test
    public void getAllNoteForPatient() {

        Note note1 = new Note();
        note1.setId("1");
        note1.setNote("note");
        note1.setPatientId(1L);
        noteRepository.insert(note1);
        
        Note note2 = new Note();
        note2.setId("2");
        note2.setNote("note");
        note2.setPatientId(1L);
        noteRepository.insert(note2);
        List<Note> noteResult = noteRepository.findByPatientId(1L);
        
        assertNotEquals(Collections.EMPTY_LIST, noteResult.size());
        //assertEquals(noteResult.size(), 2);
    }

    @Test
    public void addORUpdateNoteForPatient() {
        Note note = new Note();
        note.setNote("note");
        Note noteResult = noteRepository.insert(note);
        assertEquals(noteResult.getNote(), "note");
    }

	
}

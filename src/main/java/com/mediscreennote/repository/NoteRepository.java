package com.mediscreennote.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mediscreennote.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
	public List<Note> findByPatientId(Long patientId);
}

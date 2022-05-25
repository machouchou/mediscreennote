package com.mediscreennote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
public class Note {
	
	@Id
    private String id;
	
	@Indexed
    private Long patientId;
   
    private String note;
    
	public Note() {
		super();
	}

	public Note(Long patientId, String note) {
		super();
		this.patientId = patientId;
		this.note = note;
	}

	public Note(String id, Long patientId, String note) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "PatientNote [id=" + id + ", patientId=" + patientId + ", note=" + note + "]";
	}

}

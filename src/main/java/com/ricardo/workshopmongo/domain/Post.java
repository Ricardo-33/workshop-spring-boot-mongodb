package com.ricardo.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ricardo.workshopmongo.dto.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "post")
@Data
@AllArgsConstructor
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
}

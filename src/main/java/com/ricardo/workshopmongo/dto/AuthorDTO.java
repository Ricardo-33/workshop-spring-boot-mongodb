package com.ricardo.workshopmongo.dto;

import java.io.Serializable;

import com.ricardo.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
}

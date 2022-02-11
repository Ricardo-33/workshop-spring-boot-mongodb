package com.ricardo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.workshopmongo.domain.User;
import com.ricardo.workshopmongo.dto.UserDTO;
import com.ricardo.workshopmongo.repository.UserRepository;
import com.ricardo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	// Inclusão de um novo User pelo POST
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
	// Deleção de um User pelo DELETE
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	// Atualização de um User pelo UPDATE
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	// Conversão de um UserDTO para User para fazer o POST de um USER
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}

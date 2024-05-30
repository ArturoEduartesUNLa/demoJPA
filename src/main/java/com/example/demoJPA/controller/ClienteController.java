package com.example.demoJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoJPA.entity.Cliente;
import com.example.demoJPA.repository.IClienteRepository;

@Controller // This means that this class is a Controller
@RequestMapping("/demoJPA/Cliente")
public class ClienteController {

	@Autowired
	private IClienteRepository clienteRepo;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCliente(@RequestParam String premium) {

		Cliente n = new Cliente();
		n.setClientePremium(Boolean.parseBoolean(premium));
		n = clienteRepo.save(n);
		return "Saved " + n.getId();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Cliente> getAllUsers() {
		// This returns a JSON or XML with the users
		return clienteRepo.findAll();
	}
}
/*
 * Ejemplo de como probar la funcionalidad
 * desde una consola de comandos DOS o Bash ejecutar pasando los parametros definidos
 * en el metodo asociado al controlador:
 * curl http://localhost:8080/demoJPA/PedidoCompra/add -d fechaL=2024-05-29 -d comprado=true -d cantS=200 -d producto=2
 */
package com.example.demoJPA.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoJPA.entity.PedidoCompra;
import com.example.demoJPA.repository.IPedidoCompraRepository;
import com.example.demoJPA.repository.IProductoRepository;

@Controller // This means that this class is a Controller
@RequestMapping("/demoJPA/PedidoCompra")
public class PedidoCompraController {

	@Autowired
	private IPedidoCompraRepository pedComRepo;

	@Autowired
	private IProductoRepository prodRepo;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewPedCompra(@RequestParam LocalDate fechaL, @RequestParam boolean comprado,
			@RequestParam int cantS, @RequestParam int producto) {

		PedidoCompra n = new PedidoCompra();
		n.setFechaLanzamiento(fechaL);
		n.setComprado(comprado);
		n.setCantidadSolicitada(cantS);
		n.setProducto(prodRepo.getReferenceById(producto));

		n = pedComRepo.save(n);
		return "Saved " + n.getId() + " " + n.getCantidadSolicitada();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<PedidoCompra> getAllUsers() {
		// This returns a JSON or XML with the users
		return pedComRepo.findAll();
	}
}
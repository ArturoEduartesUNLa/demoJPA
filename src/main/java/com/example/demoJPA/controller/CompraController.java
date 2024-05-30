/*
 * Ejemplo de como probar la funcionalidad
 * desde una consola de comandos DOS o Bash ejecutar pasando los parametros definidos
 * en el metodo asociado al controlador:
 * curl http://localhost:8080/demoJPA/Compra/add -d fechaE=2024-05-29
 * -d fechaL=2024-05-30 -d proveed="La Araucana" -d cant=200 -d pedCom=2
 *  
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

import com.example.demoJPA.entity.Compra;
import com.example.demoJPA.repository.ICompraRepository;
import com.example.demoJPA.repository.IPedidoCompraRepository;

@Controller // This means that this class is a Controller
@RequestMapping("/demoJPA/Compra")
public class CompraController {

	@Autowired
	private ICompraRepository compraRepo;
	@Autowired
	private IPedidoCompraRepository pedComRepo;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCompra(@RequestParam LocalDate fechaE, @RequestParam LocalDate fechaL,
			@RequestParam String proveed, @RequestParam int cant, @RequestParam int pedCom) {

		Compra n = new Compra();
		n.setFechaEntrega(fechaE);
		n.setFechaLanzamiento(fechaL);
		n.setProveedor(proveed);
		n.setPedidoCompra(pedComRepo.getReferenceById(pedCom));
		n.setCantidadComprada(cant);

		n = compraRepo.save(n);
		return "Saved " + n.getId() + " " + n.getCantidadComprada();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Compra> getAllUsers() {
		// This returns a JSON or XML with the users
		return compraRepo.findAll();
	}
}

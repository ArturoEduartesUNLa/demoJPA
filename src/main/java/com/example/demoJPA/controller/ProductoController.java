/*
 * Ejemplo de como probar la funcionalidad
 * desde una consola de comandos DOS o Bash ejecutar pasando los parametros definidos
 * en el metodo asociado al controlador:
 * curl http://localhost:8080/demoJPA/Producto/add -d name="Lina Ato" -d desc="Muy Importante" 
 * -d tipo=Perrita -d stockRest=200 -d precio=12345678.23 -d activo=true
 *  
 */

package com.example.demoJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoJPA.entity.Producto;
import com.example.demoJPA.repository.IProductoRepository;

@Controller // This means that this class is a Controller
@RequestMapping("/demoJPA/Producto")
public class ProductoController {

	@Autowired
	private IProductoRepository prodRepo;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewProducto(@RequestParam String name, @RequestParam String desc,
			@RequestParam String tipo, @RequestParam int stockRest, @RequestParam double precio,
			@RequestParam boolean activo) {

		Producto n = new Producto();
		n.setNombre(name);
		n.setDescripcion(desc);
		n.setTipo(tipo);
		n.setStockRestante(stockRest);
		n.setPrecio(precio);
		n.setActivo(activo);

		n = prodRepo.save(n);
		return "Saved " + n.getId() + " " + n.getNombre();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Producto> getAllUsers() {
		// This returns a JSON or XML with the users
		return prodRepo.findAll();
	}
}
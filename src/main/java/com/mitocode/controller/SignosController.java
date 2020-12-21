package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Signos;
import com.mitocode.service.ISignosService;

@RestController
@RequestMapping("/signos")
public class SignosController {

	@Autowired
	private ISignosService signosService;
	
	
	@GetMapping
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	public ResponseEntity<List<Signos>> listar() throws Exception {
		List<Signos> lista = this.signosService.listar();
		return new ResponseEntity<List<Signos>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Signos> registrar(@Valid @RequestBody Signos signos) throws Exception {
		Signos obj = this.signosService.registrar(signos);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getSignosId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Signos> modificar(@Valid @RequestBody Signos signos) throws Exception {
		Signos obj = this.signosService.modificar(signos);
		return new ResponseEntity<Signos>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Signos obj = this.signosService.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		this.signosService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

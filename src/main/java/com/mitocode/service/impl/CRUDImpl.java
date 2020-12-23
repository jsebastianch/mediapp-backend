package com.mitocode.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T registrar(T t) throws Exception {
		try {
			return getRepo().save(t);
		} catch (DataIntegrityViolationException e) {
			String errorMessage = e.getCause().getCause().getMessage();
			String detailMessage = errorMessage.indexOf("Detail: ") >= 0
					? errorMessage.substring(errorMessage.indexOf("Detail: ") + 8)
					: "";
			throw new Exception("Error de llave duplicada: " + detailMessage);
		}

	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}

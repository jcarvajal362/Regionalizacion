package com.regionalizacion.app.dao.service;

import java.util.List;
import java.util.Optional;

import com.regionalizacion.app.entity.Rol;
import com.regionalizacion.app.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	public Usuario save(Usuario u);
	
	public List<Usuario> listar();
	
	public Optional<Usuario> listarId(Long id);
	
	public void delete (Long id);
	
	public List<Rol> findAll();
}

package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.regionalizacion.app.dao.IRolDao;
import com.regionalizacion.app.dao.IUsuarioDao;
import com.regionalizacion.app.dao.service.IUsuarioService;
import com.regionalizacion.app.entity.Rol;
import com.regionalizacion.app.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired 
	private IRolDao rolDao;

	@Override
	public Usuario findByUsername(String username) {

		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario save(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioDao.save(u);
	}

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Optional<Usuario> listarId(Long id) {
		return usuarioDao.findById(id);
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);

	}

	@Override
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}
}

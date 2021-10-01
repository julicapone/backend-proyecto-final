package com.capone.clinica.service;

import com.capone.clinica.model.Rol;
import com.capone.clinica.model.Usuario;
import com.capone.clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

       Optional<Usuario> usuario = usuarioRepository.traerUsuarioPorNombre(s);
       Set<GrantedAuthority> autorizaciones = new HashSet<>();
       for(Rol rol: usuario.get().getRoles())
       {
           GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getNombre());
           autorizaciones.add(autorizacion);
       }

       return new User(usuario.get().getNombre(),"{noop}" + usuario.get().getContrasenia(),true,true,true,true,autorizaciones);
    }
}

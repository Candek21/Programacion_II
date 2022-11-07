package Candela_Grosso.Centro_medico.Service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
public interface Servicio_usuario extends UserDetailsService {
    @Override
    public default UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        //Role rol = new Role("USER", null);
        GrantedAuthority autorizacionUSER = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority autorizacionADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
        autorizaciones.add(autorizacionUSER);
        autorizaciones.add(autorizacionADMIN);

        User user = new  User("candela","{noop}1234",true,true,true,true,autorizaciones);

        return user;
    }
}

package Candela_Grosso.Centro_medico.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class Servicio_user implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacionUser = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority autorizacionAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
        autorizaciones.add(autorizacionUser);
        autorizaciones.add(autorizacionAdmin);
        User user = new User("Candela", "{noop}candela",true,true,true,true, autorizaciones);
        return user;
    }
}

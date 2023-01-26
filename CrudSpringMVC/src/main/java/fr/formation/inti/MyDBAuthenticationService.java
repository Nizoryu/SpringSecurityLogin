package fr.formation.inti;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.inti.service.UserService;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

	@Autowired
	private UserService userserv;

		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			System.out.println("method loadUserByUsername");	
			fr.formation.inti.entity.User u = userserv.findByUniqueEmail(email);
			if (u == null) {
				throw new UsernameNotFoundException("User " + email + " n'est pas dans la bd");
			}
			System.out.println("role: "+u.getRoleName());

		// [USER,ADMIN,..]
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		// ROLE_USER, ROLE_ADMIN,..
		// SUPERADMIN = ADMIN ET USER
		if ("SUPERADMIN".equals(u.getRoleName())) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_SUPERADMIN");
			grantList.add(authority);
			authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			grantList.add(authority);
		}else if("ADMIN".equals(u.getRoleName())) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			grantList.add(authority);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		grantList.add(authority);  
		UserDetails userDetails = (UserDetails) new User(u.getFirstName(), //
				u.getPassword(), grantList);

		return userDetails;
	}

}

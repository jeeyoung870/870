package sec.user;

import java.util.Arrays;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Setter
public class UserJoinService {

	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder;

	/*
	 * public UserJoinService() { passwordEncoder =
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	@Transactional
	public void join(NewUser newUser) {
		//비번 암호화
		String password = passwordEncoder.encode(newUser.getPassword());
		UserDetails user = new User(newUser.getName(), password,
				Arrays.asList(new SimpleGrantedAuthority("USER")));
		try {
			userDetailsManager.createUser(user);
			//"insert into users (username, password, enabled) values (?,?,?)"
			//"insert into authorities (username, authority) values (?,?)" 자동 실행
		}catch(DuplicateKeyException ex) {
			throw new DuplicateUsernameException(
					String.format("Username [%s] is already exists.", newUser.getName()), ex);
		}
	}
}

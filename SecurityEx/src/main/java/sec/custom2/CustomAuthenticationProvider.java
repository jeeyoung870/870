package sec.custom2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sec.custom.UserInfo;
import sec.custom.UserPermission;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// Authentication을 지원하는 타입으로 변환
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		//사용자 정보를 조회. 존재하지 않으면 예외 발생
		UserInfo userInfo = findUserById(authToken.getName());
		if (userInfo == null) {
			throw new UsernameNotFoundException(authToken.getName());
		}

		// 조회한 사용자와 파라미터로 받은 Authentication의 암호 비교
		//암호가 일치하지 않으면 예외발생
		if (!matchPassword(userInfo.getPassword(), authToken.getCredentials())) {
			throw new BadCredentialsException("not matching username or password");
		}
		//사용자가 가진 권한 목록 구하기
		List<GrantedAuthority> authorities = getAuthorities(userInfo.getId());
		//인증된 사용자에 대한 Authentication 객체를 생성해서 리턴
		return new UsernamePasswordAuthenticationToken(
				new UserInfo(userInfo.getId(), userInfo.getName(), null),
				null,
				authorities);
	}

	private UserInfo findUserById(String id) {
		//id에 해당하는 정보를 읽어와 리턴
		return userMap.get(id);
	}

	private List<GrantedAuthority> getAuthorities(String id) {
		//id가 갖고 있는 권한 정보 로딩 및 생성하는 코드
		List<UserPermission> perms = permMap.get(id);
		if (perms == null)
			return Collections.emptyList();

		List<GrantedAuthority> authorities = new ArrayList<>(perms.size());
		for (UserPermission perm : perms) {
			authorities.add(new SimpleGrantedAuthority(perm.getName()));
		}
		return authorities;
	}

	private boolean matchPassword(String password, Object credentials) {
		return password.equals(credentials);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	private Map<String, UserInfo> userMap = new HashMap<>();
	private Map<String, List<UserPermission>> permMap = new HashMap<>();

	public CustomAuthenticationProvider() {
		userMap.put("cron", new UserInfo("cron", "스케줄러", "cronpw"));
		permMap.put("cron", Arrays.asList(new UserPermission(1L, "SCHEDULER")));
	}

}

package hils.Register.Service;

import org.springframework.stereotype.Service;

import hils.Register.Model.RegisterDto;

@Service
public interface RegisterService {
	// 회원 가입
	public void register(RegisterDto regiDto) throws Exception;

	// 회원 가입
	public void register2(RegisterDto regiDto) throws Exception;

	// 아이디 중복 체크
	public int idCheck(RegisterDto regiDto) throws Exception;

	// 이메일 중복 체크
	public int emailCheck(RegisterDto regiDto) throws Exception;
}

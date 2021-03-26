package hils.Register.Service;

import org.springframework.stereotype.Service;

import hils.Register.Model.RegisterDto;

@Service
public interface RegisterService {
	public void register(RegisterDto regiDto) throws Exception;
}

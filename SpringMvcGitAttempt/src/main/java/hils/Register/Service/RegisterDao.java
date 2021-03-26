package hils.Register.Service;

import hils.Register.Model.RegisterDto;

public interface RegisterDao {
	public void register(RegisterDto regiDto) throws Exception;
}

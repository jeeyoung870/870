package hils.Register.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.Register.Model.RegisterDto;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao regiDao;

	public RegisterDao getRegiDao() {
		return regiDao;
	}

	public void setRegiDao(RegisterDao regiDao) {
		this.regiDao = regiDao;
	}

	@Override
	public void register(RegisterDto regiDto) throws Exception {
		regiDao.register(regiDto);
	}

}
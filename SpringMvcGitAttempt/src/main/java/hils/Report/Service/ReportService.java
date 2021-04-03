package hils.Report.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.Report.Model.ReportDto;

@Service
public class ReportService {

	@Autowired
	private ReportDao ReportDao;

	public List<ReportDto> selectReport() throws Exception {
		return ReportDao.selectReport();
	}

	public void deleteMethod(String delete) {
		ReportDao.deleteMethod(delete);
	}

	public void writeMethod(ReportDto write) {
		ReportDao.writeMethod(write);
	}
}

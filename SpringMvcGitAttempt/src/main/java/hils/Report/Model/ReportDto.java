package hils.Report.Model;

import java.util.Date;

public class ReportDto {
	private String r_number;
	private String reported_user;
	private String r_content;
	private String reporter_user;
	private Date r_reg_date;
	private int punished;  // DB에서는 디폴트로 0 설정 할 것.

	public String getR_number() {
		return r_number;
	}

	public void setR_number(String r_number) {
		this.r_number = r_number;
	}

	public String getReported_user() {
		return reported_user;
	}

	public void setReported_user(String reported_user) {
		this.reported_user = reported_user;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getReporter_user() {
		return reporter_user;
	}

	public void setReporter_user(String reporter_user) {
		this.reporter_user = reporter_user;
	}

	public Date getR_reg_date() {
		return r_reg_date;
	}

	public void setR_reg_date(Date r_reg_date) {
		this.r_reg_date = r_reg_date;
	}

	public int getPunished() {
		return punished;
	}

	public void setPunished(int punished) {
		this.punished = punished;
	}
}

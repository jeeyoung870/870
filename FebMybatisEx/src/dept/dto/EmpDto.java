package dept.dto;

import java.sql.Date;

public class EmpDto {
	private String ename;
	private int empno;
	private Date hiredate;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	@Override
	public String toString() {
		return "EmpDto [ename=" + ename + ", empno=" + empno + ", hiredate=" + hiredate + "]\n";
	}
	
	
	
}

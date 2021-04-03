package hils.notification.model;

import java.util.Date;

public class CommentNotiDto {
	private String replyWriter;
	private String boardWriter;
	private int b_number;
	private String b_subjet;
	private Date comment_reg_date;
	
	
	public String getB_subjet() {
		return b_subjet;
	}
	public void setB_subjet(String b_subjet) {
		this.b_subjet = b_subjet;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public Date getComment_reg_date() {
		return comment_reg_date;
	}
	public void setComment_reg_date(Date comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}
	
}

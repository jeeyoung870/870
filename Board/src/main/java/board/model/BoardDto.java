package board.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int num; 
    private String writer;
    private String subject;
    private String content;
    private String passwd;
    private Timestamp reg_date;
    private int readcount;
    private String ip;
    private int ref;
    private int re_step;	
    private int re_level;
}

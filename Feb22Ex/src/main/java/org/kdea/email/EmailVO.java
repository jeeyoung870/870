package org.kdea.email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailVO {

	 private String subject;
    private String content;
    private String date;
    private String receiver;
}

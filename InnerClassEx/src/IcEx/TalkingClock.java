package IcEx;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.Timer;



public class TalkingClock {
	private int interval;
	private boolean beep;
	public TalkingClock () {
	}
	
	public void start(int interval, boolean beep) {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone, the time is " + new Date());
				if (beep) {
					System.out.println("Beep!");
					Toolkit.getDefaultToolkit().beep();
				}
			}
		};
	}
}

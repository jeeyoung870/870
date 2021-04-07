package IcEx;

import javax.swing.JOptionPane;

public class TalkingClockEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock tk = new TalkingClock();
		tk.start(100, true);
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);

	}

}

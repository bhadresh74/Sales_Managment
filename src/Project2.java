import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Project2 extends JFrame implements ActionListener {
	Timer t;
	Clock f = new Clock();
	public Project2() {
		t = new Timer(1000, this); // 1000 millisecond timer with this as it's ActionListener
		t.start();
		f.setTitle("Clock Program");
		
		f.setSize(300, 300);
		f.setVisible(true);
        }
	
	public static void main(String[] args) {
		new Project2();		
	}

	public void actionPerformed(ActionEvent e) {
		       f.setContentPane(f.createContentPane());
                       System.out.println("s");
	}
}
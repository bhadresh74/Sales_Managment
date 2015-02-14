import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Clock extends JFrame
{
	Date date = new Date();
	Font font = new Font("Serif", Font.PLAIN, 20);

	JLabel lblLabel = new JLabel("The current date and time is: ");
	JLabel lblDate = new JLabel(""+date+"");

	//Sets up Frame and Panels
	public Container createContentPane()
	{
		JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			//northPanel.add();		This is where the header image should go

		JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			centerPanel.add(lblLabel);

		JPanel southPanel = new JPanel();
			southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			southPanel.add(lblDate);

		Container c = getContentPane();
			c.setLayout(new BorderLayout(10,15));
			c.add(centerPanel, BorderLayout.CENTER);
			c.add(southPanel, BorderLayout.SOUTH);

		return c;
	}

	public static void main(String[] args)
	{

		Clock f = new Clock();
		f.setTitle("Clock Program");
		f.setContentPane(f.createContentPane());
		f.setSize(300, 300);
		f.setVisible(true);

	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class WhackaMole implements ActionListener{
	static int r = 0;
	Date timeAtStart= new Date();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton moleButton = new JButton("Mole");
	public static void main(String[] args) {
		new WhackaMole().notCreateUI();
	}


void notCreateUI() {
	frame.add(panel);
	Random s = new Random();
	int moleLocation = s.nextInt(24);
	
	for(int i = 0; i<24; i++) {
		if (i==moleLocation) {
			moleButton.addActionListener(this);
			panel.add(moleButton);
		}
		else {
		JButton button = new JButton();
		button.addActionListener(this);
		panel.add(button);
		}
		
	}
	frame.setSize(300,350);
	frame.setVisible(true);
	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==moleButton) {
		if (r==9) {
			endGame( timeAtStart,  r+1);
		}else {
		System.out.println("It's a mole!");
		frame.dispose();
		new WhackaMole().notCreateUI();
		r++;
		}
	}else {
		speak("Not a mole!");
	}
}
void speak(String words) { 
    try { 
        Runtime.getRuntime().exec("say " + words).waitFor();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void endGame(Date timeAtStart, int molesWhacked) { 
    Date timeAtEnd = new Date();
    JOptionPane.showMessageDialog(null, "Your whack rate is "
            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                  + " moles per second.");
}}

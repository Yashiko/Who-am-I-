package apps;
import javax.swing.*;


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.applet.*;
import java.util.Timer;  
import java.util.TimerTask;  


public class WhoAmI extends JPanel implements ActionListener{
	JFrame f;
	JButton b;	
	Image img, img2;
	ImageIcon image;
	JLabel displayLabel, LabelName, labelTimer;
	String[] list = {"cat","dog","cow","horse"};
	String[] list2 = {"bone","moto","house","cow"};
	String[] list3 = {"boy","men","tree","girl"};
	ButtonGroup bg = new ButtonGroup();
	JRadioButton[] radio = new JRadioButton[4];
	JRadioButton[] radio2 = new JRadioButton[4];
	JRadioButton[] radio3 = new JRadioButton[4];
	String Picture1 = "D:\\cat.png";
	String Picture2 = "D:\\house.jpg";
	Timer timer;
	TimerTask task;
		WhoAmI(){
			f = new JFrame();
			String name=JOptionPane.showInputDialog(f,"Enter your name");  
			LabelName = new JLabel("Player: "+name);
			LabelName.setBounds(20, 20, 100, 20);
			labelTimer = new JLabel("Time: ");
			labelTimer.setBounds(120, 20, 100, 20);
			f.add(LabelName);
			f.add(labelTimer);
			int y = 60;
			for (int i =0; i<radio.length; i++, y +=50) {
				radio[i] = new JRadioButton(list[i]);
				radio[i].setText(list[i]);
				radio[i].setBounds(20, y , 160, 30);
				f.add(radio[i]);
				bg.add(radio[i]);
			}
			b = new JButton("Next");
			b.setBounds(200, 250, 100, 30);
			f.add(b);
			ImageIcon image = new ImageIcon("D:\\cat.png");//create an image icon
			f.setIconImage(image.getImage());
			displayLabel = new JLabel("", image, JLabel.CENTER);
			displayLabel.setBounds(180,60,250,180);
			f.add(displayLabel);
			b.addActionListener(this); 
			f.setTitle("Who am I?");
			f.setBounds(500,350,500,400);
			f.setLayout(null);
			f.setVisible(true);
			timer = new Timer();
			task = new TimerTask() {
				int i = 20;
				public void run() {
					if (i >0) {
						System.out.println(i);
						i--;
						labelTimer.setText("TIme: "+i);
						if (i ==0) {
							JOptionPane.showMessageDialog(f,"Game over");
						}
					}	
				}
			};
			timer.scheduleAtFixedRate(task, 0, 1000); 
		}
	
		public void actionPerformed(ActionEvent e){  
				if(radio[0].isSelected()) {
					displayLabel.setVisible(false);
					ImageIcon image1 = new ImageIcon("D:\\house.jpg");//create an image icon
					 f.setIconImage(image1.getImage());
					 displayLabel = new JLabel("", image1, JLabel.CENTER);
					 displayLabel.setBounds(180,60,250,180);
					 f.add(displayLabel);
					int y = 60;
					for (int i =0; i<radio2.length; i++, y +=50) {
						radio[i].setVisible(false);
						radio2[i] = new JRadioButton(list2[i]);
						radio2[i].setText(list2[i]);
						radio2[i].setBounds(20, y , 60, 30);
						 f.add(radio2[i]);
						 bg.add(radio2[i]);				
					}
					
				}

				if(radio2[2].isSelected()) {
					displayLabel.setVisible(false);
					ImageIcon image2 = new ImageIcon("D:\\human.png");//create an image icon
					 f.setIconImage(image2.getImage());
					 displayLabel = new JLabel("", image2, JLabel.CENTER);
					 displayLabel.setBounds(180,60,250,180);
					 f.add(displayLabel);
					int d = 60;
					for (int i =0; i<radio3.length; i++, d +=50) {
						radio2[i].setVisible(false);
						radio3[i] = new JRadioButton(list3[i]);
						radio3[i].setText(list3[i]);
						radio3[i].setBounds(20, d , 60, 30);
						 f.add(radio3[i]);
						 bg.add(radio3[i]);				
					}	

				}

				if(radio3[3].isSelected()) {	
					JOptionPane.showMessageDialog(f,"YOU ARE THE WINNER");
				}
		}  

	public static void main(String[] args) {
		new WhoAmI();
	}

}

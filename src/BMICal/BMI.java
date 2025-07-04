package BMICal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMI {
double h;
double w;
double b;
String r;
String category;
String dietPlan = "";


private JFrame frame;
private JTextField texth;
private JTextField textw;
private JTextField textb;
/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				BMI window = new BMI();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the application.
 */
public BMI() {
	initialize();
}

/**
 * Initialize the contents of the frame.
 */
   private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 500, 650);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.getContentPane().setLayout(null);
	frame.setTitle("BMI");

  
	JLabel lblNewLabel = new JLabel("BODY MASS INDEX CALCULATOR");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setBounds(56, 32, 363, 54);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Height (in meters) :");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel_1.setBounds(25, 120, 168, 40);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Weight (in KG) :");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel_2.setBounds(33, 209, 168, 27);
	frame.getContentPane().add(lblNewLabel_2);
	
	texth = new JTextField();
	texth.setBounds(228, 128, 160, 32);
	frame.getContentPane().add(texth);
	texth.setColumns(10);
	
	textw = new JTextField();
	textw.setBounds(228, 209, 160, 32);
	frame.getContentPane().add(textw);
	textw.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("BMI :");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel_3.setBounds(88, 298, 45, 40);
	frame.getContentPane().add(lblNewLabel_3);
	
	textb = new JTextField();
	textb.setBounds(228, 298, 160, 32);
	frame.getContentPane().add(textb);
	textb.setColumns(10);
	textb.setEditable(false);
	
	JButton btnC = new JButton("Calculate");
			//h = Double.parseDouble(texth.getText());
			//w = Double.parseDouble(textw.getText());
			//b= w/(h*h);
			//r=String.format("%.2f",b);
			//textb.setText(r);
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						h = Double.parseDouble(texth.getText());
						w = Double.parseDouble(textw.getText());

						if (h <= 0 || w <= 0) {
							throw new NumberFormatException();
						}

						b = w / (h * h);
						r = String.format("%.2f", b);
						textb.setText(r);
						
						if (b < 18.5)
							{
							category = "Underweight";
							}
						else if (b < 24.9) 
							{
							category = "Normal";
							}
						else if (b < 29.9)
							{
							category = "Overweight";
							}
						else {
							category = "Obese";
						}
						javax.swing.JOptionPane.showMessageDialog(frame, "Your BMI is " + r + " (" + category + ")");
					} 
					catch (NumberFormatException ex) {
						javax.swing.JOptionPane.showMessageDialog(frame, "Please enter valid positive numbers for height and weight.", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);				
		}

		}
	});
	btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnC.setBounds(56, 375, 131, 43);
	frame.getContentPane().add(btnC);
	
	JButton Reset = new JButton("Reset");
	Reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			texth.setText(null);
			textb.setText(null);
			textw.setText(null);
		}
	});
	Reset.setFont(new Font("Tahoma", Font.BOLD, 16));
	Reset.setBounds(295, 375, 131, 43);
	frame.getContentPane().add(Reset);
	
	JButton btnNewButton = new JButton("Diet Plan");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			switch (category) {
			    case "Underweight":
			        dietPlan = "Include more calories and protein-rich foods:\n- Whole milk\n- Nuts & seeds\n- Rice, potatoes\n- Peanut butter\n- Eggs & lean meats";
			        break;
			    case "Normal":
			        dietPlan = "Maintain a balanced diet:\n- Fruits & vegetables\n- Whole grains\n- Moderate dairy and lean protein\n- Stay active";
			        break;
			    case "Overweight":
			        dietPlan = "Focus on portion control and fiber:\n- Vegetables & legumes\n- Limit sugars and fried foods\n- Drink water\n- Regular exercise";
			        break;
			    case "Obese":
			        dietPlan = "Adopt a low-calorie, high-nutrient plan:\n- Leafy greens\n- Low-fat dairy\n- Grilled protein\n- Avoid sugary drinks and snacks";
			        break;
			}

			javax.swing.JOptionPane.showMessageDialog(frame,  "Your BMI is " + r + " (" + category + ")\n\nRecommended Diet:\n" + dietPlan,"BMI & Diet Plan", javax.swing.JOptionPane.INFORMATION_MESSAGE);

		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton.setBounds(56, 462, 131, 43);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("New button");
	btnNewButton_1.setBounds(295, 462, 131, 43);
	frame.getContentPane().add(btnNewButton_1);
}

```

}

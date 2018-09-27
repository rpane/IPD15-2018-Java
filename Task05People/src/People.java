import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class People extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					People frame = new People();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public People() {
		setTitle("Person");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(85, 58, 31, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(126, 55, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(85, 83, 23, 14);
		contentPane.add(lblAge);
		
		JRadioButton rdbtnBelow = new JRadioButton("below 18");
		buttonGroup.add(rdbtnBelow);
		rdbtnBelow.setBounds(110, 79, 69, 23);
		contentPane.add(rdbtnBelow);
		
		JRadioButton radioButton = new JRadioButton("18-35");
		buttonGroup.add(radioButton);
		radioButton.setBounds(181, 79, 53, 23);
		contentPane.add(radioButton);
		
		JRadioButton rdbtnAndUp = new JRadioButton("36 and up");
		buttonGroup.add(rdbtnAndUp);
		rdbtnAndUp.setBounds(236, 79, 73, 23);
		contentPane.add(rdbtnAndUp);
		
		JLabel lblPets = new JLabel("Pets:");
		lblPets.setBounds(85, 108, 31, 14);
		contentPane.add(lblPets);
		
		JCheckBox chckbxCat = new JCheckBox("Cat");
		chckbxCat.setBounds(120, 105, 43, 23);
		contentPane.add(chckbxCat);
		
		JCheckBox chckbxDog = new JCheckBox("Dog");
		chckbxDog.setBounds(173, 105, 53, 23);
		contentPane.add(chckbxDog);
		
		JCheckBox chckbxOther = new JCheckBox("Other");
		chckbxOther.setBounds(229, 105, 53, 23);
		contentPane.add(chckbxOther);
		
		JLabel lblContinentOfResidence = new JLabel("Continent of residence");
		lblContinentOfResidence.setBounds(85, 139, 109, 14);
		contentPane.add(lblContinentOfResidence);
		
		JLabel lblPrefernedTempC = new JLabel("Preferred temp C");
		lblPrefernedTempC.setBounds(85, 164, 88, 14);
		contentPane.add(lblPrefernedTempC);
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(25);
		slider.setMinimum(15);
		slider.setMaximum(35);
		slider.setBounds(177, 164, 200, 26);
		contentPane.add(slider);
		

		JButton btnRegisterMe = new JButton("Register Me!");
		btnRegisterMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegisterMe.setBounds(85, 201, 94, 23);
		contentPane.add(btnRegisterMe);
		
		String[] messageStrings= {"Africa","Antarctica","Asia","Europe","North America","South America","Australia"};
		JComboBox comboBox = new JComboBox(messageStrings);
		comboBox.setBounds(204, 135, 73, 20);
		contentPane.add(comboBox);
	}
	public boolean getSliderPaintLabels() {
		return slider.getPaintLabels();
	}
	public void setSliderPaintLabels(boolean paintLabels) {
		slider.setPaintLabels(paintLabels);
	}
}

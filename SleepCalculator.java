import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SleepCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDay;
	private JTextField textFieldDayOne;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JTextField textFieldMonthOne;
	private JTextField textFieldYearOne;
	private JTextField textFieldDayAlive;
	private JTextField textFieldSleepHours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SleepCalculator frame = new SleepCalculator();
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
	public SleepCalculator() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 418, 310);
		contentPane.add(panel);
		panel.setLayout(null);

		//labels
		JLabel lblTitle = new JLabel("Sleep Calculator");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(146, 22, 112, 22);
		panel.add(lblTitle);

		JLabel lblBirthdate = new JLabel("Enter Your Birthdate");
		lblBirthdate.setBounds(37, 66, 127, 14);
		panel.add(lblBirthdate);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(37, 115, 48, 14);
		panel.add(lblDay);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(37, 151, 48, 14);
		panel.add(lblMonth);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(37, 189, 48, 14);
		panel.add(lblYear);

		JLabel lblDayOne = new JLabel("Day");
		lblDayOne.setBounds(222, 115, 48, 14);
		panel.add(lblDayOne);

		JLabel lblMonthOne = new JLabel("Month");
		lblMonthOne.setBounds(222, 151, 48, 14);
		panel.add(lblMonthOne);

		JLabel lblYearOne = new JLabel("Year");
		lblYearOne.setBounds(222, 189, 48, 14);
		panel.add(lblYearOne);

		JLabel lblToday = new JLabel("Enter Today's Date");
		lblToday.setBounds(222, 66, 127, 14);
		panel.add(lblToday);

		// creates text fields for input and output
		textFieldDay = new JTextField();
		textFieldDay.setBounds(95, 112, 58, 20);
		panel.add(textFieldDay);
		textFieldDay.setColumns(10);

		textFieldMonth = new JTextField();
		textFieldMonth.setBounds(95, 148, 58, 20);
		panel.add(textFieldMonth);
		textFieldMonth.setColumns(10);

		textFieldYear = new JTextField();
		textFieldYear.setBounds(95, 186, 58, 20);
		panel.add(textFieldYear);
		textFieldYear.setColumns(10);

		textFieldDayOne = new JTextField();
		textFieldDayOne.setBounds(275, 112, 58, 20);
		panel.add(textFieldDayOne);
		textFieldDayOne.setColumns(10);

		textFieldMonthOne = new JTextField();
		textFieldMonthOne.setBounds(275, 148, 58, 20);
		panel.add(textFieldMonthOne);
		textFieldMonthOne.setColumns(10);

		textFieldYearOne = new JTextField();
		textFieldYearOne.setBounds(275, 186, 58, 20);
		panel.add(textFieldYearOne);
		textFieldYearOne.setColumns(10);

		textFieldDayAlive = new JTextField();
		textFieldDayAlive.setBounds(162, 234, 211, 20);
		panel.add(textFieldDayAlive);
		textFieldDayAlive.setColumns(10);

		textFieldSleepHours = new JTextField();
		textFieldSleepHours.setBounds(162, 265, 211, 20);
		panel.add(textFieldSleepHours);
		textFieldSleepHours.setColumns(10);

		//button to calculate given input
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					//initializing variables
					String dayB, monthB, yearB, dayT, monthT, yearT; 
					int dayBc, monthBc, yearBc, dayTc, monthTc, yearTc, a, total=0, totalD=0, totalM=0, totalY=0;

					//input
					dayB = textFieldDay.getText();
					monthB = textFieldMonth.getText();
					yearB = textFieldYear.getText();
					dayT = textFieldDayOne.getText();
					monthT = textFieldMonthOne.getText();
					yearT = textFieldYearOne.getText();

					//converts string input to integer, also acts as an error checker
					dayBc = Integer.parseInt(dayB);
					monthBc = Integer.parseInt(monthB);
					yearBc = Integer.parseInt(yearB);
					dayTc = Integer.parseInt(dayT);
					monthTc = Integer.parseInt(monthT);
					yearTc = Integer.parseInt(yearT);

					//if year, month, or day is negative
					if(yearTc<0 || yearBc<0 || monthTc<0 || monthBc<0 || dayTc<0 || dayBc<0 || monthTc>12 || monthBc>12 || dayTc>30 || dayBc>30) {
						a = 1/0;
					}
					total = (yearTc*365+monthTc*30+dayTc)-(yearBc*365+monthBc*30+dayBc);
					if (total<0) {
						a = 1/0;
					}
					
					//output
					textFieldDayAlive.setText("You have been alive for "+total+" days.");
					textFieldSleepHours.setText("You have slept "+total*8+" hours.");
				}
				catch (Exception err) {

					//output if error exists
					textFieldDayAlive.setText("Please enter proper date");
					textFieldSleepHours.setText("");
				}

			}
		});
		btnCalculate.setBounds(37, 230, 91, 23);
		panel.add(btnCalculate);

		//exit button
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(37, 264, 91, 23);
		panel.add(btnExit);


	}
}

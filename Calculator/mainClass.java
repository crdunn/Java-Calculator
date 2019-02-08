package Calculator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainClass {
	
	public static enum Ops {
		ONE, TWO, THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,PLUS,MINUS,MULTIPLY,DIVIDE, EQUELS, CLEAR
	}
	
	static calculations calc = new calculations();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame cf = new JFrame();
		
		cf.setTitle("Calculator");
		cf.setSize(200,360);
		cf.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		cf.setLayout(new FlowLayout());
		
		JTextField textField = new JTextField(10);
		textField.setEditable(false);
		textField.setText("");
		cf.add(textField);
		
		
		//What happens when the button is clicked
		ActionListener actionListener= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(calc.isSwap() == 2) {
					textField.setText("");
					calc.setSwap(0);
				}
				
				
				String entry = e.getActionCommand();
				String text = textField.getText();
				
				if (entry == "+" || entry == "-" || entry == "*" || entry == "/" )  {
					calc.setOperator(entry);
					calc.setSwap(1);
					textField.setText(text = "");
					
				} else if (entry == "C"){
					textField.setText(text = "");
					calc.setSwap(0);
					calc.setFirst(0);
					calc.setSecond(0);
					
					
				} else if (entry == "CE"){
					if (calc.isSwap() == 0) {
						textField.setText(text = "");
						calc.setFirst(0);
					} else if (calc.isSwap() == 1){
						textField.setText(Integer.toString(calc.getFirst()));
						calc.setSecond(0);
					}
					
				} else if (entry == "="){
					textField.setText(Double.toString(calc.calcultaion()));
					calc.setSwap(2);
				} else {
					textField.setText(text + entry);
					
					if (calc.isSwap() == 0) {
						calc.setFirst(Integer.parseInt(text + entry));
					} else if (calc.isSwap() == 1){
						calc.setSecond(Integer.parseInt(text + entry));
					}
					
				}
				
				System.out.println("First: " + calc.getFirst());
				System.out.println("Second: " + calc.getSecond());
				System.out.println("operator: " + calc.getOperator());
				System.out.println("swap: " + calc.isSwap());

			}
			
		};


		
		for (int i = 0; i < 17; i++) {
			String[] operators = {"+","-","*","/", "CE", "C","="};
			if (i < 10) {
				JButton button = new JButton(Integer.toString(i));
				
				button.setActionCommand(Integer.toString(i));
				
				button.addActionListener(actionListener);
				
				cf.add(button);
			} else {
				JButton button = new JButton(operators[i-10]);
				
				button.setActionCommand(operators[i-10]);
				
				button.addActionListener(actionListener);
				
				cf.add(button);
			}
		}
		
		
		//Boilerplate code to make the window behave well.
		cf.validate();
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

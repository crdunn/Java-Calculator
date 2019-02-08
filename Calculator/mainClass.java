package Calculator;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
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
		cf.setSize(200,350);
		cf.setVisible(true);
		
		cf.setLayout(new FlowLayout());
		
		JTextField textField = new JTextField(10);
		textField.setEditable(false);
		textField.setText("");
		cf.add(textField);
		
		
		//What happens when the button is clicked
		ActionListener actionListener= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entry = e.getActionCommand();
				String text = textField.getText();
				
				if (entry == "+" || entry == "-" || entry == "*" || entry == "/" )  {
					calc.setOperator(entry);
					calc.setSwap(false);
					textField.setText(text = "");
					System.out.println("This is from getOperator: " + calc.getOperator());
					System.out.println("This is from getOperator: " + calc.isSwap());
					
				} else if (entry == "C"){
					textField.setText(text = "");
					
				} else if (entry == "="){
					System.out.println(calc.calcultaion());
				} else {
					textField.setText(text + entry);
					
					if (calc.isSwap()) {
						calc.setFirst(Integer.parseInt(text + entry));
					} else {
						calc.setSecond(Integer.parseInt(text + entry));
					}
					
					System.out.println("This Is from calc: " + calc.getFirst());
					System.out.println("This Is from calc: " + calc.getSecond());
				}

			}
			
		};


		
		for (int i = 0; i < 16; i++) {
			String[] operators = {"+","-","*","/", "=", "C"};
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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GUI {

	public static void main(String[] args) {
		// Create Window
		JFrame frame = new JFrame("Cipher Encryptor");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel label = new JLabel("Please choose an encryption method for your text file");
		label.setBounds(100, 10, 400, 50);
		frame.add(label);
		
		JButton caesarButton = new JButton("Caesar Cipher");
		caesarButton.setBounds(50, 100, 200, 50);
		frame.add(caesarButton);
		
		JButton vigenereButton = new JButton("Vigenère Cipher");
		vigenereButton.setBounds(350, 100, 200, 50);
		frame.add(vigenereButton);
		
		JButton affineButton = new JButton("Affine Cipher");
		affineButton.setBounds(50, 225, 200, 50);
		frame.add(affineButton);
		
		JButton otpButton = new JButton("One Time Pad Cipher");
		otpButton.setBounds(350, 225, 200, 50);
		frame.add(otpButton);
	}

}

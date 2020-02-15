package gameoflife;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private Panel panel;
	
	public Window(Controller controller) {
		panel = new Panel(controller);
		initFrame();
	}
	private void initFrame() {
		add(panel);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

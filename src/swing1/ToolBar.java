package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2495887311685111321L;
	private JButton helloButton;
	private JButton goodbyeButton;

	private StringListener textListener;

	public ToolBar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloButton);
		add(goodbyeButton);
	}

	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		System.out.println("some source " + e.getSource().toString());

		if (clicked == helloButton) {
			if (textListener != null) {
				textListener.textEmitted("hello");
			}
		} else {
			if (textListener != null) {
				textListener.textEmitted("Good bye");
			}
		}

	}

}

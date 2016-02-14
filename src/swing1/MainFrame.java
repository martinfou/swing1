package swing1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private ToolBar toolbar;
	private FormPanel formPanel;
	
	public MainFrame(){
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		toolbar = new ToolBar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		toolbar.setStringListener(new StringListener() {
			
			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();

				textPanel.appendText(name + " : " + occupation);
			};
		});

		
		add(toolbar,BorderLayout.NORTH);
		add(textPanel,BorderLayout.CENTER);
		add(formPanel,BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
}

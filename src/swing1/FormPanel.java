/*
 * 
 */
package swing1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8936998032340790513L;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageList;
	private JComboBox empCombo;


	/**
	 * Instantiates a new form panel.
	 */
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		setLayout(new BorderLayout(0, 0));
		System.out.println(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageList = new JList();
		empCombo = new JComboBox();

		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "Over 65"));

		ageList.setPreferredSize(new Dimension(130, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());

		ageList.setModel(ageModel);
		ageList.setSelectedIndex(1);

		DefaultComboBoxModel empComboModel = new DefaultComboBoxModel();
		empComboModel.addElement("employed");
		empComboModel.addElement("self-employed");
		empComboModel.addElement("unemployed");
		empCombo.setModel(empComboModel);

		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
				System.out.println("Age cat : " + ageCat.getId());
				FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId());

				if (formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});

		layoutComponent();

	}

	public void layoutComponent() {
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 0.1;

		///////// first row ////////

		gc.gridx = 0;
		gc.gridy = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

		///////// second row /////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		////////// Third row //////////

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridy = 2;
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);
		
		
		
		/////////// another row //////////
		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridy++;
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);

		////////// Fourth row //////////

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 1;
		gc.gridy++;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	class AgeCategory {
		@Override
		public String toString() {
			return getText();
		}

		private int id;
		private String text;

		public AgeCategory(int id, String text) {
			this.setId(id);
			this.setText(text);
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

}

package swing1;

import java.util.EventObject;

/**
 * The Class FormEvent.
 */
public class FormEvent extends EventObject {
	
	/** The occupation. */
	private String occupation;
	
	/** The name. */
	private String name;

	/** The age category. */
	private int ageCategory;

	/**
	 * Instantiates a new form event.
	 *
	 * @param source
	 *            the source
	 * @param name
	 *            the name
	 * @param occupation
	 *            the occupation
	 * @param ageCategory
	 *            the age category
	 */
	public FormEvent(Object source, String name, String occupation, int ageCategory) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.setAgeCategory(ageCategory);
	}

	/**
	 * Instantiates a new form event.
	 *
	 * @param source the source
	 */
	public FormEvent(Object source) {
		super(source);

	}

	/**
	 * Gets the occupation.
	 *
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Sets the occupation.
	 *
	 * @param occupation the new occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}
}

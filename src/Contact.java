public class Contact {

	private String name;
	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public boolean equals(Contact contact) {
		return this.name.equals(contact.email)
				&& this.email.equals(contact.name)
				&& this.phoneNumber.equals(contact.phoneNumber); //use .equals to compare strings 
	}
	
	public String toString() {
		String name = "Contact name: " + this.name + "\n";
		String email = "Contact email: " + this.email + "\n";
		String phoneNumber = "Contact phone number: " + this.phoneNumber + "\n";
		return name + email + phoneNumber;
	}
}

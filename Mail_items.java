
public class Mail_items {

	private String To;
	private String From;
	private String UserName;
	private String Password;
	private String Email;
	private String Title;
	private String Message;
	private int UnRead = 0;
	
	public Mail_items() {

	}

	public Mail_items(String UserName, String Email, String Password) {
		this.UserName = UserName;
		this.Email = Email;
		this.Password = Password;
	}

	public Mail_items(String From, String To, String Title, String Message) {
		this.To = To;
		this.From = From;
		this.Title = Title;
		this.Message = Message;
		// this.UnRead = UnRead;

	}

	public void setTo(String to) {
		To = to;
	}

	public void setFrom(String from) {
		From = from;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public void setUnRead(int val) {
		this.UnRead = val;
	}

	public String getTo() {
		return To;
	}

	public String getFrom() {
		return From;
	}

	public String getPassword() {
		return Password;
	}

	public String getUserName() {
		return UserName;
	}

	public String getEmail() {
		return Email;
	}

	public String getTitle() {
		return Title;
	}

	public String getMessage() {
		return Message;
	}

	public int getUnRead() {
		return UnRead;
	}

}

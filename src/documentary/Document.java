package documentary;


public class 	Document {
	 String DocumentName;
	 String Author;
	 int Year;
	 int Amount;
	Document(){
		
	}
	Document(String documentname, String author, int year, int amount){
		this.DocumentName = documentname;
		this.Author = author;
		this.Year = year;
		this.Amount = amount;
	}
	
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	public void setAuthor(String author) {
		Author = author;
	}
	
	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	
	public int getAmount() {
		return Amount;
	}
	
	public String getAuthor() {
		return Author;
	}
	
	public String getDocumentName() {
		return DocumentName;
	}
	
	public int getYear() {
		return Year;
	}
	
	
	public String toString() {
		String documentinfo = "Documentname: " + DocumentName + "-" + "Author: " + Author + "-" + "Year:" + Year + "-" + "Amount: "
					+ Amount;
		return documentinfo;
	}

}

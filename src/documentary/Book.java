package documentary;


public class Book extends Document {
	 int idB;
	 String type;
	 
	public Book(){
	
	}
	
	public Book(String documentname, String author, int year, int amount, int idB, String type){
		super(documentname,author,year,amount);
		this.idB = idB;
		this.type = type;
	}
	
	public void setinfo(String documentname, String author, int year, int amount, int idb, String type) {
		this.DocumentName = documentname;
		this.Author = author;
		this.Year = year;
		this.Amount = amount;
		this.idB = idb;
		this.type = type;
		
	}
	public void setIdB(int idB) {
		this.idB = idB;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getIdB() {
		return idB;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		String s1 = String.valueOf(this.Year);
		String s2= String.valueOf(this.Amount);
		String book = DocumentName+"-"+Author+"-"+s1+"-"+s2+"-"+idB+"-"+type;
		return book;
	}
	

}


public class Igrach {
       private String name;
       private int godini;
       private int rating;
    

      public Igrach (String n, int g, int r) {
    	   name = n;
    	   godini = g;
    	   rating = r;
    	   
       }
   public String getName() {
    	 return name;  
       }
    public void setName(String name) {
   		this.name = name;
   	}     
	public int getGodini() {
		return godini;
	}
	public void setGodini(int godini) {
		this.godini = godini;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}       
       
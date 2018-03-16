package listOfGameEntities;
//A game character class used to mainly test the implementation of generics
public class GameCharacter {
	//The only data member, a string
	protected String name;
	
	public GameCharacter(String n){
		name = n;
	}
	//Overrides the equals method
	public boolean equals(Object other){
		if(this.name.equals(((GameCharacter) (other)).name)){
			return true;
		}
		else{
			return false;
		}
	}
	
	//The toString method
	public String toString(){
		return "\nName: " + this.name ;
	}
}

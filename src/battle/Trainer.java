package battle;

public class Trainer {
	private String name;
	private Pokemon[] team = new Pokemon[6];
	private Item[] bag = new Item[5];
	private int PA; //Pokemon ativo na batalha
	
	public Trainer(String name, Pokemon[] t, Item[] b){
		this.name = name;
		for(int i=0; (t[i]!=null)&&(i<6); i++){
			team[i] = t[i];
		}
		for(int i=0; (b[i]!=null)&&(i<5); i++){
			bag[i] = b[i];
		}
	}
	
	public Pokemon getTeamMember(int i){
		return team[i];
	}
	
	public Item getItem(int i){
		return bag[i];
	}
	
	public void setPA(int i){
		PA = i;
	}
	
	public int getPA(){
		return PA;
	}
	
	public boolean nextPA() {
		for(int i = 0; i < 6; i++) {
			if(!team[i].getFainted()){
				PA = i;
				return true;
			}
		}
		return false;
	}
	
	public String getName(){
		return name;
	}
}

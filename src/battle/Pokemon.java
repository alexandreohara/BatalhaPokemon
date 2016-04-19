package battle;

public class Pokemon {
	private String name;
	private int ID;
	private String type;
	private int HP;
	private int HPcur;
	private int att;
	private int def;
	private int speed;
	private int catchRate;
	private boolean fainted;
	protected Move[] moves = new Move[4];
	
	public Pokemon(String name, int ID, String type, int HP, int att, int def, int speed, int catchRate) {
		this.name = name;
		this.ID = ID;
		this.type = type;
		this.HP = HP;
		this.att = att;
		this.def = def;
		this.speed = speed;
		this.catchRate = catchRate;
		this.fainted = false;
		HPcur = HP;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getCurrentHP() {
		return HPcur;
	}
	
	public void dmgReceived(int dmg) {
		this.HPcur -= dmg;
		if(this.HPcur <=0){
			fainted = true;
			this.HPcur = 0;
		}
	}
	
	public String getType() {
		return type;
	}
	
	public int getAtt() {
		return att;
	}
	
	public int getDef() {
		return def;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public boolean getFainted() {
		return fainted;
	}
	
	public double getAdv(String enemyType){
		if(type.equals("fire")){
			if(enemyType.equals("fire")||enemyType.equals("water")||enemyType.equals("rock")||enemyType.equals("dragon")){
				return 0.5;
			}
			if(enemyType.equals("grass")||enemyType.equals("bug")||enemyType.equals("ice")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("water")){
			if(enemyType.equals("water")||enemyType.equals("grass")||enemyType.equals("dragon")){
				return 0.5;
			}
			if(enemyType.equals("fire")||enemyType.equals("ground")||enemyType.equals("rock")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("grass")){
			if(enemyType.equals("fire")||enemyType.equals("grass")||enemyType.equals("poison")||enemyType.equals("flying")||enemyType.equals("bug")||enemyType.equals("dragon")){
				return 0.5;
			}
			if(enemyType.equals("water")||enemyType.equals("ground")||enemyType.equals("rock")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("electric")){
			if(enemyType.equals("ground")){
				return 0;
			}
			if(enemyType.equals("electric")||enemyType.equals("grass")||enemyType.equals("dragon")){
				return 0.5;
			}
			if(enemyType.equals("water")||enemyType.equals("flying")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("ice")){
			if(enemyType.equals("fire")||enemyType.equals("water")||enemyType.equals("ice")){
				return 0.5;
			}
			if(enemyType.equals("grass")||enemyType.equals("ground")||enemyType.equals("flying")||enemyType.equals("dragon")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("normal")){
			if(enemyType.equals("rock")){
				return 0.5;
			}
			if(enemyType.equals("ghost")){
				return 0;
			}
			else return 1;
		}
		if(type.equals("flying")){
			if(enemyType.equals("electric")||enemyType.equals("rock")){
				return 0.5;
			}
			if(enemyType.equals("grass")||enemyType.equals("fighting")||enemyType.equals("bug")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("psychic")){
			if(enemyType.equals("psychic")){
				return 0.5;
			}
			if(enemyType.equals("fighting")||enemyType.equals("poison")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("dragon")){
			if(enemyType.equals("dragon")){
				return 2;
			}
			else return 1;
		}
		if(type.equals("ground")){
			if(enemyType.equals("flying")){
				return 0;
			}
			if(enemyType.equals("grass")||enemyType.equals("bug")){
				return 0.5;
			}
			if(enemyType.equals("fire")||enemyType.equals("electric")||enemyType.equals("poison")||enemyType.equals("rock")){
				return 2;
			}
			else return 1;
		}
		else return -1;
	}

	public String getAdvString(double i) {
		if (i==0.5){
			return "It's not very effective...";
		}
		if (i==2) {
			return "It's super effective!";
		}
		else return "";
	}
}

//Red team: Charizard, Blastoise, Venusaur, Pikachu, Lapras, Snorlax
//Blue team: Pidgeot, Alakazam, Rhydon, Arcanine, Gyarados, Dragonite
class Charizard extends Pokemon { 
	public Charizard() {
		super("Charizard", 6, "fire", 184, 136, 129, 151, 45);
		moves[0] = new Move("Flamethrower", 95, false);
		moves[1] = new Move("Mega Punch", 80, false);
		moves[2] = new Move("Slash", 70, false);
		moves[3] = new Move("Fire Blast", 120, false);
	}
}

class Blastoise extends Pokemon {
	public Blastoise() {
		super("Blastoise", 9, "water", 185, 136, 151, 129, 45);
		moves[0] = new Move("Hydro Pump", 120, false);
		moves[1] = new Move("Surf", 95, false);
		moves[2] = new Move("Blizzard", 120, false);
		moves[3] = new Move("Bite", 60, false);
	}
}

class Venusaur extends Pokemon {
	public Venusaur() {
		super("Venusaur", 3, "grass", 186, 151, 134, 131, 45);
		moves[0] = new Move("Razor Leaf", 55, false);
		moves[1] = new Move("Body Slam", 85, false);
		moves[2] = new Move("Solar Beam", 120, false);
		moves[3] = new Move("Cut", 50, false);
	}
}

class Pikachu extends Pokemon {
	public Pikachu() {
		super("Pikachu", 25, "electric", 141, 106, 81, 141, 190);
		moves[0] = new Move("Thunderbolt", 95, false);
		moves[1] = new Move("Quick Attack", 40, true);
		moves[2] = new Move("Mega Punch", 80, false);
		moves[3] = new Move("Swift", 60, false);
	}
}

class Lapras extends Pokemon {
	public Lapras() {
		super("Lapras", 131, "ice", 236, 146, 131, 111, 45);
		moves[0] = new Move("Ice Beam", 95, false);
		moves[1] = new Move("Body Slam", 85, false);
		moves[2] = new Move("Bubble Beam", 65, false);
		moves[3] = new Move("Blizzard", 120, false);
	}
}

class Snorlax extends Pokemon {
	public Snorlax() {
		super("Snorlax", 143, "normal", 266, 161, 116, 81, 45);
		moves[0] = new Move("Earthquake", 100, false);
		moves[1] = new Move("Body Slam", 85, false);
		moves[2] = new Move("Psychic", 90, false);
		moves[3] = new Move("Mega Punch", 80, false);
	}
}

class Pidgeot extends Pokemon {
	public Pidgeot() {
		super("Pidgeot", 18, "flying", 189, 131, 126, 142, 45);
		moves[0] = new Move("Sky attack", 140, false);
		moves[1] = new Move("Quick attack", 40, true);
		moves[2] = new Move("Swift", 60, false);
		moves[3] = new Move("Fly", 70, false);
	}
}

class Alakazam extends Pokemon {
	public Alakazam() {
		super("Alakazam", 65, "psychic", 161, 186, 96, 171, 50);
		moves[0] = new Move("Psychic", 90, false);
		moves[1] = new Move("Submission", 80, false);
		moves[2] = new Move("Tri Attack", 80, false);
		moves[3] = new Move("Body Slam", 85, false);
	}
}

class Rhydon extends Pokemon {
	public Rhydon() {
		super("Rhydon", 112, "ground", 211, 181, 171, 91, 60);
		moves[0] = new Move("Stomp", 65, false);
		moves[1] = new Move("Mega Punch", 80, false);
		moves[2] = new Move("Rock Slide", 75, false);
		moves[3] = new Move("Strength", 80, false);
	}
}

class Arcanine extends Pokemon {
	public Arcanine() {
		super("Arcanine", 59, "fire", 196, 161, 131, 146, 75);
		moves[0] = new Move("Fire Blast", 120, false);
		moves[1] = new Move("Swift", 60, false);
		moves[2] = new Move("Bite", 60, false);
		moves[3] = new Move("Body Slam", 85, false);
	}
}

class Gyarados extends Pokemon {
	public Gyarados() {
		super("Gyarados", 130, "water", 201, 176, 130, 132, 45);
		moves[0] = new Move("Ice Beam", 95, false);
		moves[1] = new Move("Surf", 95, false);
		moves[2] = new Move("Bite", 50, false);
		moves[3] = new Move("Thunder", 120, false);
	}
}

class Dragonite extends Pokemon {
	public Dragonite() {
		super("Dragonite", 149, "dragon", 197, 185, 146, 131, 45);
		moves[0] = new Move("Blizzard", 120, false);
		moves[1] = new Move("Thunderbolt", 95, false);
		moves[2] = new Move("Body Slam", 85, false);
		moves[3] = new Move("Surf", 95, false);
	}
}

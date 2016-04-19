package battle;
import java.util.Random;

public class BattleControls extends Controller {
	private Pokemon Char = new Charizard();
	private Pokemon Bla = new Blastoise();
	private Pokemon Venu = new Venusaur();
	private Pokemon Pika = new Pikachu();
	private Pokemon Lap = new Lapras();
	private Pokemon Snor = new Snorlax();
	private Pokemon Pid = new Pidgeot();
	private Pokemon Ala = new Alakazam();
	private Pokemon Rhy = new Rhydon();
	private Pokemon Arc = new Arcanine();
	private Pokemon Gya = new Gyarados();
	private Pokemon Drag = new Dragonite();
	private String message;
	private Pokemon[] teamRed = {Char, Bla, Venu, Pika, Lap, Snor};
	private Pokemon[] teamGary = {Pid, Ala, Rhy, Arc, Gya, Drag};
	private Item hpotion = new Potion("Hyper Potion", 200);
	private Item spotion = new Potion("Super Potion", 50);
	private Item[] itemList = {hpotion, spotion};
	private Trainer Red = new Trainer("Red", teamRed, itemList);
	private Trainer Gary = new Trainer("Gary", teamGary, itemList);
	
	private class Fight extends Event {
		Trainer ATK;
		Trainer DEF;
		public Fight(long eventTime, Trainer P1, Trainer P2) {
			super(eventTime);
			ATK = P1;
			DEF = P2;
		}
		public void action() {
			Random gerador = new Random();
			int i = gerador.nextInt(4);
			int j = gerador.nextInt(4);
			if((DEF.getTeamMember(DEF.getPA()).moves[j].getPri()) && (ATK.getTeamMember(ATK.getPA()).moves[i].getPri())) {
				if(ATK.getTeamMember(ATK.getPA()).getSpeed() < DEF.getTeamMember(DEF.getPA()).getSpeed()) {
					Trainer Temp = ATK;
					ATK = DEF;
					DEF = Temp;
					int temp = i;
					i = j;
					j = temp;
				}
			}
			else if(DEF.getTeamMember(DEF.getPA()).moves[j].getPri()){
				Trainer Temp = ATK;
				ATK = DEF;
				DEF = Temp;
				int temp = i;
				i = j;
				j = temp;
			}
			else if(ATK.getTeamMember(ATK.getPA()).getSpeed() < DEF.getTeamMember(DEF.getPA()).getSpeed()) {
				Trainer Temp = ATK;
				ATK = DEF;
				DEF = Temp;
				int temp = i;
				i = j;
				j = temp;
			}
			double damage = ATK.getTeamMember(ATK.getPA()).moves[i].DamageCalculate(ATK.getTeamMember(ATK.getPA()).getAtt(), ATK.getTeamMember(ATK.getPA()).getDef(),
					ATK.getTeamMember(ATK.getPA()).getAdv(DEF.getTeamMember(DEF.getPA()).getType()));
			DEF.getTeamMember(DEF.getPA()).dmgReceived((int)damage);
			message = ATK.getName()+"'s " + ATK.getTeamMember(ATK.getPA()).getName() + " used " + ATK.getTeamMember(ATK.getPA()).moves[i] +
					"!\n" + ATK.getTeamMember(ATK.getPA()).getAdvString(ATK.getTeamMember(ATK.getPA()).getAdv(DEF.getTeamMember(DEF.getPA()).getType()));
			if(DEF.getTeamMember(DEF.getPA()).getFainted()) {
				message += DEF.getTeamMember(DEF.getPA()).getName() + " fainted!";
				if(!DEF.nextPA()){
					message += ATK.getName() + " defeated " + DEF.getName() + "!\n" + ATK.getName() + "got $2000 for winning!";
				}
				else {
					message += DEF.getName() + " sent out " + DEF.getTeamMember(DEF.getPA()) + "!\n";
				}
			}
		}
		public String description() {
			return message;
		}
	}
}
package battle;
import java.util.Random;

public class Move {
	private String name;
	private int damage;
	private boolean priority;//somente alguns movimentos possuem prioridade sobre o outro. ex: QuickAttack
	
	public Move(String n, int d, boolean p) {
		name = n;
		damage = d;
		priority = p;
	}
	
	public double DamageCalculate(int att, int def, double typeAdv) {
		Random gerador = new Random();
		int rand = gerador.nextInt(15) + 85;
		return (((22 * att * damage / def)/50) + 2) * typeAdv * rand/100;
	}
	
	public boolean getPri() {
		return priority;
	}
}

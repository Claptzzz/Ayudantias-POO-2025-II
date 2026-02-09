package Steam;

public class Juego {

	private int id;
	private String name;
	private int discount;
	private int score;
	private double sort;
	
	public Juego(int id, String name, int discount, int score) {
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.score = score;
	}
	
	public double getSort() {
		return sort;
	}
	public void setSort(double sort) {
		this.sort = sort;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

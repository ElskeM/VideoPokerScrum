package videoPoker;

public enum Combination {
	
	RoyalFlush(50),
	StraightFlush(25),
	FourOfaKind(25),
	FullHouse(9),
	Flush(6),
	Straight(4),
	ThreeOfaKind(3),
	TwoPair(2),
	PairOfJacks(1);
	
	public final int value;
		private Combination(int value) {
			this.value = value;
		}

}

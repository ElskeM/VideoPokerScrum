package videoPoker;

public enum Combination {
	
	RoyalFlush(250),
	StraightFlush(50),
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
		
		public int getValue() {
			return value;
		}
		//public int getValue() {
			//return value;
		//}
}

package marsmission;

public enum Direction {
	N(" ^ "), // North - Top
	W(" < "), // West - Right
	S(" v "), // South - Bottom
	E(" > "); // East - Left

	private final String symbol;
	
	private Direction(String symbol) {
			this.symbol = symbol;
	}
	
	// Get symbol link to the direction
	public String getSymbol() {
		return symbol;
	}
	
	// Display compass with coordinate North, West, South, East
	public void displayCompass() {
		System.out.println("\n" + "  N  ");
     	System.out.println("  |  ");
     	System.out.println("W---E");
     	System.out.println("  |  ");
     	System.out.println("  S  " + "\n");
	}
}
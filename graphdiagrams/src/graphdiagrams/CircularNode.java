package graphdiagrams;

/**
 * @invar | 1 <= getRadius()
 */
public class CircularNode extends Node {
	
	/**
	 * @invar | 1 <= radius
	 */
	int radius;
	
	public int getRadius() { return radius; }
	
	/**
	 * @throws IllegalArgumentException | radius <= 0
	 * @post | getRadius() == radius
	 * @post | getIncomingArcs().isEmpty()
	 * @post | getOutgoingArcs().isEmpty()
	 */
	public CircularNode(int radius) {
		if (radius <= 0)
			throw new IllegalArgumentException("`radius` is not greater than zero");
		this.radius = radius;
	}
	
	@Override
	public int getArea() {
		return radius * radius * 314 / 100;
	}
	
	@Override
	public boolean isIsomorphicWith(Node other) {
		return other instanceof CircularNode n && radius == n.radius;
	}
	
}

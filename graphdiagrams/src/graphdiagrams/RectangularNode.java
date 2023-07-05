package graphdiagrams;

/**
 * @invar | 1 <= getWidth()
 * @invar | 1 <= getHeight()
 */
public class RectangularNode extends Node {
	
	/**
	 * @invar | 1 <= width
	 * @invar | 1 <= height
	 */
	int width;
	int height;
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }

	/**
	 * @throws IllegalArgumentException | width <= 0
	 * @throws IllegalArgumentException | height <= 0
	 * @post | getWidth() == width
	 * @post | getHeight() == height
	 * @post | getOutgoingArcs().isEmpty()
	 * @post | getIncomingArcs().isEmpty()
	 */
	public RectangularNode(int width, int height) {
		if (width <= 0)
			throw new IllegalArgumentException("`width` is not greater than zero");
		if (height <= 0)
			throw new IllegalArgumentException("`height` is not greater than zero");
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getArea() {
		return width * height;
	}
	
	@Override
	public boolean isIsomorphicWith(Node other) {
		return other instanceof RectangularNode n && width == n.width && height == n.height;
	}
	
}

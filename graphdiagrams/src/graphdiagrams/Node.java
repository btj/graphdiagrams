package graphdiagrams;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getOutgoingArcs().stream().allMatch(a -> a != null && a.getSourceNode() == this)
 * @invar | getIncomingArcs().stream().allMatch(a -> a != null && a.getTargetNode() == this)
 */
public abstract class Node {
	
	/**
	 * @invar | outgoingArcs != null
	 * @invar | incomingArcs != null
	 * @invar | outgoingArcs.stream().allMatch(a -> a != null && a.sourceNode == this)
	 * @invar | incomingArcs.stream().allMatch(a -> a != null && a.targetNode == this)
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Arc> outgoingArcs = new HashSet<>();
	/**
	 * @representationObject
	 * @peerObjects
	 */
	Set<Arc> incomingArcs = new HashSet<>();
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 */
	public Set<Arc> getOutgoingArcs() { return Set.copyOf(outgoingArcs); }
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 */
	public Set<Arc> getIncomingArcs() { return Set.copyOf(incomingArcs); }
	
	Node() {}
	
	public abstract int getArea();
	
	public abstract boolean isIsomorphicWith(Node other);

}

package graphdiagrams;

import logicalcollections.LogicalSet;

/**
 * @invar | 0 <= getDepartureAngle()
 * @invar | getDepartureAngle() <= 359
 * @invar | getSourceNode() == null || getSourceNode().getOutgoingArcs().contains(this)
 * @invar | getTargetNode() == null || getTargetNode().getIncomingArcs().contains(this)
 */
public class Arc {
	
	/**
	 * @invar | 0 <= departureAngle
	 * @invar | departureAngle <= 359
	 * @invar | sourceNode == null || sourceNode.outgoingArcs.contains(this)
	 * @invar | targetNode == null || targetNode.incomingArcs.contains(this)
	 */
	int departureAngle;
	/**
	 * @peerObject
	 */
	Node sourceNode;
	/**
	 * @peerObject
	 */
	Node targetNode;
	
	public int getDepartureAngle() { return departureAngle; }
	/**
	 * @peerObject
	 */
	public Node getSourceNode() { return sourceNode; }
	/**
	 * @peerObject
	 */
	public Node getTargetNode() { return targetNode; }
	
	/**
	 * @throws IllegalArgumentException | departureAngle < 0 || 359 < departureAngle
	 * @post | getDepartureAngle() == departureAngle
	 * @post | getSourceNode() == null
	 * @post | getTargetNode() == null
	 */
	public Arc(int departureAngle) {
		if (departureAngle < 0 || 359 < departureAngle)
			throw new IllegalArgumentException("`departureAngle` is out of range");
		this.departureAngle = departureAngle;
	}
	
	/**
	 * @pre | sourceNode != null
	 * @pre | getSourceNode() == null // This precondition is essential for preserving consistency of the bidirectional association!
	 * @mutates_properties | getSourceNode(), sourceNode.getOutgoingArcs()
	 * @post | getSourceNode() == sourceNode
	 * @post | sourceNode.getOutgoingArcs().equals(LogicalSet.plus(old(sourceNode.getOutgoingArcs()), this))
	 */
	public void setSourceNode(Node sourceNode) {
		this.sourceNode = sourceNode;
		sourceNode.outgoingArcs.add(this);
	}
	
	/**
	 * @pre | targetNode != null
	 * @pre | getTargetNode() == null // This precondition is essential for preserving consistency of the bidirectional association!
	 * @mutates_properties | getTargetNode(), targetNode.getIncomingArcs()
	 * @post | getTargetNode() == targetNode
	 * @post | targetNode.getIncomingArcs().equals(LogicalSet.plus(old(targetNode.getIncomingArcs()), this))
	 */
	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
		targetNode.incomingArcs.add(this);
	}
	
	/**
	 * @pre | getSourceNode() != null
	 * @mutates_properties | getSourceNode(), getSourceNode().getOutgoingArcs()
	 * @post | getSourceNode() == null
	 * @post | old(getSourceNode()).getOutgoingArcs().equals(LogicalSet.minus(old(getSourceNode().getOutgoingArcs()), this))
	 */
	public void unlinkSourceNode() {
		sourceNode.outgoingArcs.remove(this);
		sourceNode = null;
	}
	
	/**
	 * @pre | getTargetNode() != null
	 * @mutates_properties | getTargetNode(), getTargetNode().getIncomingArcs()
	 * @post | getTargetNode() == null
	 * @post | old(getTargetNode()).getIncomingArcs().equals(LogicalSet.minus(old(getTargetNode().getIncomingArcs()), this))
	 */
	public void unlinkTargetNode() {
		targetNode.incomingArcs.remove(this);
		targetNode = null;
	}

}

package graphdiagrams.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import graphdiagrams.Arc;
import graphdiagrams.CircularNode;
import graphdiagrams.RectangularNode;

class GraphDiagramsTest {

	@Test
	void test() {
		RectangularNode rn1 = new RectangularNode(10, 5);
		assertEquals(10, rn1.getWidth());
		assertEquals(5, rn1.getHeight());
		assertTrue(rn1.getOutgoingArcs().isEmpty());
		assertTrue(rn1.getIncomingArcs().isEmpty());
		assertEquals(50, rn1.getArea());
		
		CircularNode cn1 = new CircularNode(100);
		assertEquals(100, cn1.getRadius());
		assertTrue(cn1.getOutgoingArcs().isEmpty());
		assertTrue(cn1.getIncomingArcs().isEmpty());
		assertEquals(31400, cn1.getArea());
		
		RectangularNode rn2 = new RectangularNode(10, 5);
		RectangularNode rn3 = new RectangularNode(11, 5);
		RectangularNode rn4 = new RectangularNode(10, 6);
		CircularNode cn2 = new CircularNode(100);
		CircularNode cn3 = new CircularNode(101);
		
		assertTrue(rn1.isIsomorphicWith(rn2));
		assertFalse(rn1.isIsomorphicWith(rn3));
		assertFalse(rn1.isIsomorphicWith(rn4));
		assertFalse(rn1.isIsomorphicWith(cn1));
		assertTrue(cn1.isIsomorphicWith(cn2));
		assertFalse(cn1.isIsomorphicWith(cn3));
		assertFalse(cn1.isIsomorphicWith(rn1));
		
		Arc a1 = new Arc(45);
		assertEquals(45, a1.getDepartureAngle());
		assertNull(a1.getSourceNode());
		assertNull(a1.getTargetNode());
		
		a1.setSourceNode(rn1);
		assertSame(rn1, a1.getSourceNode());
		assertEquals(Set.of(a1), rn1.getOutgoingArcs());
		
		a1.setTargetNode(cn1);
		assertSame(cn1, a1.getTargetNode());
		assertEquals(Set.of(a1), cn1.getIncomingArcs());
		
		a1.unlinkSourceNode();
		assertNull(a1.getSourceNode());
		assertEquals(Set.of(), rn1.getOutgoingArcs());
		
		a1.unlinkTargetNode();
		assertNull(a1.getTargetNode());
		assertEquals(Set.of(), cn1.getIncomingArcs());
	}

}

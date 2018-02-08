package no.hvl.dat102.adt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.ËmptyCollectionException;
import no.hvl.dat102.sirkulaer.Sirkulaerkoe;

/**
 * Test for StackADT.
 * 
 * @author Ole Olsen
 */
public class koeADTTest {

	/**
	 * Size of the tested stabel.
	 */
	protected static final int SIZE = 10;

	// The stabel
	private KoeADT<Integer> stabel;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	/**
	 * Get a new stabel for each test.
	 */
	@Before
	public final void setup() {
		stabel = new Sirkulaerkoe<Integer>(SIZE);
	}

	/**
	 * Test that a new stabel is empty.
	 */
	@Test
	public final void newStackIsEmpty() {
		assertTrue(stabel.isEmpty());
	}

	/**
	 * Test on push and pop.
	 */
	@Test
	public final void pushAndPop() {

		stabel.settIkoe(e0);
		stabel.settIkoe(e1);
		stabel.settIkoe(e2);
		stabel.settIkoe(e3);

		try {
			assertEquals(e0, stabel.taUtAvKoe());
			assertEquals(e1, stabel.taUtAvKoe());
			assertEquals(e2, stabel.taUtAvKoe());
			assertEquals(e3, stabel.taUtAvKoe());
		} catch (ËmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test on push and pop with duplicated values.
	 */
	@Test
	public final void pushAndPopWithDuplicates() {

		stabel.settIkoe(e0);
		stabel.settIkoe(e1);
		stabel.settIkoe(e1);
		stabel.settIkoe(e2);

		try {
			assertEquals(e0, stabel.taUtAvKoe());
			assertEquals(e1, stabel.taUtAvKoe());
			assertEquals(e1, stabel.taUtAvKoe());
			assertEquals(e2, stabel.taUtAvKoe());
		} catch (ËmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Testing top.
	 */
	@Test
	public final void pushPopPushPushPopPeek() {
		try {
			stabel.settIkoe(e2);
			stabel.taUtAvKoe();
			stabel.settIkoe(e3);
			stabel.settIkoe(e4);
			stabel.taUtAvKoe();
			assertEquals(e4, stabel.peek());

		} catch (ËmptyCollectionException e) {
			fail("pop or top failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test that a stabel with element(s) is not empty.
	 */
	@Test
	public final void isNotEmpty() {
		stabel.settIkoe(e0);
		assertFalse(stabel.isEmpty());
	}

	/**
	 * Test that a push - pop operation on an empty stabel gives an empty
	 * stabel.
	 */
	@Test
	public final void pushPopIsEmpty() {
		try {
			stabel.settIkoe(e0);
			stabel.taUtAvKoe();
			assertTrue(stabel.isEmpty());
		} catch (ËmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}
	
	
	/**
	 * Trying to pop an element from an empty stabel, should give an underflow
	 * exception.
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */
	@Test(expected = ËmptyCollectionException.class)
	public final void popFromEmptyIsUnderflowed() throws ËmptyCollectionException {
		stabel.taUtAvKoe();
	}
	
	/**
     * Tester om stabelen utvider seg riktig. Stabler på to flere elementer 
     * enn stabeltabellen har plass til, sjekker om antallet er riktig,
     * tar ut og sjekker første element, tar ut de i "midten",
     * tar ut og sjekker det siste elementet og sjekker til slutt
     * at stabel er tom slik det forventes.
     */
	
    @Test
    public final void utviderKoeSeg() {
        stabel.settIkoe(e1);
        for (int i = 0; i < SIZE; i++) {
            stabel.settIkoe(e0);
        }
        stabel.settIkoe(e2);
        assertEquals(SIZE * 2, stabel.size());
        assertEquals(e1, stabel.taUtAvKoe());
        for (int i = 0; i < SIZE; i++) {
            stabel.taUtAvKoe();
        }
        assertEquals(e2, stabel.taUtAvKoe());
        assertTrue(stabel.isEmpty());
    }
	
}



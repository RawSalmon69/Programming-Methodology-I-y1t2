package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.PryGhost;

class PryGhostTest {

    PryGhost pryGhost;

    @BeforeEach
    void setUp() {
        pryGhost = new PryGhost(); 
    }
    @Test
    void testConstructor() {
    	PryGhost a = new PryGhost();
    	PryGhost b = new PryGhost(2);
    	PryGhost c = new PryGhost(1,3);
    	assertEquals("PryGhost [HP: 3 , Power: 3 , PPT: 0]",a.toString());
    	assertEquals("PryGhost [HP: 3 , Power: 2 , PPT: 0]",b.toString());
    	assertEquals("PryGhost [HP: 3 , Power: 1 , PPT: 3]",c.toString());
    }
    @Test
    void testIsDestroyedFalse() {
        assertFalse(pryGhost.isDestroyed()); 
    }

    @Test
    void testIsDestroyedTrue() {
        pryGhost.decreaseHp(10); 
        assertTrue(pryGhost.isDestroyed()); 
    }


    @Test
    void testDecreaseHp() {
        pryGhost.decreaseHp(3);
        assertEquals(0, pryGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
        pryGhost.decreaseHp(15);
        assertEquals(0, pryGhost.getHp()); 
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20);
        // TODO: Fill your code

        // case 1
        pryGhost.attack();
        assertEquals(17, GameController.getInstance().getHp());

        // case 2
        GameController.getInstance().setHp(20);
        pryGhost.setPower(20);
        pryGhost.attack();
        assertEquals(0, GameController.getInstance().getHp());
    }
    
    @Test
    void testToString() {
        assertEquals("PryGhost [HP: 3 , Power: 3 , PPT: 0]", pryGhost.toString()); 
    }

}

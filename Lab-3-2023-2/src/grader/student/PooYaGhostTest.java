package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import logic.ghost.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.HighGhost;
import logic.ghost.GaGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PooYaGhost;

import java.util.ArrayList;

class PooYaGhostTest {

    PooYaGhost pooYaGhost;

    @BeforeEach
    void setUp() {
        pooYaGhost = new PooYaGhost(5);
    }
    
    @Test
    void testIsDestroyedFalse() {
        assertFalse(pooYaGhost.isDestroyed());
    }

    @Test
    void testIsDestroyedTrue() {
        pooYaGhost.decreaseHp(10);
        assertTrue(pooYaGhost.isDestroyed());
    }

    @Test
    void testGetHp() {
        assertEquals(10, pooYaGhost.getHp());
    }

    @Test
    void testDecreaseHp() {
        pooYaGhost.decreaseHp(3);
        assertEquals(7, pooYaGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
        pooYaGhost.decreaseHp(15);
        assertEquals(0, pooYaGhost.getHp());
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20); 
        GameController.getInstance().setScore(15); 
        pooYaGhost.attack();
        assertEquals(15, GameController.getInstance().getHp());
        assertEquals(10, GameController.getInstance().getScore());
    }
    
   
    @Test
    void testToString() {
        assertEquals("PooYaGhost [HP: 10 , Power: 5]", pooYaGhost.toString());
    }

    @Test
    void testDamage() {
        pooYaGhost.damage();

        assertEquals(8, GameController.getInstance().getGhosts().get(0).getHp());
        assertEquals(8, GameController.getInstance().getGhosts().get(0).getHp());
        assertEquals(8, GameController.getInstance().getGhosts().get(0).getHp());
    }

}
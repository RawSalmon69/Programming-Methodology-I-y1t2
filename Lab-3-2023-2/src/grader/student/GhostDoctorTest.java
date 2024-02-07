package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.GhostDoctor;
import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.PooYaGhost;
import utils.Config;

class GhostDoctorTest {

    GhostDoctor ghostDoctor;

    @BeforeEach
    void setUp() {
        ghostDoctor = new GhostDoctor();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.GhostDoctorLevel, ghostDoctor.getLevel());
    }

    @Test
    void testAttackLowGhost() {
        // Attack Low Ghost
        GaGhost gaGhost = new GaGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(gaGhost);
        ghostDoctor.attack();
        assertEquals(0, gaGhost.getHp());
    }

    @Test
    void testAttackHighGhost() {
    	// TODO: Fill your code
        // Attack High Ghost
        PooYaGhost pooYaGhost = new PooYaGhost(15);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(pooYaGhost);
        ghostDoctor.attack();
        assertEquals(10, pooYaGhost.getHp());
    }

    @Test
    void testToString() {
        assertEquals("GhostDoctor", ghostDoctor.toString());
    }
}
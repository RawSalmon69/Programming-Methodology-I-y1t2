package grader.student;

import java.util.ArrayList;
import java.util.List;

import logic.ghost.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.item.Item;
import logic.item.Leklai;
import utils.GameUtils;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	Actor actor = new GhostDoctor();
        
        Ghost g1,g2,g3;
        
        // TODO: Fill your code
        g1 = new GaGhost();
        g2 = new PryGhost();
        g3 = new MaBongGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getGhosts().add(g1);
        GameController.getInstance().getGhosts().add(g2);
        GameController.getInstance().getGhosts().add(g3);

        // before
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));

        GameController.getInstance().play(actor);

        // after
        assertEquals(g2, GameController.getInstance().getGhosts().get(0));
    }
    
    @Test
    void testPlayWithItem() {
    	Actor actor = new Villager();
        Item item = new Leklai();
        
        // TODO: Fill your code
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().getItems().add(item);

        GameController.getInstance().getGhosts().add(new GaGhost());
        GameController.getInstance().getGhosts().add(new PryGhost());
        GameController.getInstance().getGhosts().add(new PooYaGhost(10));

        // before play
        assertEquals(3, GameController.getInstance().getGhosts().get(0).getHp());
        assertEquals(3, GameController.getInstance().getGhosts().get(1).getHp());
        assertEquals(10, GameController.getInstance().getGhosts().get(2).getHp());

        GameController.getInstance().play(actor);

        // check first ghost in list
        assertInstanceOf(PooYaGhost.class, GameController.getInstance().getGhosts().get(0));

        // check hp of first ghost
        assertEquals(10, GameController.getInstance().getGhosts().get(0).getHp());

        // that means 2 of Low Ghost there are GaGhost and PryGhost ware destroyed already and PooYaGhost
        // still alive because Villager can't attack to High Ghost
    }
    @Test
    void testIsGameOver() {
    	// TODO: Fill your code
        // case 1
        GameController.getInstance().setHp(10);
        GameController.getInstance().addNewActor(new GhostDoctor());

        assertFalse(GameController.getInstance().isGameOver());

        // case 2
        GameController.getInstance().setHp(0);
        GameController.getInstance().addNewActor(new GhostDoctor());

        assertTrue(GameController.getInstance().isGameOver());

        // case 3
        GameController.getInstance().setHp(10);
        GameController.getInstance().getActors().clear();

        assertTrue(GameController.getInstance().isGameOver());

        // case 4
        GameController.getInstance().setHp(0);
        GameController.getInstance().getActors().clear();

        assertTrue(GameController.getInstance().isGameOver());
    }

}
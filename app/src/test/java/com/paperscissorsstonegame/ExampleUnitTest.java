package com.paperscissorsstonegame;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(1, ComputerHandle.getResult(1, 3));
        assertEquals(1, ComputerHandle.getResult(2, 1));
        assertEquals(1, ComputerHandle.getResult(3, 2));
        assertEquals(2, ComputerHandle.getResult(1, 2));
        assertEquals(2, ComputerHandle.getResult(2, 3));
        assertEquals(2, ComputerHandle.getResult(3, 1));
        assertEquals(3, ComputerHandle.getResult(1, 1));
        assertEquals(3, ComputerHandle.getResult(2, 2));
        assertEquals(3, ComputerHandle.getResult(3, 3));


    }
}
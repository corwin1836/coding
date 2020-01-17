package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueGeneratorTest {
    UniqueGenerator unique = new UniqueGenerator();

    @Test
    public void charGenerator_returnsNextIteration_when999() throws Exception {
        String id = unique.charGenerator("AAA-999");
        assertEquals("AAB-111", id);
    }

    @Test
    public void charGenerator_returnsNextIteration_whenAAZ() throws Exception {
        String id = unique.charGenerator("AAZ-999");
        assertEquals("ABA-111", id);
    }

    @Test
    public void charGenerator_returnsNextIteration_whenAAA111() throws Exception {
        String id = unique.charGenerator("AAA-111");
        assertEquals("AAA-112", id);
    }
}
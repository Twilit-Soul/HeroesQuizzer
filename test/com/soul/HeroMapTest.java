package com.soul;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Test what we can for HeroMap.
 * Created by Mitchell on 12/14/2015.
 */
public class HeroMapTest {
    @Test
    public void getNonMap() {
        assertFalse(HeroMap.getHeroMapByName("notReal").isPresent());
    }
}

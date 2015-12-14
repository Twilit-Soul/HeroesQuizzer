package com.soul;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.fail;

/**
 * Test the Hero class.
 * Created by Mitchell on 12/14/2015.
 */
public class HeroTest {

    /**
     * We don't actually expect every Hero to be initialized.
     * For example: Icy Veins has no info on The Lost Vikings.
     * Also, I include unreleased Heroes in my list for some reason.
     */
    @Test
    public void testAllExpectedInitialized() {
        Set<Hero> unloadedHeroes = new HashSet<>();
        Hero.ALL_HEROES.stream().filter(hero -> hero.synergies.size() == 0).filter(hero -> !(hero == Hero.LUNARA ||
                hero == Hero.GREYMANE || hero == Hero.THE_LOST_VIKINGS))
                .forEach(unloadedHeroes::add);
        for (Hero hero : unloadedHeroes) {
            System.out.println("Hero didn't load: "+hero);
        }
        if (!unloadedHeroes.isEmpty()) {
            fail(unloadedHeroes.size()+" heroes failed to load.");
        }
    }

    @Test
    public void testFakeHero() {
        assertFalse(Hero.getHeroByName("fakeHero").isPresent());
    }
}

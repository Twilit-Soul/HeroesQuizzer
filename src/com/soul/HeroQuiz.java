package com.soul;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Responsible for handling quizzes. All I got right now.
 * Created by Mitchell on 12/22/2015.
 */
public class HeroQuiz {
    private final Set<Hero> quizzedAlready = new HashSet<>();
    private Hero currentQuizHero = Hero.ABATHUR;

    public Hero getNewQuizHero() {
        Random random = new Random();
        Set<Hero> toChooseFrom = new HashSet<>();
        Hero.ALL_HEROES.stream().filter(h -> !quizzedAlready.contains(h)).forEach(toChooseFrom::add);
        int heroNum = random.nextInt(toChooseFrom.size());
        int i = 0;
        for (Hero hero : toChooseFrom) {
            if (i++ == heroNum) {
                quizzedAlready.add(hero);
                currentQuizHero = hero;
                return hero;
            }
        }
        System.out.println("Failed to get hero to quiz somehow. Bad coder, bad.");
        System.exit(-1);
        return null;
    }

    public boolean hasSynergy(Hero synergy) {
        return currentQuizHero.synergies.contains(synergy);
    }

    public boolean hasCounter(Hero counter) {
        return currentQuizHero.counters.contains(counter);
    }

    public boolean hasStrongMap(HeroMap strongMap) {
        return currentQuizHero.strongMaps.contains(strongMap);
    }

    public boolean hasWeakMap(HeroMap weakMap) {
        return currentQuizHero.weakMaps.contains(weakMap);
    }
}

package com.soul;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Heroes maps, and the heroes good/bad on them.
 * Created by Mitchell on 12/14/2015.
 */
public class HeroMap {
    final String name;
    final Set<Hero> goodHeroes = new HashSet<>();
    final Set<Hero> badHeroes = new HashSet<>();

    public static final HeroMap BATTLEFIELD_OF_ETERNITY, BLACKHEARTS_BAY,
            CURSED_HOLLOW, DRAGON_SHIRE, GARDEN_OF_TERROR, HAUNTED_MINES, INFERNAL_SHRINES,
            SKY_TEMPLE, TOMB_OF_THE_SPIDER_QUEEN, TOWERS_OF_DOOM;

    public static final Set<HeroMap> ALL_MAPS = new HashSet<>();

    static {
        BATTLEFIELD_OF_ETERNITY = new HeroMap("Battlefield of Eternity");
        ALL_MAPS.add(BATTLEFIELD_OF_ETERNITY);
        BLACKHEARTS_BAY = new HeroMap("Blackheart's Bay");
        ALL_MAPS.add(BLACKHEARTS_BAY);
        CURSED_HOLLOW = new HeroMap("Cursed Hollow");
        ALL_MAPS.add(CURSED_HOLLOW);
        DRAGON_SHIRE = new HeroMap("Dragon Shire");
        ALL_MAPS.add(DRAGON_SHIRE);
        GARDEN_OF_TERROR = new HeroMap("Garden of Terror");
        ALL_MAPS.add(GARDEN_OF_TERROR);
        HAUNTED_MINES = new HeroMap("Haunted Mines");
        ALL_MAPS.add(HAUNTED_MINES);
        INFERNAL_SHRINES = new HeroMap("Infernal Shrines");
        ALL_MAPS.add(INFERNAL_SHRINES);
        SKY_TEMPLE = new HeroMap("Sky Temple");
        ALL_MAPS.add(SKY_TEMPLE);
        TOMB_OF_THE_SPIDER_QUEEN = new HeroMap("Tomb of the Spider Queen");
        ALL_MAPS.add(TOMB_OF_THE_SPIDER_QUEEN);
        TOWERS_OF_DOOM = new HeroMap("Towers of Doom");
        ALL_MAPS.add(TOWERS_OF_DOOM);
    }

    void addGoodHero(Hero hero) {
        goodHeroes.add(hero);
    }

    void addBadHero(Hero hero) {
        badHeroes.add(hero);
    }

    private HeroMap(String name) {
        this.name = name;
    }

    static Optional<HeroMap> getHeroMapByName(String name) {
        for (HeroMap heroMap : ALL_MAPS) {
            if (heroMap.name.equals(name)) {
                return Optional.of(heroMap);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return name;
    }
}

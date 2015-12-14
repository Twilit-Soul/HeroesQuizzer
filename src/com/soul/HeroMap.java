package com.soul;

import java.util.Optional;

/**
 * Heroes maps.
 * Created by Mitchell on 12/14/2015.
 */
public enum HeroMap {
    INFERNAL_SHRINES("Infernal Shrines"),
    BATTLEFIELD_OF_ETERNITY("Battlefield of Eternity"),
    TOMB_OF_THE_SPIDERQUEEN("Tomb of the Spider Queen"),
    SKY_TEMPLE("Sky Temple"),
    GARDEN_OF_TERROR("Garden of Terror"),
    BLACKHEARTS_BAY("Blackheart's Bay"),
    DRAGON_SHIRE("Dragon Shire"),
    CURSED_HOLLOW("Cursed Hollow"),
    HAUNTED_MINES("Haunted Mines"),
    TOWERS_OF_DOOM("Towers of Doom");

    private final String name;

    private HeroMap(String name) {
        this.name = name;
    }

    static Optional<HeroMap> getHeroMapByName(String name) {
        for (HeroMap heroMap : values()) {
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

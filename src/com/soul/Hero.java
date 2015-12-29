package com.soul;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Contains a Heroes best/worst maps, and synergies/counters.
 * Created by Mitchell on 12/14/2015.
 */
public class Hero {
    final String name;
    final Set<Hero> counters = new HashSet<>();
    final Set<Hero> synergies = new HashSet<>();
    final Set<HeroMap> strongMaps = new HashSet<>();
    final Set<HeroMap> weakMaps = new HashSet<>();

    public static final Hero ILLIDAN, SYLVANAS, JAINA, FALSTAD, KERRIGAN,
            RAYNOR, TYCHUS, GALL, LUNARA, THE_BUTCHER, VALLA, GREYMANE,
            KAELTHAS, NOVA, THRALL, ZERATUL, ANUBARAK, CHEN, ETC, MURADIN,
            STITCHES, ARTANIS, CHO, JOHANNA, REXXAR, TYRAEL, ARTHAS, DIABLO,
            LEORIC, SONYA, BRIGHTWING, LT_MORALES, TASSADAR, KHARAZIM, MALFURION,
            TYRANDE, LI_LI, REHGAR, UTHER, ABATHUR, MURKY, AZMODAN, NAZEEBO,
            THE_LOST_VIKINGS, GAZLOWE, SGT_HAMMER, ZAGARA;

    public static final Set<Hero> ALL_HEROES = new HashSet<>();

    static {
        System.out.println("Initializing heroes...");
        ILLIDAN = new Hero("Illidan");
        ALL_HEROES.add(ILLIDAN);
        SYLVANAS = new Hero("Sylvanas");
        ALL_HEROES.add(SYLVANAS);
        JAINA = new Hero("Jaina");
        ALL_HEROES.add(JAINA);
        FALSTAD = new Hero("Falstad");
        ALL_HEROES.add(FALSTAD);
        KERRIGAN = new Hero("Kerrigan");
        ALL_HEROES.add(KERRIGAN);
        RAYNOR = new Hero("Raynor");
        ALL_HEROES.add(RAYNOR);
        TYCHUS = new Hero("Tychus");
        ALL_HEROES.add(TYCHUS);
        GALL = new Hero("Gall");
        ALL_HEROES.add(GALL);
        LUNARA = new Hero("Lunara");
        ALL_HEROES.add(LUNARA);
        THE_BUTCHER = new Hero("The Butcher");
        ALL_HEROES.add(THE_BUTCHER);
        VALLA = new Hero("Valla");
        ALL_HEROES.add(VALLA);
        GREYMANE = new Hero("Greymane");
        ALL_HEROES.add(GREYMANE);
        KAELTHAS = new Hero("Kael'Thas");
        ALL_HEROES.add(KAELTHAS);
        NOVA = new Hero("Nova");
        ALL_HEROES.add(NOVA);
        THRALL = new Hero("Thrall");
        ALL_HEROES.add(THRALL);
        ZERATUL = new Hero("Zeratul");
        ALL_HEROES.add(ZERATUL);
        ANUBARAK = new Hero("Anub'arak");
        ALL_HEROES.add(ANUBARAK);
        CHEN = new Hero("Chen");
        ALL_HEROES.add(CHEN);
        ETC = new Hero("E.T.C");
        ALL_HEROES.add(ETC);
        MURADIN = new Hero("Muradin");
        ALL_HEROES.add(MURADIN);
        STITCHES = new Hero("Stitches");
        ALL_HEROES.add(STITCHES);
        ARTANIS = new Hero("Artanis");
        ALL_HEROES.add(ARTANIS);
        CHO = new Hero("Cho");
        ALL_HEROES.add(CHO);
        JOHANNA = new Hero("Johanna");
        ALL_HEROES.add(JOHANNA);
        REXXAR = new Hero("Rexxar");
        ALL_HEROES.add(REXXAR);
        TYRAEL = new Hero("Tyrael");
        ALL_HEROES.add(TYRAEL);
        ARTHAS = new Hero("Arthas");
        ALL_HEROES.add(ARTHAS);
        DIABLO = new Hero("Diablo");
        ALL_HEROES.add(DIABLO);
        LEORIC = new Hero("Leoric");
        ALL_HEROES.add(LEORIC);
        SONYA = new Hero("Sonya");
        ALL_HEROES.add(SONYA);
        BRIGHTWING = new Hero("Brightwing");
        ALL_HEROES.add(BRIGHTWING);
        LT_MORALES = new Hero("Lt. Morales");
        ALL_HEROES.add(LT_MORALES);
        TASSADAR = new Hero("Tassadar");
        ALL_HEROES.add(TASSADAR);
        KHARAZIM = new Hero("Kharazim");
        ALL_HEROES.add(KHARAZIM);
        MALFURION = new Hero("Malfurion");
        ALL_HEROES.add(MALFURION);
        TYRANDE = new Hero("Tyrande");
        ALL_HEROES.add(TYRANDE);
        LI_LI = new Hero("Li Li");
        ALL_HEROES.add(LI_LI);
        REHGAR = new Hero("Rehgar");
        ALL_HEROES.add(REHGAR);
        UTHER = new Hero("Uther");
        ALL_HEROES.add(UTHER);
        ABATHUR = new Hero("Abathur");
        ALL_HEROES.add(ABATHUR);
        MURKY = new Hero("Murky");
        ALL_HEROES.add(MURKY);
        AZMODAN = new Hero("Azmodan");
        ALL_HEROES.add(AZMODAN);
        NAZEEBO = new Hero("Nazeebo");
        ALL_HEROES.add(NAZEEBO);
        THE_LOST_VIKINGS = new Hero("The Lost Vikings");
        ALL_HEROES.add(THE_LOST_VIKINGS);
        GAZLOWE = new Hero("Gazlowe");
        ALL_HEROES.add(GAZLOWE);
        SGT_HAMMER = new Hero("Sgt. Hammer");
        ALL_HEROES.add(SGT_HAMMER);
        ZAGARA = new Hero("Zagara");
        ALL_HEROES.add(ZAGARA);

        HeroAndMapLoader heroLoader = new HeroAndMapLoader();
        ALL_HEROES.forEach(heroLoader::load);

        for (Hero hero : ALL_HEROES) {
            System.out.println("Hero: "+hero);
            for (Hero synergy : hero.synergies) {
                System.out.println("Synergy: "+synergy);
            }
            for (Hero counter : hero.counters) {
                System.out.println("Counter: "+counter);
            }
            for (HeroMap heroMap : hero.weakMaps) {
                System.out.println("Weak Map: "+heroMap);
            }
            for (HeroMap heroMap : hero.strongMaps) {
                System.out.println("Strong Map: "+heroMap);
            }
            System.out.println("\n");
        }

        for (HeroMap heroMap : HeroMap.ALL_MAPS) {
            System.out.println("\nHeroMap: "+heroMap);
            for (Hero hero : heroMap.goodHeroes) {
                System.out.println("Good hero: "+hero);
            }
            for (Hero hero : heroMap.badHeroes) {
                System.out.println("Bad hero: "+hero);
            }
        }
        System.out.println("Hero initialization complete.");
    }

    public static Optional<Hero> getHeroByName(String name) {
        if (name != null) {
            for (Hero hero : ALL_HEROES) {
                if (hero.name.equalsIgnoreCase(name)) {
                    return Optional.of(hero);
                }
            }
            switch (name) {
                case "Kael'thas":
                case "KaelThas":
                case "Kaelthas":
                    return Optional.of(KAELTHAS);
                case "ETC":
                case "E.T.C.":
                case "E-T-C": //This is the only one that made me "wtf", guys
                    return Optional.of(ETC);
                case "Anubarak":
                case "Anub'arak":
                    return Optional.of(ANUBARAK);
            }
        }
        return Optional.empty();
    }

    private Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.soul;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Uses JSoup to check Icy Veins for latest info.
 * Created by Mitchell on 12/14/2015.
 */
class HeroAndMapLoader {
    private static final HashMap<Hero, Optional<Document>> heroPages = new HashMap<>();

    static {
        //I want to try and pull the info from online, but if I can't, just put an empty there.
        //Later on, I'll try to get the data if it's not empty, but if it is empty for some reason,
        //I'll just fall back to the most recent good values,
        //and give a warning to the user that it might be out of date.
        for (Hero hero : Hero.ALL_HEROES) {
            try {
                heroPages.put(hero, Optional.of(Jsoup.connect(getHeroURL(hero)).get()));
            } catch (IOException e) {
                heroPages.put(hero, Optional.empty());
            }
        }
    }

    public void load(Hero hero) {
        Optional<Document> documentOpt = heroPages.get(hero);
        if (documentOpt.isPresent()) {
            Document document = documentOpt.get();
            hero.synergies.addAll(getSynergies(document));
            hero.counters.addAll(getCounters(document));
            hero.badMaps.addAll(getMapWeaknesses(hero, document));
            hero.goodMaps.addAll(getMapStrengthes(hero, document));
        }
    }

    private Set<Hero> getSynergies(Document document) {
        Elements elements = document.select(".hero_portrait_good");
        Set<Hero> synergies = new HashSet<>();

        for (Element element : elements) {
            Optional<Hero> heroOpt = Hero.getHeroByName(element.attr("title"));
            if (heroOpt.isPresent()) {
                synergies.add(heroOpt.get());
            } else {
                System.out.println("Bad hero title: "+element.attr("title"));
            }
        }
        return synergies;
    }

    private Set<Hero> getCounters(Document document) {
        Elements elements = document.select(".hero_portrait_bad");
        Set<Hero> synergies = new HashSet<>();

        for (Element element : elements) {
            Optional<Hero> heroOpt = Hero.getHeroByName(element.attr("title"));
            if (heroOpt.isPresent()) {
                synergies.add(heroOpt.get());
            } else {
                System.out.println("Bad hero title: "+element.attr("title"));
            }
        }
        return synergies;
    }

    private Set<HeroMap> getMapStrengthes(Hero hero, Document document) {
        Elements elements = document.select(".heroes_tldr_maps_stronger a img");
        Set<HeroMap> synergies = new HashSet<>();

        for (Element element : elements) {
            Optional<HeroMap> heroMapOpt = HeroMap.getHeroMapByName(element.attr("title"));
            if (heroMapOpt.isPresent()) {
                synergies.add(heroMapOpt.get());
                heroMapOpt.get().addGoodHero(hero);
            } else {
                System.out.println("Bad map title: "+element.attr("title"));
            }
        }
        return synergies;
    }

    private Set<HeroMap> getMapWeaknesses(Hero hero, Document document) {
        Elements elements = document.select(".heroes_tldr_maps_weaker a img");
        Set<HeroMap> synergies = new HashSet<>();

        for (Element element : elements) {
            Optional<HeroMap> heroMapOpt = HeroMap.getHeroMapByName(element.attr("title"));
            if (heroMapOpt.isPresent()) {
                synergies.add(heroMapOpt.get());
                heroMapOpt.get().addBadHero(hero);
            } else {
                System.out.println("Bad map title: "+element.attr("title"));
            }
        }
        return synergies;
    }

    private static String getHeroURL(Hero hero) {
        if (hero == Hero.LT_MORALES) {
            return "http://www.icy-veins.com/heroes/lt-morales-build-guide";
        } else if (hero == Hero.SGT_HAMMER) {
            return "http://www.icy-veins.com/heroes/sgt-hammer-build-guide";
        }
        return "http://www.icy-veins.com/heroes/"+hero.toString().toLowerCase().replaceAll("'","").replaceAll(" ","-")
                .replaceAll("\\.","-")+"-build-guide";
    }
}

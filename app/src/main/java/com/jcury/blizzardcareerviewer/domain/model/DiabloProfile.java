package com.jcury.blizzardcareerviewer.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *{
 "battleTag": "Taturana#1562",
 "paragonLevel": 248,
 "paragonLevelHardcore": 20,
 "paragonLevelSeason": 0,
 "paragonLevelSeasonHardcore": 0,
 "guildName": "SLAYERS",
 "heroes": [{
 "id": 45536375,
 "name": "Volrath",
 "class": "wizard",
 "gender": 0,
 "level": 70,
 "kills": {
 "elites": 2397
 },
 "paragonLevel": 248,
 "hardcore": false,
 "seasonal": false,
 "dead": false,
 "last-updated": 1440661591
 }, {
 "id": 47172231,
 */

public class DiabloProfile implements Serializable{

    private String battleTag;
    private String paragonLevel;
    private String paragonLevelHardcore;
    private String paragonLevelSeason;
    private String paragonLevelSeasonHardcore;
    private ArrayList<DiabloHero> herois = new ArrayList<DiabloHero>();

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public String getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(String paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public String getParagonLevelHardcore() {
        return paragonLevelHardcore;
    }

    public void setParagonLevelHardcore(String paragonLevelHardcore) {
        this.paragonLevelHardcore = paragonLevelHardcore;
    }

    public String getParagonLevelSeason() {
        return paragonLevelSeason;
    }

    public void setParagonLevelSeason(String paragonLevelSeason) {
        this.paragonLevelSeason = paragonLevelSeason;
    }

    public String getParagonLevelSeasonHardcore() {
        return paragonLevelSeasonHardcore;
    }

    public void setParagonLevelSeasonHardcore(String paragonLevelSeasonHardcore) {
        this.paragonLevelSeasonHardcore = paragonLevelSeasonHardcore;
    }

    public void addHero (String id, String name, String gender, String isClass, String level){
        DiabloHero hero = new DiabloHero(id,  name,  gender,  isClass,  level);
        herois.add(hero);
    }

    public ArrayList<DiabloHero> getHerois() {
        return herois;
    }

    public void setHerois(ArrayList<DiabloHero> herois) {
        this.herois = herois;
    }
}

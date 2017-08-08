package com.jcury.blizzardcareerviewer.domain.dto;

import java.io.Serializable;

/**
 * Created by jcury on 20/07/2017.
 */

public class DiabloProfileDTO implements Serializable {

    private String battleTag;
    private String paragonLevel;
    private String paragonLevelHardcore;
    private String paragonLevelSeason;
    private String paragonLevelSeasonHardcore;
    private DiabloHeroDTO[] heroes;

    public DiabloHeroDTO[] getHeroes() {
        return heroes;
    }

    public void setHeroes(DiabloHeroDTO[] heroes) {
        this.heroes = heroes;
    }

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
}

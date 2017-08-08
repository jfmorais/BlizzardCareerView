package com.jcury.blizzardcareerviewer.domain.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import retrofit2.http.Field;

/**
 * Created by jcury on 03/08/2017.
 */

public class DiabloHeroDTO implements Serializable{
    private String id;
    private String name;
    @SerializedName("class")
    private String isClass;
    private String gender;
    private String level;
    private String paragonLevel;
    private String hardcore;
    private String seasonal;
    private String dead;
    @SerializedName("last-updated")
    private String isLastUpdated;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsClass() {
        return isClass;
    }

    public void setIsClass(String isClass) {
        this.isClass = isClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(String paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public String getHardcore() {
        return hardcore;
    }

    public void setHardcore(String hardcore) {
        this.hardcore = hardcore;
    }

    public String getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(String seasonal) {
        this.seasonal = seasonal;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getIsLastUpdated() {
        return isLastUpdated;
    }

    public void setIsLastUpdated(String isLastUpdated) {
        this.isLastUpdated = isLastUpdated;
    }

    @Override
    public String toString() {
        return "DiabloHeroDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isClass='" + isClass + '\'' +
                ", gender='" + gender + '\'' +
                ", level='" + level + '\'' +
                ", paragonLevel='" + paragonLevel + '\'' +
                ", hardcore='" + hardcore + '\'' +
                ", seasonal='" + seasonal + '\'' +
                ", dead='" + dead + '\'' +
                ", isLastUpdated='" + isLastUpdated + '\'' +
                '}';
    }
}

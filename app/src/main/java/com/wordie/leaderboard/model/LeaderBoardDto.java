package com.wordie.leaderboard.model;

public class LeaderBoardDto {

    private String name;
    private Integer score;
    private Integer hours;
    private String country;
    private String badgeUrl;

    public LeaderBoardDto() {
    }

    public LeaderBoardDto(String name, Integer score,Integer hours, String country, String imageUrl) {
        this.name = name;
        this.score = score;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "LeaderBoardDto{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", hours=" + hours +
                ", country='" + country + '\'' +
                ", imageUrl='" + badgeUrl + '\'' +
                '}';
    }
}

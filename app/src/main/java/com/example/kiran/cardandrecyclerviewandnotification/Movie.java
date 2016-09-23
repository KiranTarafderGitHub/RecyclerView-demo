package com.example.kiran.cardandrecyclerviewandnotification;

/**
 * Created by Kiran on 12-09-2016.
 */
public class Movie {
    private String title, genre, year; int imageresourceId;

     public final int[] coverImages = new int[]{
            R.drawable.madmax,
            R.drawable.insideout,
            R.drawable.starwar,
            R.drawable.shaunsheep,
            R.drawable.martian,
            R.drawable.missionimpossible,
            R.drawable.up,
            R.drawable.startrek,
            R.drawable.lego,
            R.drawable.ironmam,
            R.drawable.aliens,
            R.drawable.chickenrun,
            R.drawable.back2future,
            R.drawable.lostark,
            R.drawable.goldfinger,
            R.drawable.guardianofgalaxy
    };
    public final int[] coverImages2 = new int[]{
            R.drawable.madmax2,
            R.drawable.insideout2,
            R.drawable.starwar2,
            R.drawable.shaunsheep2,
            R.drawable.martian2,
            R.drawable.missionimpossible2,
            R.drawable.up2,
            R.drawable.startrek2,
            R.drawable.lego2,
            R.drawable.ironmam2,
            R.drawable.aliens2,
            R.drawable.chickenrun2,
            R.drawable.back2future2,
            R.drawable.lostark2,
            R.drawable.goldfinger2,
            R.drawable.guardianofgalaxy2
    };
    public final int[] coverImages3 = new int[]{
            R.drawable.madmax3,
            R.drawable.insideout3,
            R.drawable.starwar3,
            R.drawable.shaunsheep3,
            R.drawable.martian3,
            R.drawable.missionimpossible3,
            R.drawable.up3,
            R.drawable.startrek3,
            R.drawable.lego3,
            R.drawable.ironmam3,
            R.drawable.aliens3,
            R.drawable.chickenrun3,
            R.drawable.back2future3,
            R.drawable.lostark3,
            R.drawable.goldfinger3,
            R.drawable.guardianofgalaxy3
    };

    public Movie() {
    }

    public Movie(String title, String genre, String year, int imageResourceId) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.imageresourceId=imageResourceId;
    }
    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImage(int imageresourceId){
        this.imageresourceId=imageresourceId;
    }
    public int getImageresourceId(){
        return imageresourceId;
    }
}

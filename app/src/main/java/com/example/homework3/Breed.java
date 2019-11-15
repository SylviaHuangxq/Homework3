package com.example.homework3;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Breed {
    @PrimaryKey
    @SerializedName("id")
    private String breedID;
    private String name;
    private int imageDrawableId;
    private String description;


   // private List<Weight> weight;
    private String temperament;
    private String origin;
    @SerializedName("life_span")
    private String life;
    @SerializedName("wikipedia_url")
    private String link;
    @SerializedName("dog_friendly")
    private int dog;

 /*   public Breed(String breedID, String name,int imageDrawableId, String description, double weight, String temperament,
                 String origin, String life, String link, int dog) {
        this.breedID = breedID;
        this.name = name;
        this.imageDrawableId = imageDrawableId;
        this.description = description;
        this.weight = weight;
        this.temperament = temperament;
        this.origin = origin;
        this.life = life;
        this.link = link;
        this.dog = dog;
    }
*/

    public String getBreedID() {
        return breedID;
    }

    public void setBreedID(String breedID) {
        this.breedID = breedID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDog() {
        return dog;
    }

    public void setDog(int dog) {
        this.dog = dog;
    }



    public class Weight{
        @SerializedName("imperial")
        private String imperial;
        @SerializedName("metric")
        private String metric;

        public String getImperial() {
            return imperial;
        }

        public String getMetric() {
            return metric;
        }
    }

}

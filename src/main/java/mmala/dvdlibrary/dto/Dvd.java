/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmala.dvdlibrary.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author mmala
 */


public class Dvd {
   //DVD properties
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String userRating;
    private String studio;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.releaseDate);
        hash = 37 * hash + Objects.hashCode(this.mpaaRating);
        hash = 37 * hash + Objects.hashCode(this.directorName);
        hash = 37 * hash + Objects.hashCode(this.userRating);
        hash = 37 * hash + Objects.hashCode(this.studio);
        return hash;
    }

    //Equals and HashCode  - I can now assert on whole DVD objects to check their equality with another
    //DVD object
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    //the default toString onyl really serialises the objects class name and hashcode, not useful.
    //Overriding this method can allow us to print out all of the object's property values instead,
    //which allows for much faster insight into issues when reading test logs
    @Override
    public String toString() {
        return "Dvd{" + "title=" + title + ", releaseDate=" + releaseDate + ", mpaaRating=" + mpaaRating + ", directorName=" + directorName + ", userRating=" + userRating + ", studio=" + studio + '}';
    }

    
    
    //Constructors
    public Dvd(String title) {
        this.title = title;
    }
    
    // getters and setters
    public String getTitle() {
        return title;
    }

    //no setter for title as it is read-only as title is passed in as a parameter
    //to the constructor

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
     
}

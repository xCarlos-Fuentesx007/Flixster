package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

// Annotate the class with the @Parcel decorator
@Parcel
public class Movie {

    String posterPath;
    String title;
    String overview;
    String backdropPath;
    double rating;

    int votecount;
    String releaseDate;
    int movieId;

    // Create public constructor with no arguments for the annotation library
    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");

        votecount = jsonObject.getInt("vote_count");
        releaseDate = jsonObject.getString("release_date");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() { return rating; }

    public String getVotecount() {
        return ("Votes: " + votecount);
    }

    public String getReleaseDate() {
        return ("Release Date: " + releaseDate);
    }

    public int getMovieId() { return movieId; }
}

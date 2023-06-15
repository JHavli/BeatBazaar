package jhavli.musicStore.BeatBazaar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "instruments")
public class Instrument {
    @Id
    private String id;
    private String name;
    private double price;
    private List<String> genres;

    public Instrument(String id, String name, double price, List<String> genres) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.genres = genres;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}

package org.example;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "album")
public class Card {

    @Id
    private int id;

    private String name;
    private String cardCode;
    private int quantity;
    private int year;
    private String language;

    @Nullable
    private String rarity;
    @Nullable
    private int pokedexNumber;
    @Nullable
    private float price;
    @Nullable
    private String generation;

    public Card(int id, String name, String cardCode, int quantity, int year, String language, @Nullable String rarity, int pokedexNumber, float price, @Nullable String generation) {
        this.id = id;
        this.name = name;
        this.cardCode = cardCode;
        this.quantity = quantity;
        this.year = year;
        this.language = language;
        this.rarity = rarity;
        this.pokedexNumber = pokedexNumber;
        this.price = price;
        this.generation = generation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Nullable
    public String getRarity() {
        return rarity;
    }

    public void setRarity(@Nullable String rarity) {
        this.rarity = rarity;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Nullable
    public String getGeneration() {
        return generation;
    }

    public void setGeneration(@Nullable String generation) {
        this.generation = generation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id && quantity == card.quantity && year == card.year && pokedexNumber == card.pokedexNumber && Float.compare(price, card.price) == 0 && Objects.equals(name, card.name) && Objects.equals(cardCode, card.cardCode) && Objects.equals(language, card.language) && Objects.equals(rarity, card.rarity) && Objects.equals(generation, card.generation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cardCode, quantity, year, language, rarity, pokedexNumber, price, generation);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", quantity=" + quantity +
                ", year=" + year +
                ", language='" + language + '\'' +
                ", rarity='" + rarity + '\'' +
                ", pokedexNumber=" + pokedexNumber +
                ", price=" + price +
                ", generation='" + generation + '\'' +
                '}';
    }
}

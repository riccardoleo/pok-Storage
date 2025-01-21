package org.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "album")
public class Card {

    @Id
    private String id;
    private String name;
    private String generation;
    private String cardCode;
    private float price;

    public Card(String id, String name, String generation, String cardCode, float price) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.cardCode = cardCode;
        this.price = price;
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

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Float.compare(price, card.price) == 0 && Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(generation, card.generation) && Objects.equals(cardCode, card.cardCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, generation, cardCode, price);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", generation='" + generation + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", price=" + price +
                '}';
    }

    public List findAll(){
        List list = new ArrayList();
        list.add(this);
        return list;
    }
}

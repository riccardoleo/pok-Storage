package org.example.testpokestorage.card;

public class CommonFields {

    public String id;
    public String localId;
    public String name;
    public String image;
    public String category;
    public String illustratior;
    public String rarity;
    public static class Variant{
        public Boolean normal;
        public Boolean reverse;
        public Boolean holo;
        public Boolean firstedition;
    }
    public Variant variant;
    public static class SetBrief{
        public String id;
        public String name;
        public String logo;
        public String Symbol;
        public class CardCount{
            public int total;
            public int official;
        }
    }
    public SetBrief setBrief;
    public SetBrief.CardCount cardCount;
}

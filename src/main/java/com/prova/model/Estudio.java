package com.prova.model;

import java.util.LinkedList;
import java.util.List;


public class Estudio {

    private List<Item> studios = new LinkedList<>();

    public Estudio() {
    }

    public List<Item> getStudios() {
        return studios;
    }

    public void setStudios(List<Item> studios) {
        this.studios = studios;
    }
    
    public static class Item {

        private String name;
        private Integer winCount;

        public Item(String name, Integer winCount) {
            this.name = name;
            this.winCount = winCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getWinCount() {
            return winCount;
        }

        public void setWinCount(Integer winCount) {
            this.winCount = winCount;
        }
    }

}

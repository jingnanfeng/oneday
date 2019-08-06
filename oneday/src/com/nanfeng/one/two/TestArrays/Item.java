package com.nanfeng.one.two.TestArrays;

import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-05 10:09
 */
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String description,int partNumber){
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber,o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }

}

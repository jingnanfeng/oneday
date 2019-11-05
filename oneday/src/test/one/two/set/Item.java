package test.one.two.set;

import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-17 12:02
 */
public class Item implements Comparable<Item> {

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
    public boolean equals(Object otherObject){
        if (this == otherObject){
            return true;
        }
        if (otherObject == null){
            return false;
        }
        if (getClass() != otherObject.getClass()){
            return false;
        }
        Item other = (Item)otherObject;
        return Objects.equals(description,other.description)
                && partNumber == other.partNumber;
    }

    @Override
    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber,o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}

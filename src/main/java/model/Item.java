package model;

import java.util.Objects;

/**
 * Represents an item in the system, typically used in inventory or sales.
 * Each item has an ID, name, price, and quantity in stock.
 */
public class Item {

    private int id;
    private String name;
    private double price;
    private int quantity;

    /**
     * Default constructor.
     * Creates an empty {@code Item} object with no initialized values.
     */
    public Item() {}

    /**
     * Constructs a new {@code Item} with all attributes including ID.
     *
     * @param id the unique identifier of the item
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item in stock
     */
    public Item(int id, String name, double price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Constructs a new {@code Item} without an ID.
     * This can be useful before the item is saved into a database.
     *
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item in stock
     */
    public Item(String name, double price, int quantity) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters & Setters

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the item in stock.
     *
     * @return the quantity of items
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item in stock.
     *
     * @param quantity the number of items
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        return id == other.id && Objects.equals(name, other.name)
                && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
                && quantity == other.quantity;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}

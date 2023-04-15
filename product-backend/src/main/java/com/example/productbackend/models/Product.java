package com.example.productbackend.models;

public class Product {

     // atributos

     private int id;
     private String name;
     private String description;
     private boolean promotion;
     private boolean newProduct;
     private int idCategory;
     private double price;

     // construtores

     public Product(int id, String name, double price) {
          this.id = id;
          this.name = name;
          this.price = price;

     }

     public Product() {

     }

     public Product(int id, String name, String description, boolean promotion, boolean newProduct, int idCategory,
               double price) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.promotion = promotion;
          this.newProduct = newProduct;
          this.idCategory = idCategory;
          this.price = price;
     }

     // metodos
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

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public boolean isPromotion() {
          return promotion;
     }

     public void setPromotion(boolean promotion) {
          this.promotion = promotion;
     }

     public boolean isNewProduct() {
          return newProduct;
     }

     public void setNewProduct(boolean newProduct) {
          this.newProduct = newProduct;
     }

     public int getIdCategory() {
          return idCategory;
     }

     public void setIdCategory(int idCategory) {
          this.idCategory = idCategory;
     }

}

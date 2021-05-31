package com.ma.Bookshop.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

 public class Book {
  @Entity
  @Table(name = "books_table")
  @Data
  @NoArgsConstructor
  public static class Books {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer id;

   @Column
   public String name;

   @Column
   public String title;

   @Column
   public String author;

   @Column
   public double  price;
  }

}

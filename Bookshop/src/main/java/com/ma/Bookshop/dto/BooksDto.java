package com.ma.Bookshop.dto;

    import lombok.Builder;
    import lombok.Data;

    @Data
    @Builder
    public class BooksDto {

        private Integer id;
        private String name;
        private String title;
        private String author;
        private double price;
    }

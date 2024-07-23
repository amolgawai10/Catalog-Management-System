package com.application.demo.catalog_management_system.Entity;

import com.application.demo.catalog_management_system.Enum.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    private String description;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    private Date createdOn;

    private Date updatedOn;
}

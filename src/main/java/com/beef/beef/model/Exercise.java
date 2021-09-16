package com.beef.beef.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "exerises")
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    private int basicWeight;

    private int seriesAmount;

    private int amount;

    private int progress;

    private int weeksAmount;

    @ManyToOne
    private Training training;

}

package com.projects.github.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipcode;
}

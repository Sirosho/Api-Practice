package com.spring.apipractice.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

private Long id;
private String name;
private int age;
private Position position;
private double war;
private LocalDateTime createdAt;

}

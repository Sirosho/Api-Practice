package com.spring.apipractice.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Player(ResultSet rs)throws SQLException {
        String posName = rs.getString("position");
        this.id = rs.getLong("id");
        this.name = rs.getString("name");
        this.age = rs.getInt("age");
        this.position = getPos(posName);
        this.war = rs.getDouble("war");
        this.createdAt = rs.getTimestamp("created_at").toLocalDateTime();
    }


    // db의 Enum 값을 Java의 enum으로 변환하는 매서드
    public Position getPos(String pos){

        for (Position position : Position.values()) {

            if(position.getPosName().equals(pos))
                return position;

        }
        throw new IllegalArgumentException("Unknown position: " + pos);

    }


}

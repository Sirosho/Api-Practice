package com.spring.apipractice.entity;

import lombok.*;


@Getter
public enum Position {
    P("투수"),
    C("포수"),
    ONE("1루수"),
    SEC("2루수"),
    THR("3루수"),
    SS("유격수"),
    OUT("외야수")
    ;

    private final String posName;

    Position(String name) {
        this.posName = name;
    }
    @Override
    public String toString() {
        return posName;
    }


}

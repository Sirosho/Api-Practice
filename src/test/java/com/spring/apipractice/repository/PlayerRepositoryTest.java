package com.spring.apipractice.repository;

import com.spring.apipractice.entity.Player;
import com.spring.apipractice.entity.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;


    @Test
    @DisplayName("모든 선수들의 정보를 출력")
    public void testAllPlayers(){

        List<Player> playerList = playerRepository.findAll();

        playerList.forEach(System.out::println);
    }

    @Test
    @DisplayName("선수 정보를 주면 데이터베이스 players 테이블에 저장")
    public void testAddPlayers(){
        Player player = Player.builder()
                .name("백승현")
                .age(33)
                .position(Position.P)
                .war(3.3)
                .build();

        boolean flag = playerRepository.addPlayer(player);

        assertTrue(flag);


    }





}
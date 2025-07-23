package com.spring.apipractice.repository;

import com.spring.apipractice.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {

    private final DataSource dataSource;

    // 선수 전체 조회

    public List<Player> findAll() {

        try(Connection conn = dataSource.getConnection()){
            String sql = "select * from players";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){


            }


        }catch(Exception e){
            e.printStackTrace();
        }


    }





}

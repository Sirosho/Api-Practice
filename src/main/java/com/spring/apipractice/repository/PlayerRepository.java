package com.spring.apipractice.repository;

import com.spring.apipractice.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {

    private final DataSource dataSource;

    // 선수 전체 조회

    public List<Player> findAll() {
        List<Player> playersList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                    SELECT id,
                           name,
                           age,
                           war,
                           position,
                           to_char(created_at,'YYYY-MM-DD')
                    from players
                  
                    """;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                playersList.add(new Player(rs));

            }

            return playersList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 선수 등록

    public boolean addPlayer(Player player) {

        try (Connection conn = dataSource.getConnection()) {

            String sql = """
                    INSERT INTO players
                        (name, age, position, war)
                    VALUES(?,?,?,?)
                    """;
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getAge());
            pstmt.setString(3, player.getPosition().toString());
            pstmt.setDouble(4, player.getWar());
            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

}

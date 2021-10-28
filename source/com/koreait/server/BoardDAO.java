package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;




public class BoardDAO {
    public static void main(String[] args){
        BoardVO param = new BoardVO();
        param.setTitle("sad");
        param.setCtnt("asdasd");
        param.setWriter("균기");
        insBoard(param);

    }


    public static int insBoard(BoardVO vo){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title,ctnt,writer)" +
                " VALUES (?,?,?) ";
        try{
            con = DbUtils.getCon();
            ps=con.prepareStatement(sql);
            ps.setString(1,vo.getTitle());
            ps.setString(2,vo.getCtnt());
            ps.setString(3,vo.getWriter());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
             DbUtils.close(con,ps);
        }
        return 0;
    }
}

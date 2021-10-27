package com.korea.it;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.korea.it.DbUtils.dbUtils;

/*public static void main(String[] args){
        StudentVO vo = new StudentVO();
        vo.setNm("륜");
        vo.setAge(50);
        vo.setAddr("반야월");
        insStudent(vo);
        }
public static DbUtils dbUtils = DbUtils.getInstance();
*/




public class StudentDAO {
    //레코드 insert ~~ 메소드
    public static int insStudent(StudentVO vo){
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_student3" +
                "(nm,age,addr)"+"VALUES"+"(?,?,?)";
        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,vo.getNm());
            ps.setInt(2,vo.getAge());
            ps.setString(3,vo.getAddr());
            result = ps.executeUpdate();
        }catch (Exception e){


            e.printStackTrace();
        }finally {
            dbUtils.close(con,ps);
        }
        return result;
    }
    public static void main(String[] args){
        StudentVO vo = new StudentVO();
        vo.setNm("륜");
        vo.setAge(50);
        vo.setAddr("반야월");

        insStudent(vo);
    }
    public static DbUtils dbUtils = DbUtils.getInstance();



}

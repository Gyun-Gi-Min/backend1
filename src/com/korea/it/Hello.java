package com.korea.it;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class Hello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //쿼리 파라미터로 받았을때
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name : "+ name);
        System.out.println("age : "+ age);

        //객체를 만들어서 받아왔을떄
        PrintWriter out = res.getWriter();
        TestVO vo = new TestVO();
        vo.setName("GG");
        vo.setAge(27);

        //포맷형식으로 받았을때?ㄴ
        String result = String.format("{ \"name\": \"%s\", \"age\":%s}",vo.getName(),vo.getAge()) ;
        System.out.println("result : "+ result);

        Gson gson = new Gson();
        String result2 = gson.toJson(vo);

        TestVO vo2 = gson.fromJson(result2,TestVO.class);


        System.out.println("result2 : "+ result2);
        out.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String data = Utils.getJson(req);
        System.out.println(data);

        Gson gson = new Gson();
        TestVO vo = gson.fromJson(data, TestVO.class);
        System.out.println(vo.getName());
        System.out.println(vo.getAge());

    }


}

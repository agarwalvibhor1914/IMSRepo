package com.ims.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ims.model.UserDetails;

@WebServlet("/javaAngularJS")
public class AngularJsServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public AngularJsServlet() {
                super();
        }

        protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        	UserDetails personData = new UserDetails();
                personData.setName("Mohaideen");
                personData.setTelephone("0687734740");

                String json = new Gson().toJson(personData);
                response.setContentType("application/json");
                response.getWriter().write(json);
        }
}
package com.bbles.automator.node.kernel.http.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class LogServletHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: return the list of element from the user
        Gson worker = new Gson();
        JsonObject jo = new JsonObject();
        jo.addProperty("name", "M.BENALLA");
        resp.setHeader("Content-Type", "applicatin/json");
        resp.getWriter().append(worker.toJson(jo));
    }
}

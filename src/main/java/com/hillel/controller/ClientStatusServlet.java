package com.hillel.controller;

import com.hillel.dao.ClientStatusDao;
import com.hillel.service.ClientStatusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClientStatusServlet extends HttpServlet {
    private final ClientStatusService clientStatusService = new ClientStatusService(new ClientStatusDao());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientStatuses", clientStatusService.findClientNameEmailStatus());
        req.getRequestDispatcher("views/clientStatus.jsp").forward(req, resp);
    }
}

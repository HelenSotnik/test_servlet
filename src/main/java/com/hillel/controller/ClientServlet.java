package com.hillel.controller;

import com.hillel.controller.util.LogControllerMessageUtil;
import com.hillel.dao.ClientDao;
import com.hillel.service.ClientService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientServlet.class.getName());
    private static final String SERVLET_NAME = "CLIENT SERVLET";

    private final ClientService clientService = new ClientService(new ClientDao());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("clients", clientService.findAllClients());
            req.getRequestDispatcher("views/client.jsp").forward(req, resp);

        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }
}

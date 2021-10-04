package com.hillel.controller;

import com.hillel.controller.util.LogControllerMessageUtil;
import com.hillel.dao.ClientStatusDao;
import com.hillel.service.ClientStatusService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClientStatusServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientStatusServlet.class.getName());
    private static final String SERVLET_NAME = "CLIENT STATUS SERVLET";

    private final ClientStatusService clientStatusService = new ClientStatusService(new ClientStatusDao());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("clientStatuses", clientStatusService.findClientNameEmailStatus());
            req.getRequestDispatcher("views/clientStatus.jsp").forward(req, resp);

        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }
}

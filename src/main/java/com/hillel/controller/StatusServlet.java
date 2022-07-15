package com.hillel.controller;

import com.hillel.controller.util.LogControllerMessageUtil;
import com.hillel.dao.StatusDao;
import com.hillel.service.StatusService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/statuses")
public class StatusServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(StatusServlet.class.getName());
    private static final String SERVLET_NAME = "STATUS SERVLET";

    private final StatusService statusService = new StatusService(new StatusDao());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("statuses", statusService.findAllStatuses());
            req.getRequestDispatcher("views/status.jsp").forward(req, resp);

        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }
}

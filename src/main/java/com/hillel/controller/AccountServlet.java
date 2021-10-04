package com.hillel.controller;

import com.hillel.controller.util.LogControllerMessageUtil;
import com.hillel.dao.AccountDao;
import com.hillel.service.AccountService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AccountServlet.class.getName());
    private static final String SERVLET_NAME = "ACCOUNT SERVLET";

    private final AccountService accountService = new AccountService(new AccountDao());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("accounts", accountService.findAllAccounts());
            req.getRequestDispatcher("views/account.jsp").forward(req, resp);

        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }
}

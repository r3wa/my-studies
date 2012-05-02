package br.com.mystudies.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Robson
 */
@WebServlet("/theme")
public class ThemeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


    public ThemeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToThemePage(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToThemePage(request, response);
	}


	
	private void sendToThemePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/theme/theme.jsp").forward(request, response);
	}

}

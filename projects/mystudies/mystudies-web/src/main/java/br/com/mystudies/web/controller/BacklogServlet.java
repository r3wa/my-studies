package br.com.mystudies.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.EnumType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.BackLog;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.service.BackLogService;

/**
 * @author Robson
 */
@WebServlet("/backlog")
public class BacklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@EJB
	private BackLogService backLogService;


    public BacklogServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToBackLogPage(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action =
				(String) request.getParameter("action");

		if( action != null){

			switch (action) {

			case "ADDTHEME":
				backLogService.addTheme(getBackLog(), getTheme(request));
				break;

			default:
				break;
			}

		}

		sendtoBackLogThemesFragment(request, response);
	}







	private Theme getTheme(HttpServletRequest request) {
		return new Theme(
				request.getParameter("title"),
				Priority.valueOf(request.getParameter("priority")),
				new Date()
			);
	}



	private BackLog getBackLog() {
		return backLogService.getBackLog(1L);
	}


	private void sendToBackLogPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("themes", getBackLog().getThemes());
		request.setAttribute("includeThemesFragment", true);
		request.getRequestDispatcher("backlog/backlog.jsp").forward(request, response);
	}


	private void sendtoBackLogThemesFragment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("themes", getBackLog().getThemes());
		request.getRequestDispatcher("backlog/themes-fragment.jsp").forward(request, response);
	}

}

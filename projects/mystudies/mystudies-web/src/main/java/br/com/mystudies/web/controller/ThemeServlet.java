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

import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.domain.enun.Status;
import br.com.mystudies.service.ThemeService;

/**
 * @author Robson
 */
@WebServlet("/theme")
public class ThemeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@EJB
	private ThemeService themeService;


    public ThemeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToThemePage(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = 
				request.getParameter("action");
		
		
		if(action != null){
			
			switch (action) {
			
				case "ADDSTORY":
					sendToThemeStoriesFragment(
						request, 
						response, 
						themeService.addStory(getTheme(request), getStory(request))
					);					
				break;

				default:
					sendToThemePage(request, response);			
					break;
				}
		}		
	}


	private Theme getTheme(HttpServletRequest request) {
		return themeService.getTheme(Long.valueOf(request.getParameter("themeId")));			
	}
	
	
	private Story getStory(HttpServletRequest request){
		return new Story(
				request.getParameter("title"), 
				Priority.valueOf(request.getParameter("priority")), 
				Status.SPRINT_BACKLOG, 
				new Date()
			);
	}
	
	private void sendToThemePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("theme", getTheme(request));
		request.setAttribute("includeThemesStoriesFragment", true);
		request.getRequestDispatcher("pages/theme/theme.jsp").forward(request, response);
	}

	
	private void sendToThemeStoriesFragment(HttpServletRequest request,HttpServletResponse response, Theme theme) throws ServletException, IOException {
		request.setAttribute("theme", theme);
		request.getRequestDispatcher("pages/theme/theme-stories-fragment.jsp").forward(request, response);
	}	
}

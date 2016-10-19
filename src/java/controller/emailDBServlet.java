/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Emailentry;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.EmailentryFacade;

@WebServlet(name = "emailDBServlet", urlPatterns = {"/emailDBServlet"})
public class emailDBServlet extends HttpServlet {

    @EJB
    private EmailentryFacade emailentrySessionObj;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "Search": {
                String lastName = request.getParameter("lastname");

                List<Emailentry> emailList = emailentrySessionObj.findByLastName(lastName);
                request.setAttribute("emailList", emailList);
                break;

            }

            case "Show All": {
                List<Emailentry> emailList = emailentrySessionObj.showAllRecords();
                request.setAttribute("emailList", emailList);
                break;
            }
            case "Edit": {
                int id = Integer.parseInt(request.getParameter("emailID"));
                List<Emailentry> emailList = emailentrySessionObj.findById(id);
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String emailAddress = request.getParameter("emailAddress");

                emailList.get(0).setId(id);
                emailList.get(0).setFirstname(firstName);
                emailList.get(0).setLastname(lastName);
                emailList.get(0).setEmailAddress(emailAddress);

                try {
                    emailentrySessionObj.edit(emailList.get(0));
                    String message = "Edit successful";
                    request.setAttribute("message1", message);
                } catch (Exception e) {
                    String message = "Edit failure";
                    request.setAttribute("message1", message);
                }
                break;
            }
            case "Delete": {
                int id = Integer.parseInt(request.getParameter("emailID"));
                List<Emailentry> emailList = emailentrySessionObj.findById(id);
                try {
                    emailentrySessionObj.deleteById(emailList.get(0));
                    String message = "Delete successful";
                    request.setAttribute("message2", message);
                } catch (Exception e) {
                    String message = "Delete failure";
                    request.setAttribute("message2", message);
                }
                break;
            }
            case "Total Records": {
                int count = emailentrySessionObj.getNumberOfRecords();
                String message = Integer.toString(count);
                request.setAttribute("message3", message);
                break;
            }
            default: {
                int id = Integer.parseInt(request.getParameter("emailID"));
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String EmailAddress = request.getParameter("emailAddress");
                emailentrySessionObj.persistEmailentryData(id, firstName, lastName, EmailAddress);
                List<Emailentry> emailList = emailentrySessionObj.findAll();
                request.setAttribute("emailList", emailList);
            }

        }
        getServletContext()
                .getRequestDispatcher("/editor.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

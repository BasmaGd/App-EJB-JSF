package controllers;


import entities.Login;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import services.LoginService;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {
    private String username;
    private String password;
    private Login loggedInAdmin;

    @EJB
    private LoginService adminService;

    public LoginController() {
    }

    
    // Méthode pour gérer la connexion
    public String login() {
        loggedInAdmin = adminService.findLoginByUsernameAndPassword(username, password);
        if (loggedInAdmin != null) {
            // Authentification réussie, redirigez vers la page suivante
            return "template.xhtml?faces-redirect=true";
        } else {
            // Authentification échouée, affichez un message d'erreur ou redirigez vers une page d'erreur
            return "errorPage.xhtml?faces-redirect=true";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login getLoggedInAdmin() {
        return loggedInAdmin;
    }

    public void setLoggedInAdmin(Login loggedInAdmin) {
        this.loggedInAdmin = loggedInAdmin;
    }

    public LoginService getAdminService() {
        return adminService;
    }

    public void setAdminService(LoginService adminService) {
        this.adminService = adminService;
    }

    
}

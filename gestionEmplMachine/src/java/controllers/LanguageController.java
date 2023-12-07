/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DELL
 */
@ManagedBean(name = "languageController")
@SessionScoped
public class LanguageController implements Serializable {

//     private String selectedLanguage;
     private int id;
    private String selectedLanguage = "en"; // Langue par défaut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public void changeLanguage() {
        // Vous pouvez stocker la langue sélectionnée dans la session ou les préférences utilisateur
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(selectedLanguage));
    }
}


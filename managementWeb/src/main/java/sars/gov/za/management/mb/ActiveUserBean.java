/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sars.gov.za.management.common.PersonType;
import sars.gov.za.management.common.SystemUserStatus;
import sars.gov.za.management.domain.User;

/**
 *
 * @author S2028873
 */
@ManagedBean
@SessionScoped
public class ActiveUserBean implements Serializable {
    
    private String username;
    private PersonType personType;
    private SystemUserStatus systemUserStatus;
    private String moduleWelcomeMessage;
    private String firstName;
    private String lastName;
    private String identifier;
    private boolean userLoginIndicator;
    private Router router = new Router();
    
    
    public ActiveUserBean() {
        userLoginIndicator = Boolean.FALSE;
    }
    
    public void setLoggedOnUserSession(User user) {
        
        if (user.getId() != null) {
            this.setUsername(user.getUserName());
            this.setFirstName(user.getFirstName());
            this.setLastName(user.getLastName());
            this.setPersonType(user.getPersonType());
            this.setSystemUserStatus(user.getSystemUserStatus());
            this.setIdentifier(user.getIdentifer());
            this.setUserLoginIndicator(true);
            
        }
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public PersonType getPersonType() {
        return personType;
    }
    
    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
    
    public SystemUserStatus getSystemUserStatus() {
        return systemUserStatus;
    }
    
    public void setSystemUserStatus(SystemUserStatus systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }
    
    public String getModuleWelcomeMessage() {
        return moduleWelcomeMessage;
    }
    
    public void setModuleWelcomeMessage(String moduleWelcomeMessage) {
        this.moduleWelcomeMessage = moduleWelcomeMessage;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public boolean isUserLoginIndicator() {
        return userLoginIndicator;
    }
    
    public void setUserLoginIndicator(boolean userLoginIndicator) {
        this.userLoginIndicator = userLoginIndicator;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
    
    
}

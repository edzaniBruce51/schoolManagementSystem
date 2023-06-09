/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.mb;

/**
 *
 * @author S2028873
 */
public class Router {

    private boolean adminstrator;
    private boolean educator;
    private boolean principal;
    private boolean hod;
    private boolean learner;

    public Router reset() {
        this.adminstrator =Boolean.FALSE;
        this.educator = Boolean.FALSE;
        this.principal = Boolean.FALSE;
        this.hod = Boolean.FALSE;
        this.learner = Boolean.FALSE;
        
        return this;
    }

    public boolean isAdminstrator() {
        return adminstrator;
    }

    public void setAdminstrator(boolean adminstrator) {
        this.adminstrator = adminstrator;
    }

    public boolean isEducator() {
        return educator;
    }

    public void setEducator(boolean educator) {
        this.educator = educator;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public boolean isHod() {
        return hod;
    }

    public void setHod(boolean hod) {
        this.hod = hod;
    }

    public boolean isLearner() {
        return learner;
    }

    public void setLearner(boolean learner) {
        this.learner = learner;
    }
    
  
}

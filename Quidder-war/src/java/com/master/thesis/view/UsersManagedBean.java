/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.view;

import com.master.thesis.ejb.ControlSessionBean;
import com.master.thesis.login.FacebookUser;
import com.master.thesis.login.JsonParser;
import com.master.thesis.login.TwitterUser;
import com.master.thesis.persistence.FacebookUserProfiles;
import com.master.thesis.persistence.GoalTags;
import com.master.thesis.persistence.Resources;
import com.master.thesis.persistence.ResourcesGoalsUsers;
import com.master.thesis.persistence.TwitterUserProfiles;
import com.master.thesis.persistence.UserAccounts;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Javier
 */
@ManagedBean
@SessionScoped
public class UsersManagedBean {

    @EJB
    private ControlSessionBean controlSessionBean;
    private UserAccounts currentUserAccount;
    private FacebookUserProfiles facebookUserProfiles;
    private TwitterUserProfiles twitterUserProfiles;
    private List<UserAccounts> userAccounts;
    private String imageUrl;
    private String provider;
    private TwitterUser currentTwitterUser;
    private FacebookUser currentFacebookUser;
    private String jsonUserDataProfile;
    private Integer ID;
    
    //para ResourcesGoalsUsers
    private Resources currentResource;    
    private GoalTags currentGoalTag;    
    private ResourcesGoalsUsers currentResourcesGoalsUsers;    
    private String goal;
    private Integer idResource;

    public UsersManagedBean() {
        ID = null;
        currentUserAccount = new UserAccounts();
        twitterUserProfiles = new TwitterUserProfiles();
        facebookUserProfiles = new FacebookUserProfiles();
        this.jsonUserDataProfile = null;
        currentTwitterUser = new TwitterUser();
        currentFacebookUser = new FacebookUser();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProvider() {
        //System.out.println("+provider: " + this.provider);
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        //System.out.println("-provider: " + this.provider);
    }

    public UserAccounts getCurrentUserAccount() {
        return currentUserAccount;
    }
    
    public UserAccounts obtainCurrentUserAccount() {
        return currentUserAccount;
    }

    public void setCurrentUserAccount(UserAccounts currentUserAccounts) {
        this.currentUserAccount = currentUserAccounts;
    }

    public List<UserAccounts> getUserAccount() {
        this.userAccounts = controlSessionBean.findAllUserAccounts();
        return userAccounts;
    }

    public void setUserAccount(List<UserAccounts> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public void loadUserAccount() {
        this.userAccounts = controlSessionBean.findAllUserAccounts();
    }

    public String addUserAccount() {
        System.out.println("userAccounts Saved");
        controlSessionBean.createUserAccount(currentUserAccount);
        return "SAVED";
    }

    public Resources getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(Resources currentResource) {
        this.currentResource = currentResource;
    }

    public GoalTags getCurrentGoalTag() {
        return currentGoalTag;
    }

    public void setCurrentGoalTag(GoalTags currentGoalTag) {
        this.currentGoalTag = currentGoalTag;
    }

    public ResourcesGoalsUsers getCurrentResourcesGoalsUsers() {
        return currentResourcesGoalsUsers;
    }

    public void setCurrentResourcesGoalsUsers(ResourcesGoalsUsers currentResourcesGoalsUsers) {
        this.currentResourcesGoalsUsers = currentResourcesGoalsUsers;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }        

    public Integer getIdResource() {
        return idResource;
    }

    public String findResourceById() {
        System.out.println("--find idResource: ");
        return "hola";
//        if(idResource != null){
//            this.currentResource = controlSessionBean.findResource(idResource);
//        }
        
    }
        
    /*
     * Los metodos siguientes corresponden a la clase TwitterUser, la cual es usada para instanciar un usuario
     * con los valores obtenidos en el JSON recuperado de la parte de Login con la red social elegida (Twitter).
     */
    public String twitterUserSession() {
        System.out.println("enter to Get Twitter Session");
        if (parserJsonUserTwitterDataProfile()) {
            currentUserAccount = controlSessionBean.findUserAccount(ID);
            twitterUserProfiles = controlSessionBean.findTwitterUserProfile(ID);
            if (currentUserAccount == null && twitterUserProfiles == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown Twitter login, try again"));
                createUserOnQuidder(null, currentTwitterUser);
                return "failed: Unknown Twitter login, try again";
            } else {
                System.out.println("Display Name: " + currentUserAccount.getDisplayName());
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                return "success";
            }
        } else if (!parserJsonUserTwitterDataProfile()) {
            return "init";
        } else {
            return "failed";
        }
    }

    public boolean parserJsonUserTwitterDataProfile() {
        if (this.jsonUserDataProfile != null) {
            System.out.println("jsonTwitterUserData: " + this.jsonUserDataProfile);
            JsonParser jsonParser = new JsonParser(this.jsonUserDataProfile, "twitter");
            this.currentTwitterUser = jsonParser.getTwitterUser();
            this.ID = Integer.parseInt(this.currentTwitterUser.getID());
            this.imageUrl = this.currentTwitterUser.getImageUrl();
            return true;
        } else {
            System.out.println("JsonUserDataProfile empty!");
            return false;
        }
    }

    public TwitterUserProfiles createUserTwitterProfile(TwitterUser twitterUser) {
        Integer userID = Integer.parseInt(twitterUser.getID());
        String userName = twitterUser.getFullName();
        String imgUrl = twitterUser.getImageUrl();
        String urlProfile = "https://twitter.com/" + twitterUser.getProfileName();
        String birthDate = twitterUser.getBirthDate();
        this.twitterUserProfiles = new TwitterUserProfiles(userID, userName, urlProfile);
        this.twitterUserProfiles.setTwitterImageUrl(imgUrl);
        this.twitterUserProfiles.setBirthDate(parserToDate(birthDate));
        return this.twitterUserProfiles;
    }

    public TwitterUser getCurrentTwitterUser() {
        return this.currentTwitterUser;
    }

    /*
     * Los metodos siguientes corresponden a la clase FacebookUser, la cual es usada para instanciar un usuario
     * con los valores obtenidos en el JSON recuperado de la parte de Login con la red social elegida (Facebook).
     */
    public String facebookUserSession() {
        System.out.println("enter to Get Twitter Session");
        if (parserJsonUserFacebookDataProfile()) {
            System.out.println("ID Facebook user: " + ID);
            currentUserAccount = controlSessionBean.findUserAccount(ID);
            facebookUserProfiles = controlSessionBean.findFacebookUserProfile(ID);
            if (currentUserAccount == null && facebookUserProfiles == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown Facebook login, try again"));
                createUserOnQuidder(currentFacebookUser, null);
                return "failed: Unknown Facebook login, try again";
            } else {
                System.out.println("Display Name: " + currentUserAccount.getDisplayName());
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("resources.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                return "success";
            }
        } else if (!parserJsonUserFacebookDataProfile()) {
            return "init";
        } else {
            return "failed";
        }
    }

    public boolean parserJsonUserFacebookDataProfile() {
        if (this.jsonUserDataProfile != null) {
            System.out.println("jsonFacebookUserData: " + this.jsonUserDataProfile);
            JsonParser jsonParser = new JsonParser(this.jsonUserDataProfile, "facebook");
            this.currentFacebookUser = new FacebookUser();
            this.currentFacebookUser = jsonParser.getFacebookuser();
            this.ID = Integer.parseInt(this.currentFacebookUser.getID());
            this.imageUrl = this.currentFacebookUser.getImageUrl();
//            String userFullName = this.currentFacebookUser.getFullName();
//            String userProfileName = this.currentFacebookUser.getProfileName();                        
//            String localCountry = this.currentFacebookUser.getLocalCountry();
//            System.out.println("ID: " + this.ID);
//            System.out.println("User Full Name: " + userFullName);
//            System.out.println("User Profile Name: " + userProfileName);
//            System.out.println("imageUrl: " + this.imageUrl);
//            System.out.println("birthDate: " + this.currentFacebookUser.getBirthDate());
//            System.out.println("localCountry: " + localCountry);
            return true;
        } else {
            System.out.println("JsonUserDataProfile empty!");
            return false;
        }
    }

    public FacebookUserProfiles createUserFacebookProfile(FacebookUser facebookUser) {
        Integer userID = Integer.parseInt(facebookUser.getID());
        String userName = facebookUser.getFullName();
        String localCountry = facebookUser.getLocalCountry();
        String imgUrl = facebookUser.getImageUrl();
        String urlProfile = "https://www.facebook.com/" + facebookUser.getProfileName();
        this.facebookUserProfiles = new FacebookUserProfiles(userID, userName, urlProfile);
        this.facebookUserProfiles.setLocalCountry(localCountry);
        this.facebookUserProfiles.setImageUrl(imgUrl);
        return this.facebookUserProfiles;
    }

    public FacebookUser getCurrentFacebookUser() {
        return this.currentFacebookUser;
    }

    /*
     * Los dos métodos siguientes permiten set/get del perfil del usuario contenido en el  Json devuelto por LoginRadius.
     */
    public String getJsonUserDataProfile() {
        return this.jsonUserDataProfile;
    }

    public void setJsonUserDataProfile(String jsonUserDataProfile) {
        this.jsonUserDataProfile = jsonUserDataProfile;
        System.out.println("-JsonProfile: " + this.jsonUserDataProfile);
    }

    /*
     * los métodos siguientes facilitan el manejo de sesión: Login, Logout y isLoggedIn.
     */
    public void login() {
        if (provider != null) {
            String p = this.provider;
            System.out.println("Login Provider: " + p);
            if (p.equalsIgnoreCase("facebook")) {
                System.out.println("enter to login by Facebook: " + facebookUserSession());
            } else if (p.equalsIgnoreCase("twitter")) {
                System.out.println("enter to login by Twitter: " + twitterUserSession());
            } else {
                System.out.println("init failed");
            }
        } else {
            System.out.println("provider is null");
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //return "index?faces-redirect=true";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("session ends");
        return "logout";
    }

    public boolean isLoggedIn() {
        System.out.println("enter to isLoggedIn");
        if (currentUserAccount.getIdUserAccount() != null) {            
            System.out.println("is not Null");
            return true;
        } else if (currentUserAccount.getIdUserAccount()== null){
            System.out.println("is Null");
//            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//            //return "index?faces-redirect=true";
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } else {
            System.out.println("something different happened");
            return false;
        }
    }

    /*
     * este método permite manejar la persistencia, facilitando la creación de un usuario en la base de datos de Quidder.
     */
    public void createUserOnQuidder(FacebookUser facebookUser, TwitterUser twitterUser) {
        Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
        if (facebookUser != null) {
            this.currentFacebookUser = facebookUser;
            this.currentUserAccount = new UserAccounts(
                    Integer.parseInt(this.currentFacebookUser.getID()),
                    this.currentFacebookUser.getFullName(),
                    this.currentFacebookUser.getFirstName(),
                    this.currentFacebookUser.getID(),
                    timestamp);
            this.currentUserAccount.setLocalCountry(this.currentFacebookUser.getLocalCountry());
            this.currentUserAccount.setGender(this.currentFacebookUser.getGender());
            this.facebookUserProfiles = createUserFacebookProfile(this.currentFacebookUser);
            controlSessionBean.createFacebookUserProfile(facebookUserProfiles);
            this.currentUserAccount.setFbUserProfile(this.facebookUserProfiles);
            controlSessionBean.createUserAccount(this.currentUserAccount);
        } else {
            this.currentTwitterUser = twitterUser;
            this.currentUserAccount = new UserAccounts(
                    Integer.parseInt(this.currentTwitterUser.getID()),
                    this.currentTwitterUser.getFullName(),
                    this.currentTwitterUser.getFirstName(),
                    this.currentTwitterUser.getID(),
                    timestamp);
            this.currentUserAccount.setLocalCountry(this.currentTwitterUser.getLocalCountry());
            this.currentUserAccount.setGender(this.currentTwitterUser.getGender());
            this.twitterUserProfiles = createUserTwitterProfile(this.currentTwitterUser);
            controlSessionBean.createTwitterUserProfile(this.twitterUserProfiles);
            this.currentUserAccount.setTwUserProfile(this.twitterUserProfiles);
            controlSessionBean.createUserAccount(this.currentUserAccount);
        }
    }
    
    public void createResourcesGoalsUsers() {
        System.out.println("enter to createResourcesGoalsUsers");
        Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
        System.out.println("timestamp: " + timestamp);
//        this.currentGoalTag.setTagName(goal);
//        this.currentResourcesGoalsUsers.setGoalTags(this.currentGoalTag);
//        this.currentResourcesGoalsUsers.setResources(this.currentResource);
//        this.currentResourcesGoalsUsers.setUserAccounts(this.currentUserAccount);
//        this.currentResourcesGoalsUsers.setTimestamp(timestamp);
//        this.controlSessionBean.createResourcesGoalsUsers(currentResourcesGoalsUsers);
    }

    /*
     * Este método auxiliar permite manejar datos tipo Date, para los atributos birthday y timestamp.
     */
    public Date parserToDate(String date) {
        System.out.println("Enter to Parser Data" + date);
        Date result = null;
        if (date == null) {
            date = "Thu Sep 28 00:00:00 JST 0000";
        }
        try {
            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy", Locale.ENGLISH);
            result = df.parse(date);
            System.out.println(result);
        } catch (ParseException ex) {
            System.out.println("Exception: " + ex.getMessage());
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        
}

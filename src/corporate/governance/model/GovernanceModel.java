/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporate.governance.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Faruoq
 */
public class GovernanceModel extends RecursiveTreeObject<GovernanceModel> {
    
    public StringProperty Age,Gender,Experience,Accountability,BoardCommitment,Sustainability,Independence,Fairness,Reputation,ControlEnvironment,Transparency,StakeholderInterface,Openness,CGPI;
    
    public GovernanceModel(){super();}

    public GovernanceModel(String Age, String Gender, String Experience, String Accountability, String BoardCommitment, String Sustainability, String Independence, String Fairness, String Reputation, String ControlEnvironment, String Transparency, String StakeholderInterface, String Openness, String CGPI) {
        this.Age = new SimpleStringProperty(Age);
        this.Gender = new SimpleStringProperty(Gender);
        this.Experience = new SimpleStringProperty(Experience);
        this.Accountability = new SimpleStringProperty(Accountability);
        this.BoardCommitment = new SimpleStringProperty(BoardCommitment);
        this.Sustainability = new SimpleStringProperty(Sustainability);
        this.Independence = new SimpleStringProperty(Independence);
        this.Fairness = new SimpleStringProperty(Fairness);
        this.Reputation = new SimpleStringProperty(Reputation);
        this.ControlEnvironment = new SimpleStringProperty(ControlEnvironment);
        this.Transparency = new SimpleStringProperty(Transparency);
        this.StakeholderInterface = new SimpleStringProperty(StakeholderInterface);
        this.Openness = new SimpleStringProperty(Openness);
        this.CGPI = new SimpleStringProperty(CGPI);
    }

    public StringProperty getAge() {
        return Age;
    }

    public void setAge(StringProperty Age) {
        this.Age = Age;
    }

    public StringProperty getGender() {
        return Gender;
    }

    public void setGender(StringProperty Gender) {
        this.Gender = Gender;
    }

    public StringProperty getExperience() {
        return Experience;
    }

    public void setExperience(StringProperty Experience) {
        this.Experience = Experience;
    }

    public StringProperty getAccountability() {
        return Accountability;
    }

    public void setAccountability(StringProperty Accountability) {
        this.Accountability = Accountability;
    }

    public StringProperty getBoardCommitment() {
        return BoardCommitment;
    }

    public void setBoardCommitment(StringProperty BoardCommitment) {
        this.BoardCommitment = BoardCommitment;
    }

    public StringProperty getSustainability() {
        return Sustainability;
    }

    public void setSustainability(StringProperty Sustainability) {
        this.Sustainability = Sustainability;
    }

    public StringProperty getIndependence() {
        return Independence;
    }

    public void setIndependence(StringProperty Independence) {
        this.Independence = Independence;
    }

    public StringProperty getFairness() {
        return Fairness;
    }

    public void setFairness(StringProperty Fairness) {
        this.Fairness = Fairness;
    }

    public StringProperty getReputation() {
        return Reputation;
    }

    public void setReputation(StringProperty Reputation) {
        this.Reputation = Reputation;
    }

    public StringProperty getControlEnvironment() {
        return ControlEnvironment;
    }

    public void setControlEnvironment(StringProperty ControlEnvironment) {
        this.ControlEnvironment = ControlEnvironment;
    }

    public StringProperty getTransparency() {
        return Transparency;
    }

    public void setTransparency(StringProperty Transparency) {
        this.Transparency = Transparency;
    }

    public StringProperty getStakeholderInterface() {
        return StakeholderInterface;
    }

    public void setStakeholderInterface(StringProperty StakeholderInterface) {
        this.StakeholderInterface = StakeholderInterface;
    }

    public StringProperty getOpenness() {
        return Openness;
    }

    public void setOpenness(StringProperty Openness) {
        this.Openness = Openness;
    }

    public StringProperty getCGPI() {
        return CGPI;
    }

    public void setCGPI(StringProperty CGPI) {
        this.CGPI = CGPI;
    }
    
}

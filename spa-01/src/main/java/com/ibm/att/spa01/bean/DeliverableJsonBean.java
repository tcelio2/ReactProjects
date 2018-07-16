package com.ibm.att.spa01.bean;

import java.util.List;

public class DeliverableJsonBean {

    
    private List<String> deliverable;
    private List<String> dateA;
    private List<String> dateB;
    private List<DeliverableJsonBean> groups;
    
    public DeliverableJsonBean(){
	
    }
    
    
    

    public List<String> getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(List<String> deliverable) {
        this.deliverable = deliverable;
    }

    public List<String> getDateA() {
        return dateA;
    }

    public void setDateA(List<String> dateA) {
        this.dateA = dateA;
    }

    public List<String> getDateB() {
        return dateB;
    }

    public void setDateB(List<String> dateB) {
        this.dateB = dateB;
    }




    public List<DeliverableJsonBean> getGroups() {
	return groups;
    }




    public void setGroups(List<DeliverableJsonBean> groups) {
	this.groups = groups;
    }

    
    
    
    
    
}

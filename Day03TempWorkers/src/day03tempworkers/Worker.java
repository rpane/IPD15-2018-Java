/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03tempworkers;

import java.util.Date;

/**
 *
 * @author 0639300
 */
public class Worker {

    private String name;
    private Date startDate;
    private Date endDate;

    public Worker(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @throws day03tempworkers.InvalidDataProvidedException
     */
    public void setName(String name) throws InvalidDataProvidedException 
    {
        if(name.isEmpty())
            throw new InvalidDataProvidedException("Name is Empty");
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     * @throws day03tempworkers.InvalidDataProvidedException
     */
    public void setStartDate(Date startDate) throws InvalidDataProvidedException 
    {
        if(startDate.compareTo(endDate) >0)
            throw new InvalidDataProvidedException("Start Date is after End Date");
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String toString() {
    	String res = getName()+" works from "+getStartDate()+" to "+getEndDate();
    	return res;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2travel;

import java.util.Date;

/**
 *
 * @author 0639300
 */
public class Travel {

    private String name;
    private String transport;
    private String destination;
    private Date depDate;

    public Travel(String name, String transport, String destination, Date depDate) throws InvalidParameterException {
        setName(name);
        this.transport = transport;
        setDestination(destination);
        setDepDate(depDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidParameterException {
        if(name.length()>20 || name.length()<2){
            throw new InvalidParameterException("Name must be above 2 and less than 20 \n"
                    + "characters long");
        }
        this.name = name;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws InvalidParameterException {
        if(destination.length()>20 || destination.length()<2){
            throw new InvalidParameterException("Destination must be above 2 and less than 20 \n"
                    + "characters long");
        }
        this.destination = destination;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) throws InvalidParameterException {
        
        /*
        if(!depDate.toString().matches("\\d{4}\\/\\d{2}\\/\\d{2}")){
            throw new InvalidParameterException("Must be written in YYYY/MM/DD format");
        }*/
        this.depDate = depDate;
    }

    @Override
    public String toString() {
                
        
        return  name +" "+ transport+" to "+getDestination()+ " on "+getDepDate();
    }

}

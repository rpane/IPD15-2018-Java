/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz1airporttravel;

/**
 *
 * @author 0639300
 */
public class Airport {
    private String code, city;
    private double latitude,longitude;

    public Airport(String code, String city, double latitude, double longitude){
           
        this.code = code;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     * @throws quiz1airporttravel.InvalidDataException
     */
    public void setCode(String code) throws InvalidDataException  {
        if(code.length() !=3 || isUpperCase(code) == false)
        {
            throw new InvalidDataException("Error. Code does not meet desired requirements /n "
                    + "Check to see that the length is 3 and the code is upperCase");
        }
        this.code = code;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) throws InvalidDataException {
        if(city.isEmpty() || city.equalsIgnoreCase("null"))
        {
           throw new InvalidDataException("Error. City is either Empty or is set to null"); 
        }
        this.city = city;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) throws InvalidDataException {
        if(latitude >= -90 || latitude <= 90)
        {
            throw new InvalidDataException("Error. Latitude is out of range.");
        }
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) throws InvalidDataException {
        if(longitude >= -180 || longitude <= 180)
        {
            throw new InvalidDataException("Error. Longitude is out of range.");
        }
        this.longitude = longitude;
    }
    
    public static boolean isUpperCase(String s)
{
    for (int i=0; i<s.length(); i++)
    {
        if (!Character.isUpperCase(s.charAt(i)))
        {
            return false;
        }
    }
    return true;
}
}

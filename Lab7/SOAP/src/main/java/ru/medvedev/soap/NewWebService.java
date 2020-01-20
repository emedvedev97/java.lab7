/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.medvedev.soap;

import java.math.BigDecimal;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.bind.JAXBException;

/**
 *
 * @author emedvedev
 */
@WebService()
public class NewWebService {
    
    ///static Jaxb jaxb = new Jaxb();
    /**
     * This is a sample web service operation
     */
    
    @WebMethod
    public List<ResponcePojo> getAreas(BigDecimal size) throws JAXBException {
        Jaxb jaxb = new Jaxb();
        return jaxb.getData(size);
    }
    
    
    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }

}

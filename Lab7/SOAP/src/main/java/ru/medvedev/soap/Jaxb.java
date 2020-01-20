/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.medvedev.soap;




import https.rsatu_ru.continents.ContinentType;
import https.rsatu_ru.continents.CountryType;
import https.rsatu_ru.continents.Planet;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author emedvedev
 */
public class Jaxb {

    private static final String PATH_XML = "/home/emedvedev/Java лабы/Lab7/SOAP/src/main/resources/world.xml";

    Planet planet;

    Jaxb() {
        try {
            System.out.println("JAXB LOAD!!!!");
            File fXml = new File(PATH_XML);
            JAXBContext jaxbContext = JAXBContext.newInstance(Planet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            planet = (Planet) jaxbUnmarshaller.unmarshal(fXml);
        } catch (JAXBException ex) {
            Logger.getLogger(Jaxb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ResponcePojo> getData(BigDecimal size) {
        List<ResponcePojo> lrp = new ArrayList();

        int x1 = size.compareTo(planet.getArea());

        if (x1 > 0) {
            lrp.add(new ResponcePojo(planet.getName(), planet.getArea()));
        }

        for (ContinentType ct : planet.getContinents()) {
            x1 = size.compareTo(ct.getArea());
            if (x1 > 0) {
                lrp.add(new ResponcePojo(ct.getName(), ct.getArea()));
            }
            for (CountryType cy : ct.getCountries()) {
                x1 = size.compareTo(cy.getArea());
                if (x1 > 0) {
                    lrp.add(new ResponcePojo(cy.getName(), cy.getArea()));
                }
            }
        }

        return lrp;
    }

}

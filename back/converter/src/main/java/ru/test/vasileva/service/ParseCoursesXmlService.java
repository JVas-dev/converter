package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.test.vasileva.domain.DailyCoursesDomain;
import ru.test.vasileva.dto.CurrCourses;
import ru.test.vasileva.dto.Currency;
import ru.test.vasileva.repo.DailyCoursesRepo;
import ru.test.vasileva.service.map.CoursesMapService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseCoursesXmlService {
    @Autowired
    DailyCoursesRepo dailyCoursesRepo;
    @Autowired
    CoursesMapService coursesMapService;

    public List<DailyCoursesDomain> parseXml(String uri) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = builder.parse(uri);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();


        return saveCourses(parseCoursesXml(document));

    }

    public CurrCourses parseCoursesXml(Document document) {
        Element root = document.getDocumentElement();

        CurrCourses currCourses = new CurrCourses();
        currCourses.setDate(root.getAttribute("Date"));
        currCourses.setName(root.getAttribute("name"));

        List<Currency> currencies = new ArrayList<>();
        NodeList nList = document.getElementsByTagName("Valute");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Currency currency = new Currency();
                currency.setId(eElement.getAttribute("ID"));
                currency.setNumCode(Short.parseShort(eElement.getElementsByTagName("NumCode").item(0).getTextContent()));
                currency.setCharCode(eElement.getElementsByTagName("CharCode").item(0).getTextContent());
                currency.setNominal(Integer.parseInt(eElement.getElementsByTagName("Nominal").item(0).getTextContent()));
                currency.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
                currency.setValue(eElement.getElementsByTagName("Value").item(0).getTextContent());

                currencies.add(currency);
            }
        }
        currencies.add(addRuble());
        currCourses.setCurrency(currencies);
        return currCourses;
    }

    public List<DailyCoursesDomain> saveCourses(CurrCourses currCourses) {
        List<DailyCoursesDomain> dailyCoursesDomain = coursesMapService.saveAllDailyCoursesDomain(currCourses);
        dailyCoursesRepo.saveAll(dailyCoursesDomain);
        return dailyCoursesDomain;
    }

    public Currency addRuble() {
        Currency currency = new Currency();
        currency.setName("Российский рубль");
        currency.setNominal(1);
        currency.setValue("1");
        return currency;
    }
}

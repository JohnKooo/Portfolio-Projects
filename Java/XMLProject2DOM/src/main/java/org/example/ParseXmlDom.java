package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParseXmlDom {
    public ArrayList<Type> games;

    public  ArrayList<Type> getGames(){ return games;}

    public ParseXmlDom(String fileName){
        games = new ArrayList<>();

        DocumentBuilder documentBuilder;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        File file = new File(fileName);

        Document doc;
        try {
            doc = documentBuilder.parse(file);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        Element root = doc.getDocumentElement();
        NodeList gameNodes = root.getElementsByTagName("game");

        for (int i = 0; i < gameNodes.getLength(); i++) {
            Element gameElement = (Element) gameNodes.item(i);
            processGameElement(gameElement);
        }
    }

    private void processGameElement(Element gameElement) {
        Rating game = buildGame(gameElement);
        games.add(game);
    }

    private Rating buildGame(Element gameElement) {
        String gameName = getTextContext(gameElement,"gameName");
        String releaseYear = getTextContext(gameElement,"releaseYear");
        String gameCost = getTextContext(gameElement,"gameCost");
        String gameType = getTextContext(gameElement,"gameType");
        String platform = getTextContext(gameElement,"platform");
        String ratings = getTextContext(gameElement,"ratings");

        Game game = new Game(gameName,Integer.parseInt(releaseYear),Double.parseDouble(gameCost),gameType,platform);

        return new Rating(game, ratings.charAt(0));
    }

    private String getTextContext(Element element, String tagName){
        NodeList nodeList = element.getElementsByTagName(tagName);
        Element childElement = (Element) nodeList.item(0);
        return childElement.getTextContent();
    }
}

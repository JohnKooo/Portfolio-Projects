package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseXmlDom parseXml = new ParseXmlDom("games.xml");

        ArrayList<Type> games = parseXml.getGames();
        for(Type g: games){
            System.out.println(g);
        }
    }
}
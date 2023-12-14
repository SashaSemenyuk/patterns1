package org.example.factory;

import org.example.parsers.PropertiesParser;
import org.example.parsers.XMLParser;
import org.example.parsers.properties.PropertiesTrainParser;
import org.example.parsers.xml.XMLTrainParser;

public class TrainParserFactory implements ParserFactory {
    @Override
    public XMLParser createXMLParser() {
        return new XMLTrainParser();
    }

    @Override
    public PropertiesParser createPropertiesParser() {
        return new PropertiesTrainParser();
    }
}

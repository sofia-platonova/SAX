package com.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class BookXMLHandler extends DefaultHandler {
    Catalog myCatalog = null;
    Book book = null;
    boolean author = false;
    boolean title = false;
    boolean description = false;

    boolean punlish_date = false;
    boolean price = false;
    boolean genre = false;
    String currentCharacters;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("catalog")) {
            myCatalog = new Catalog();
        } else if (qName.equalsIgnoreCase("book")) {
            book = new Book();
        } else if (qName.equalsIgnoreCase("author")) {
            author = true;
        } else if (qName.equalsIgnoreCase("title")) {
            title = true;
        } else if (qName.equalsIgnoreCase("description")) {
            description = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            description = true;
        } else if (qName.equalsIgnoreCase("price")) {
            description = true;
        } else if (qName.equalsIgnoreCase("publish_date")) {
            description = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("catalog")) {
            System.out.println("Done with catalog");
            System.out.println(myCatalog.toString());
        } else if (qName.equalsIgnoreCase("book")) {
            myCatalog.push(book);
        } else if (qName.equalsIgnoreCase("author")) {
            book.setAuthor(currentCharacters);
            author = false;
        } else if (qName.equalsIgnoreCase("title")) {
            book.setTitle(currentCharacters);
            title = false;
        } else if (qName.equalsIgnoreCase("description")) {
            book.setDescription(currentCharacters);
            description = false;
        }else if (qName.equalsIgnoreCase("price")) {
            book.setPrice(Double.parseDouble(currentCharacters));
            price = false;
        }else if (qName.equalsIgnoreCase("publish_date")) {
            book.setPublishDate(currentCharacters);
            punlish_date = false;
        }else if (qName.equalsIgnoreCase("genre")) {
            book.setGenre(currentCharacters);
            genre = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        currentCharacters = new String(ch, start, length);
    }
}

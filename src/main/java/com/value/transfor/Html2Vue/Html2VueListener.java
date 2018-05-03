/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
// import ANTLR's runtime libraries
package com.value.transfor.Html2Vue;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
 
public class Html2VueListener extends HTMLParserBaseListener {
    HTMLParser parser;
    public Html2VueListener(HTMLParser parser){
        this.parser = parser;
    }
    @Override public void enterHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        System.out.println("enter html document");
    }
    public static void main(String[] args) throws Exception {
        String inputFile = "E:\\test_temp\\html2vue\\dev.html";
        InputStream is =  new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        HTMLLexer lexer = new HTMLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        HTMLParser parser = new HTMLParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.htmlDocument();
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        Html2VueListener extractor = new Html2VueListener(parser);
        walker.walk(extractor, tree); // initiate walk of tree with listener



    }
}

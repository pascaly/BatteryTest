package com.younicos.task;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * BatteryProfileValidatorErrorHandler class
 * 
 * @author Pàscal Casadei
 * 
 * Younicos Task
 * 
 */
public class BatteryProfileValidatorErrorHandler implements ErrorHandler
{
    final static Logger logger = Logger.getLogger(BatteryProfileValidatorErrorHandler.class);
    
    public void warning(SAXParseException e) throws SAXException
    {
	logger.error(e.getMessage());
    }
    
    public void error(SAXParseException e) throws SAXException
    {
	logger.error(e.getMessage());
    }
    
    public void fatalError(SAXParseException e) throws SAXException
    {
	logger.error(e.getMessage());
    }
}
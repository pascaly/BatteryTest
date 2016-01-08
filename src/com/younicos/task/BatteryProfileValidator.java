package com.younicos.task;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.younicos.task.vo.powerprofile.Power;
import com.younicos.task.vo.powerprofile.PowerProfile;

/**
 * BatteryProfileValidator class
 * 
 * @author Pàscal Casadei
 * 
 * Younicos Task
 *
 */
public class BatteryProfileValidator
{
    final static Logger logger = Logger.getLogger(BatteryProfileValidator.class);
    
    /**
     * This method validates a Battery Profile according to XSD profile provided and a set of Battery Profiles in XML. 
     * 
     * @author Pàscal Casadei
     * 
     * @param schemaFilename
     * @param batteryProfileFilename
     * @return isValid
     */
    public boolean validate(String schemaFilename, String batteryProfileFilename)
    {
	boolean result = false;
	
	try
	{
	    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    
	    //enabling awareness for namespace
	    docFactory.setNamespaceAware(true);
	    
	    //enabling validator
	    docFactory.setValidating(false);
	    SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
	    docFactory.setSchema(schemaFactory.newSchema(new Source[] { new StreamSource(schemaFilename) }));

	    //parsing the xml...
	    DocumentBuilder parser = docFactory.newDocumentBuilder();
	    parser.setErrorHandler(new BatteryProfileValidatorErrorHandler());
	    Document document = parser.parse(new File(batteryProfileFilename));
	    
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    
	    //loading xsd schema
	    Source schemaFile = new StreamSource(new File(schemaFilename));
	    Schema schema = factory.newSchema(schemaFile);
	    
	    //validate the battery profile
	    Validator validator = schema.newValidator();
	    validator.validate(new DOMSource(document));
	    
	    //unmarshalling the battery profile object
	    PowerProfile powerProfileObj = unmarshallPowerProfile(batteryProfileFilename);
	    
	    //validating date interval and timestamps
	    result = this.validatePowerProfile(powerProfileObj, batteryProfileFilename);
	}
	catch (SAXException e)
	{
	    BatteryProfileValidator.logger.error(e);
	}
	catch (IOException e)
	{
	    BatteryProfileValidator.logger.error(e);
	}
	catch (ParserConfigurationException e)
	{
	    BatteryProfileValidator.logger.error(e);
	}
	
	return result;
    }
    
    /**
     * This method transform an XML Battery Profile into a Java Object. 
     * 
     * @author Pàscal Casadei
     * 
     * @param xmlFilename
     * @return powerProfileObj
     */
    public PowerProfile unmarshallPowerProfile(String xmlFilename)
    {
	PowerProfile powerProfileObj = null;
	
	try
	{
	    JAXBContext jc = JAXBContext.newInstance(PowerProfile.class);
	    Unmarshaller u = jc.createUnmarshaller();
	    powerProfileObj = (PowerProfile)u.unmarshal( new File( xmlFilename ) );
	}
	catch (JAXBException e)
	{
	    logger.error(e);
	}
	
	return powerProfileObj;
    }

    /**
     * This method validates the time interval and the timestamps contained in the Battery Profile. 
     * 
     * @author Pàscal Casadei
     * 
     * @param powerProfileObj
     * @param xmlFilename
     * @return isValid
     */
    private boolean validatePowerProfile(PowerProfile powerProfileObj, String xmlFilename)
    {
	boolean result = false;

	if(powerProfileObj != null)
	{
	    Date start = null;
	    Date end = null;
	    
	    start = powerProfileObj.getStart();
	    end = powerProfileObj.getEnd();
	    
	    //check if the start and end values are valid
	    if(start.before(end))
	    {
		Power powerSequence[] = powerProfileObj.getPowerSequence().getPower();
		
		for(Power thisPower: powerSequence)
		{
		    //check if the Power timestamp is valid in the given start / end interval
		    if((thisPower.getTimestamp().after(start) || thisPower.getTimestamp().equals(start)) && (thisPower.getTimestamp().before(end) || thisPower.getTimestamp().equals(end)))
		    {
			result = true;			
		    }
		    else
		    {
			logger.error("Battery Profile <" + xmlFilename + "> contains a Power timestamp that is not in the start / end date interval: start date " + start + ", power timestamp " + thisPower.getTimestamp() + ", end date " + end);
			break;
		    }
		}
	    }
	    else
	    {
		logger.error("Battery Profile <" + xmlFilename + "> start date is not before end date.");
	    }
	}
	else
	{
	    logger.error("Battery Profile <" + xmlFilename + "> XML data is not valid. See previous error in the log for details.");
	}
	
	return result;
    }

    /**
     * Main method to run the validation. 
     * 
     * @author Pàscal Casadei
     * 
     * @param args
     */
    public static void main(String [] args)
    {
	String xsdFile = null;
	boolean xsdIsValid = false;
	BatteryProfileValidator task = new BatteryProfileValidator();
	
	if(args.length < 2)
	{
	    BatteryProfileValidator.logger.error("\nUSAGE: java BatteryProfileValidator <xsdProfile> <xmlProfile1> ... <xmlProfileN>\n");
	    System.exit(-1);
	}
	
	// check if first arg is an xsd
	if(args[0] != null)
	{
	    xsdFile = args[0];
	    
	    File xsd = new File(xsdFile);
	    
	    if(xsd.exists())
	    {
		if(xsd.getAbsolutePath().endsWith(".xsd"))
		{
		    xsdIsValid = true;
		}
		else
		{
		    BatteryProfileValidator.logger.error("the first argument must refer to an xsd file!");
		}
	    }
	    else
	    {
		BatteryProfileValidator.logger.debug("the xsd file specified dos not exists: " + xsdFile);
	    }
	}
	else
	{
	    BatteryProfileValidator.logger.debug("null xsd file specified"); 
	}
	
	if(xsdIsValid)
	{
	    logger.info("Starting BatteryProfileValidator.");
	    logger.info("----------------------------------------------------------------------------------------------------");
	    
	    for(int profile = 1; profile < args.length; profile++)
	    {
		logger.info("validating Battery Profile <" + args[profile] + ">:");

		if(task.validate(xsdFile, args[profile]))
		{
		    BatteryProfileValidator.logger.info("Battery Profile <" + args[profile] + "> is valid.");
		}
		else
		{
		    BatteryProfileValidator.logger.warn("Battery Profile <" + args[profile] + "> is not valid. See previous error in the log for details.");
		}
		
		logger.info("----------------------------------------------------------------------------------------------------");
	    }
	    
	    logger.info("BatteryProfileValidator completed.");
	}
	else
	{
	    BatteryProfileValidator.logger.warn("invalid xsd file specified: " + xsdFile);
	    System.exit(-1);
	}
    }
}

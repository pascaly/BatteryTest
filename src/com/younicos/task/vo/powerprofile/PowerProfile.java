package com.younicos.task.vo.powerprofile;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * A power profile
 * 
 * @version $Revision$ $Date$
 */
@XmlRootElement(name="powerProfile", namespace="http://www.younicos.com/namespace")
@SuppressWarnings("serial")
public class PowerProfile implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _start.
     */
    private java.util.Date _start;

    /**
     * Field _end.
     */
    private java.util.Date _end;

    /**
     * list of tuples (power, time)
     */
    private PowerSequence _powerSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public PowerProfile() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'end'.
     * 
     * @return the value of field 'End'.
     */
    public java.util.Date getEnd(
    ) {
        return this._end;
    }

    /**
     * Returns the value of field 'powerSequence'. The field
     * 'powerSequence' has the following description: list of
     * tuples (power, time)
     * 
     * @return the value of field 'PowerSequence'.
     */
    public PowerSequence getPowerSequence(
    ) {
        return this._powerSequence;
    }

    /**
     * Returns the value of field 'start'.
     * 
     * @return the value of field 'Start'.
     */
    public java.util.Date getStart(
    ) {
        return this._start;
    }

    /**
     * Sets the value of field 'end'.
     * 
     * @param end the value of field 'end'.
     */
    public void setEnd(
            final java.util.Date end) {
        this._end = end;
    }

    /**
     * Sets the value of field 'powerSequence'. The field
     * 'powerSequence' has the following description: list of
     * tuples (power, time)
     * 
     * @param powerSequence the value of field 'powerSequence'.
     */
    public void setPowerSequence(
            final PowerSequence powerSequence) {
        this._powerSequence = powerSequence;
    }

    /**
     * Sets the value of field 'start'.
     * 
     * @param start the value of field 'start'.
     */
    public void setStart(
            final java.util.Date start) {
        this._start = start;
    }

}

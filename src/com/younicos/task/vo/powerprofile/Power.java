package com.younicos.task.vo.powerprofile;
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Power.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Power implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _power_kW.
     */
    private double _power_kW;

    /**
     * keeps track of state for field: _power_kW
     */
    private boolean _has_power_kW;

    /**
     * Field _timestamp.
     */
    private java.util.Date _timestamp;


      //----------------/
     //- Constructors -/
    //----------------/

    public Power() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deletePower_kW(
    ) {
        this._has_power_kW= false;
    }

    /**
     * Returns the value of field 'power_kW'.
     * 
     * @return the value of field 'Power_kW'.
     */
    public double getPower_kW(
    ) {
        return this._power_kW;
    }

    /**
     * Returns the value of field 'timestamp'.
     * 
     * @return the value of field 'Timestamp'.
     */
    public java.util.Date getTimestamp(
    ) {
        return this._timestamp;
    }

    /**
     * Method hasPower_kW.
     * 
     * @return true if at least one Power_kW has been added
     */
    public boolean hasPower_kW(
    ) {
        return this._has_power_kW;
    }

    /**
     * Sets the value of field 'power_kW'.
     * 
     * @param power_kW the value of field 'power_kW'.
     */
    public void setPower_kW(
            final double power_kW) {
        this._power_kW = power_kW;
        this._has_power_kW = true;
    }

    /**
     * Sets the value of field 'timestamp'.
     * 
     * @param timestamp the value of field 'timestamp'.
     */
    public void setTimestamp(
            final java.util.Date timestamp) {
        this._timestamp = timestamp;
    }

}

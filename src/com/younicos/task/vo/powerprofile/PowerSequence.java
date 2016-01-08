package com.younicos.task.vo.powerprofile;
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * list of tuples (power, time)
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PowerSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _powerList.
     */
    private java.util.Vector<Power> _powerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PowerSequence() {
        super();
        this._powerList = new java.util.Vector<Power>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPower
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPower(
            final Power vPower)
    throws java.lang.IndexOutOfBoundsException {
        this._powerList.addElement(vPower);
    }

    /**
     * 
     * 
     * @param index
     * @param vPower
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPower(
            final int index,
            final Power vPower)
    throws java.lang.IndexOutOfBoundsException {
        this._powerList.add(index, vPower);
    }

    /**
     * Method enumeratePower.
     * 
     * @return an Enumeration over all Power elements
     */
    public java.util.Enumeration<? extends Power> enumeratePower(
    ) {
        return this._powerList.elements();
    }

    /**
     * Method getPower.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the Power at the given index
     */
    public Power getPower(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._powerList.size()) {
            throw new IndexOutOfBoundsException("getPower: Index value '" + index + "' not in range [0.." + (this._powerList.size() - 1) + "]");
        }

        return (Power) _powerList.get(index);
    }

    /**
     * Method getPower.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public Power[] getPower(
    ) {
        Power[] array = new Power[0];
        return (Power[]) this._powerList.toArray(array);
    }

    /**
     * Method getPowerCount.
     * 
     * @return the size of this collection
     */
    public int getPowerCount(
    ) {
        return this._powerList.size();
    }

    /**
     */
    public void removeAllPower(
    ) {
        this._powerList.clear();
    }

    /**
     * Method removePower.
     * 
     * @param vPower
     * @return true if the object was removed from the collection.
     */
    public boolean removePower(
            final Power vPower) {
        boolean removed = _powerList.remove(vPower);
        return removed;
    }

    /**
     * Method removePowerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public Power removePowerAt(
            final int index) {
        java.lang.Object obj = this._powerList.remove(index);
        return (Power) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPower
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPower(
            final int index,
            final Power vPower)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._powerList.size()) {
            throw new IndexOutOfBoundsException("setPower: Index value '" + index + "' not in range [0.." + (this._powerList.size() - 1) + "]");
        }

        this._powerList.set(index, vPower);
    }

    /**
     * 
     * 
     * @param vPowerArray
     */
    public void setPower(
            final Power[] vPowerArray) {
        //-- copy array
        _powerList.clear();

        for (int i = 0; i < vPowerArray.length; i++) {
                this._powerList.add(vPowerArray[i]);
        }
    }

}

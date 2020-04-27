/*
 * File: SpExisteMovByLlave2Result.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:O4HqHi+hb6pFhFFmwJS1iq>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Output parameters of procedure "PKG_SII_RENTA_ME.SP_EXISTE_MOV_BY_LLAVE2".
 */
public class SpExisteMovByLlave2Result implements Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myExisteout;
    private BigDecimal myMontoret;
    private BigDecimal myIdcta;
    private BigDecimal myIdmov;
    private String myRectind;
    private ProcedureTable[] myTables;

    /**
     * Constructor.
     */
    public SpExisteMovByLlave2Result()
    {
    }

    /**
     * Returns the value of "Existeout".
     */
    public BigDecimal getExisteout()
    {
        return myExisteout;
    }

    /**
     * Changes the value of "Existeout".
     */
    public void setExisteout(BigDecimal value)
    {
        myExisteout = value;
    }

    /**
     * Returns the value of "Montoret".
     */
    public BigDecimal getMontoret()
    {
        return myMontoret;
    }

    /**
     * Changes the value of "Montoret".
     */
    public void setMontoret(BigDecimal value)
    {
        myMontoret = value;
    }

    /**
     * Returns the value of "Idcta".
     */
    public BigDecimal getIdcta()
    {
        return myIdcta;
    }

    /**
     * Changes the value of "Idcta".
     */
    public void setIdcta(BigDecimal value)
    {
        myIdcta = value;
    }

    /**
     * Returns the value of "Idmov".
     */
    public BigDecimal getIdmov()
    {
        return myIdmov;
    }

    /**
     * Changes the value of "Idmov".
     */
    public void setIdmov(BigDecimal value)
    {
        myIdmov = value;
    }

    /**
     * Returns the value of "Rectind".
     */
    public String getRectind()
    {
        return myRectind;
    }

    /**
     * Changes the value of "Rectind".
     */
    public void setRectind(String value)
    {
        myRectind = value;
    }

    /**
     * Returns the value of "ProcedureTables".
     */
    public ProcedureTable[] getProcedureTables()
    {
        return myTables;
    }

    /**
     * Changes the value of "ProcedureTables".
     */
    public void setProcedureTables(ProcedureTable[] value)
    {
        myTables = value;
    }
}

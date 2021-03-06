/*
 * File: PkgSiiRentaMeException.java  2008/10/09 10:09:46
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:VDLM5wfePPgkkIPJ2fdwUF>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

/**
 * Exception thrown when the execution of a procedure fails.
 */
public class PkgSiiRentaMeException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Create a new PkgSiiRentaMeException.
     */
    public PkgSiiRentaMeException()
    {
        super();
    }

    /**
     * Create a new PkgSiiRentaMeException with supplied message.
     */
    public PkgSiiRentaMeException(String message)
    {
        super(message);
    }

    /**
     * Create a new PkgSiiRentaMeException with supplied cause.
     */
    public PkgSiiRentaMeException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Create a new PkgSiiRentaMeException with supplied message and cause.
     */
    public PkgSiiRentaMeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

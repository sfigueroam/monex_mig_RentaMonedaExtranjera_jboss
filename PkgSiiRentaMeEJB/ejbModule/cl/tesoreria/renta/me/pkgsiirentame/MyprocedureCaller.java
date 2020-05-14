/*
 * File: MyprocedureCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:5xUnzaNeAHAPmesU7R0j0a>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.MYPROCEDURE".
 */
public class MyprocedureCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.MYPROCEDURE".
     *
     * PARAM1             NUMBER             Input
     */
    public static MyprocedureResult execute(Connection conn, BigDecimal param1)
        throws java.sql.SQLException
    {
        MyprocedureResult result = new MyprocedureResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call SII.PKG_SII_RENTA_ME.MYPROCEDURE(?)}");
        try
        {
            call.setBigDecimal(1, param1);
            int updateCount = 0;
            boolean haveRset = call.execute();
            while (haveRset || updateCount != -1)
            {
                if (!haveRset)
                    updateCount = call.getUpdateCount();
                else
                    resultSets.add(toProcedureTable(call.getResultSet()));
                haveRset = call.getMoreResults();
            }
        }
        finally
        {
            call.close();
        }
        if (resultSets.size() > 0)
        {
            ProcedureTable[] tables = new ProcedureTable[resultSets.size()];
            result.setProcedureTables((ProcedureTable[]) resultSets.toArray(tables));
        }
        return result;
    }
}

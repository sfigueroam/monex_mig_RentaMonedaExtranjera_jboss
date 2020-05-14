/*
 * File: SpExisteCuentabyfolioandrutCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:W9mKBDUaY4t8bFAzmNKCIK>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.SP_EXISTE_CUENTABYFOLIOANDRUT".
 */
public class SpExisteCuentabyfolioandrutCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.SP_EXISTE_CUENTABYFOLIOANDRUT".
     *
     * RUT                NUMBER             Input
     * DV                 CHAR(2000)         Input
     * TIPOFORM           NUMBER             Input
     * FOLIOFORM          NUMBER             Input
     * FECHVTO            DATE               Input
     * RESPOUT            NUMBER             Output
     */
    public static SpExisteCuentabyfolioandrutResult execute(Connection conn, BigDecimal rut, String dv, BigDecimal tipoform, BigDecimal folioform, Date fechvto)
        throws java.sql.SQLException
    {
        SpExisteCuentabyfolioandrutResult result = new SpExisteCuentabyfolioandrutResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call SII.PKG_SII_RENTA_ME.SP_EXISTE_CUENTABYFOLIOANDRUT(?,?,?,?,?,?)}");
        try
        {
            call.setBigDecimal(1, rut);
            call.setString(2, dv);
            call.setBigDecimal(3, tipoform);
            call.setBigDecimal(4, folioform);
            call.setTimestamp(5, toTimestamp(fechvto));
            call.registerOutParameter(6, Types.NUMERIC);
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
            result.setRespout(call.getBigDecimal(6));
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

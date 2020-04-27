/*
 * File: ActRectificadaCtaByLlaveCaller.java  2008/10/09 10:09:44
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:BQfkPeuUmxH4YbQs2c2NMQ>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.ACT_RECTIFICADA_CTA_BY_LLAVE".
 */
public class ActRectificadaCtaByLlaveCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.ACT_RECTIFICADA_CTA_BY_LLAVE".
     *
     * RUTIN              NUMBER             Input
     * DVIN               CHAR(2000)         Input
     * FORMTIPOIN         NUMBER             Input
     * FOLIOIN            NUMBER             Input
     * FECHAVENC          DATE               Input
     * EXISTE             NUMBER             Output
     */
    public static ActRectificadaCtaByLlaveResult execute(Connection conn, BigDecimal rutin, String dvin, BigDecimal formtipoin, BigDecimal folioin, Date fechavenc)
        throws java.sql.SQLException
    {
        ActRectificadaCtaByLlaveResult result = new ActRectificadaCtaByLlaveResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call PKG_SII_RENTA_ME.ACT_RECTIFICADA_CTA_BY_LLAVE(?,?,?,?,?,?)}");
        try
        {
            call.setBigDecimal(1, rutin);
            call.setString(2, dvin);
            call.setBigDecimal(3, formtipoin);
            call.setBigDecimal(4, folioin);
            call.setTimestamp(5, toTimestamp(fechavenc));
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
            result.setExiste(call.getBigDecimal(6));
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

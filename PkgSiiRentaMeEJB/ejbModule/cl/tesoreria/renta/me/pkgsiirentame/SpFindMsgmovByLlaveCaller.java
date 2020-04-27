/*
 * File: SpFindMsgmovByLlaveCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:cv9AYudvm-9G+RgfL7DJYB>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.SP_FIND_MSGMOV_BY_LLAVE".
 */
public class SpFindMsgmovByLlaveCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.SP_FIND_MSGMOV_BY_LLAVE".
     *
     * RUTIN              NUMBER             Input
     * DVIN               CHAR(2000)         Input
     * FORMTIPOIN         NUMBER             Input
     * FOLIOIN            NUMBER             Input
     * FECHAVENC          DATE               Input
     * EXISTEOUT          NUMBER             Output
     * MSJOUT             CLOB               Output
     * VALOR_OUT          VARCHAR2(4000)     Output
     */
    public static SpFindMsgmovByLlaveResult execute(Connection conn, BigDecimal rutin, String dvin, BigDecimal formtipoin, BigDecimal folioin, Date fechavenc)
        throws java.sql.SQLException
    {
        SpFindMsgmovByLlaveResult result = new SpFindMsgmovByLlaveResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call PKG_SII_RENTA_ME.SP_FIND_MSGMOV_BY_LLAVE(?,?,?,?,?,?,?,?)}");
        try
        {
            call.setBigDecimal(1, rutin);
            call.setString(2, dvin);
            call.setBigDecimal(3, formtipoin);
            call.setBigDecimal(4, folioin);
            call.setTimestamp(5, toTimestamp(fechavenc));
            call.registerOutParameter(6, Types.NUMERIC);
            call.registerOutParameter(7, Types.CLOB);
            call.registerOutParameter(8, Types.VARCHAR);
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
            result.setExisteout(call.getBigDecimal(6));
            result.setMsjout(toString(call.getClob(7)));
            result.setValorOut(call.getString(8));
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

/*
 * File: SpInsertErrorMsgMeCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:0v4fR-wmwa61gzpIVEduVX>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.SP_INSERT_ERROR_MSG_ME".
 */
public class SpInsertErrorMsgMeCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.SP_INSERT_ERROR_MSG_ME".
     *
     * MESSAGEID          VARCHAR2(4000)     Input
     * ERRORINDEX         NUMBER             Input
     * NUMBERERROR        NUMBER             Input
     * SEVERITY           NUMBER             Input
     * DESCRIPTION        VARCHAR2(4000)     Input
     * FORMINDEX          NUMBER             Input
     * CODIGOINDEX        NUMBER             Input
     * CONTENIDO          VARCHAR2(4000)     Input
     * MODULENAME         VARCHAR2(4000)     Input
     * OBJECTNAME         VARCHAR2(4000)     Input
     * OBJECTDESC         VARCHAR2(4000)     Input
     * PERIODOCONTABLE    NUMBER             Input
     * RESPOUT            NUMBER             Output
     */
    public static SpInsertErrorMsgMeResult execute(Connection conn, String messageid, BigDecimal errorindex, BigDecimal numbererror, BigDecimal severity, String description, BigDecimal formindex, BigDecimal codigoindex, String contenido, String modulename, String objectname, String objectdesc, BigDecimal periodocontable)
        throws java.sql.SQLException
    {
        SpInsertErrorMsgMeResult result = new SpInsertErrorMsgMeResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call PKG_SII_RENTA_ME.SP_INSERT_ERROR_MSG_ME(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        try
        {
            call.setString(1, messageid);
            call.setBigDecimal(2, errorindex);
            call.setBigDecimal(3, numbererror);
            call.setBigDecimal(4, severity);
            call.setString(5, description);
            call.setBigDecimal(6, formindex);
            call.setBigDecimal(7, codigoindex);
            call.setString(8, contenido);
            call.setString(9, modulename);
            call.setString(10, objectname);
            call.setString(11, objectdesc);
            call.setBigDecimal(12, periodocontable);
            call.registerOutParameter(13, Types.NUMERIC);
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
            result.setRespout(call.getBigDecimal(13));
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

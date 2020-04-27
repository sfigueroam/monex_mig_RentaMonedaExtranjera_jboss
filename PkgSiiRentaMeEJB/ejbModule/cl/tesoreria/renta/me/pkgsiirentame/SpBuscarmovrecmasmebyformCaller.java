/*
 * File: SpBuscarmovrecmasmebyformCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:4TtHVButxNbfn8zCU5d4IK>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.SP_BUSCARMOVRECMASMEBYFORM".
 */
public class SpBuscarmovrecmasmebyformCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.SP_BUSCARMOVRECMASMEBYFORM".
     *
     * IDCTA              NUMBER             Input
     * RESPOUT            NUMBER             Output
     * IDMOVM             NUMBER             Output
     */
    public static SpBuscarmovrecmasmebyformResult execute(Connection conn, BigDecimal idcta)
        throws java.sql.SQLException
    {
        SpBuscarmovrecmasmebyformResult result = new SpBuscarmovrecmasmebyformResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call PKG_SII_RENTA_ME.SP_BUSCARMOVRECMASMEBYFORM(?,?,?)}");
        try
        {
            call.setBigDecimal(1, idcta);
            call.registerOutParameter(2, Types.NUMERIC);
            call.registerOutParameter(3, Types.NUMERIC);
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
            result.setRespout(call.getBigDecimal(2));
            result.setIdmovm(call.getBigDecimal(3));
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

/*
 * File: SpRegistraItemCutCaller.java  2008/10/09 10:09:45
 * User: Italo Maragliano Gonzalez (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.239.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:uhYDGBwuiaKEn2zTOq1KIW>>.
 */

package cl.tesoreria.renta.me.pkgsiirentame;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;

/**
 * Implements a caller of procedure "PKG_SII_RENTA_ME.SP_REGISTRA_ITEM_CUT".
 */
public class SpRegistraItemCutCaller extends ProcedureCaller
{
    /**
     * Executes procedure "PKG_SII_RENTA_ME.SP_REGISTRA_ITEM_CUT".
     *
     * MOVID              NUMBER             Input
     * CODIGO             NUMBER             Input
     * DATO_TIPO          CHAR(2000)         Input
     * ESTADO             NUMBER             Input
     * VALOR              VARCHAR2(4000)     Input
     * RESPOUT            NUMBER             Output
     */
    public static SpRegistraItemCutResult execute(Connection conn, BigDecimal movid, BigDecimal codigo, String datoTipo, BigDecimal estado, String valor)
        throws java.sql.SQLException
    {
        SpRegistraItemCutResult result = new SpRegistraItemCutResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call SII.PKG_SII_RENTA_ME.SP_REGISTRA_ITEM_CUT(?,?,?,?,?,?)}");
        try
        {
            call.setBigDecimal(1, movid);
            call.setBigDecimal(2, codigo);
            call.setString(3, datoTipo);
            call.setBigDecimal(4, estado);
            call.setString(5, valor);
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

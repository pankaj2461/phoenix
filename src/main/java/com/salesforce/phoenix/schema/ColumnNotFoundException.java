/*******************************************************************************
 * Copyright (c) 2013, Salesforce.com, Inc.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *     Neither the name of Salesforce.com nor the names of its contributors may 
 *     be used to endorse or promote products derived from this software without 
 *     specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, 
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package com.salesforce.phoenix.schema;

import java.sql.SQLException;

import com.salesforce.phoenix.exception.PhoenixExceptionCodeEnum;


/**
 * 
 * Exception thrown when a column name referenced in a select
 * statement cannot be found in any table.
 *
 * @author jtaylor
 * @since 0.1
 */
public class ColumnNotFoundException extends SQLException {
    private static final long serialVersionUID = 1L;
    private static PhoenixExceptionCodeEnum code = PhoenixExceptionCodeEnum.COLUMN_NOT_FOUND;
    private final String schemaName;
    private final String tableName;
    private final String columnName;

    public ColumnNotFoundException(String schemaName, String tableName, String columnName) {
        this(schemaName, tableName, null, columnName);
    }

    public ColumnNotFoundException(String columnName) {
        this(null, null, null, columnName);
    }

    public ColumnNotFoundException(String schemaName, String tableName, String familyName, String columnName) {
        super(PhoenixExceptionCodeEnum.generateSQLErrorMessage(code, schemaName, tableName, familyName, columnName),
                code.getSQLState());
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getColumnName() {
        return columnName;
    }
}

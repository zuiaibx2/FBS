package nc.bs.export.file.dbo;

import java.sql.Types;

public class Column {
	/**
	 * 只考虑中3种类型
	 */
	public static final int Col_DataType_UN_SUPPORTED = -9999;
	public static final int Col_DataType_VARCHAR = 0;
	public static final int Col_DataType_INTEGER = 1;
	public static final int Col_DataType_NUMERIC = 2;
	public static final String[] H2DataTypes = new String[]{
		"varchar2(4000)",
		"int",
		"decimal(31,8)"
	};
	
	public static final int[] H2SqlTypes = new int[]{
		Types.VARCHAR,
		Types.INTEGER,
		Types.DECIMAL
	};
	
	public String column_code;
	public int col_datatype;
	
	public String toSQLDefineExpression(String dbType)
	{
		StringBuilder sql = new StringBuilder(32);
		sql.append(column_code).append(" ").append(H2DataTypes[col_datatype]);
		return sql.toString();
	}
	
	public String toH2SQLDefineExpression()
	{
		StringBuilder sql = new StringBuilder(32);
		sql.append(column_code).append(" ").append(H2DataTypes[col_datatype]);
		return sql.toString();
	}
	
	public String toString()
	{
		return toH2SQLDefineExpression();
	}

}

package nc.bs.export.file.dbo;

public class Table implements Cloneable
{
	
	public String table_name;
	public String pk_field_name;
	public Column[] columns;

	public Table(){};
	public Table(String table_name)
	{
		this.table_name = table_name;
	}
	
	public String toH2SQLDefineExpression()
	{
		StringBuilder createTableSql = new StringBuilder(1024);
		createTableSql.append("create table ").append(table_name).append(" (");
		Column col=null;
		for (int i = 0, len = columns.length; i < len; i++)
		{
			col = columns[i];
			if (i > 0)
			{
				createTableSql.append(",").append(col.toH2SQLDefineExpression());
			}
			else
			{
				createTableSql.append(col.toH2SQLDefineExpression());
			}
		}
		createTableSql.append(")");
		
		return createTableSql.toString();
	}
	
	public String toSQLDefineExpression(String dbType)
	{
		StringBuilder createTableSql = new StringBuilder(1024);
		createTableSql.append("create table ").append(table_name).append(" (");
		Column col = null;
		for (int i = 0, len = columns.length; i < len; i++)
		{
			 col = columns[i];
			if (i > 0)
			{
				createTableSql.append(",").append(col.toSQLDefineExpression(dbType));
			}
			else
			{
				createTableSql.append(col.toSQLDefineExpression(dbType));
			}
		}
		createTableSql.append(")");
		
		return createTableSql.toString();
	}
	
	public String toString()
	{
		return table_name;
	}
}

/***************************************************************\
 *   FbsExportTimeVO.java                                       *
 *   2016 上午11:22:01                                           *
\***************************************************************/
package nc.vo.Export.time; 

import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDateTime;

/**
 * <b> 记录上次生成增量数据文件的时间 </b>
 * <p>
 *     对应数据库FBS_EXPORT_TIME表
 * </p>
 * 创建日期:2016年8月31日 上午11:22:27
 * @author 王凯强
 * @version 
 */
public class FbsExportTimeVO extends SuperVO
{
	private static final long serialVersionUID = 1L;
	
	private String pk_fbs_export_time;
	private String pk_corp;
	private UFDateTime time;
	private UFDateTime ts;
	private Integer dr;
	private String isall;//是否全量数据
	
	public String getPk_fbs_export_time()
	{
		return pk_fbs_export_time;
	}

	public void setPk_fbs_export_time(String pk_fbs_export_time)
	{
		this.pk_fbs_export_time = pk_fbs_export_time;
	}

	public String getPk_corp()
	{
		return pk_corp;
	}

	public void setPk_corp(String pk_corp)
	{
		this.pk_corp = pk_corp;
	}

	public UFDateTime getTime()
	{
		return time;
	}

	public void setTime(UFDateTime time)
	{
		this.time = time;
	}

	public UFDateTime getTs()
	{
		return ts;
	}

	public void setTs(UFDateTime ts)
	{
		this.ts = ts;
	}

	public Integer getDr()
	{
		return dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}

	public String getIsall() {
		return isall;
	}

	public void setIsall(String isall) {
		this.isall = isall;
	}

	@Override
	public String getPKFieldName()
	{
		return "pk_fbs_export_time";
	}

	@Override
	public String getParentPKFieldName()
	{
		return null;
	}

	@Override
	public String getTableName()
	{
		return "fbs_export_time";
	}
	
}

package nc.itf.mid;

import java.util.List;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @ClassName: IInsertMidData
 * <b> ���ݷ����¼���λ�м��ӿ� </b>
 * <p>
 *     �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������:2016��7��27�� ����10:19:43
 * @Author ����ǿ
 * @Version 
 */
public interface IInsertMidData {
	/**
	 * @Title: insertMidData
	 * @Description: �����м������
	 * @Author: ����ǿ
	 * @Date: 2016��8��8��
	 * @return
	 * @throws Exception
	 */
	public String insertMidData() throws BusinessException;
	
	public int insertMidData(List<SuperVO> list) throws BusinessException;
}

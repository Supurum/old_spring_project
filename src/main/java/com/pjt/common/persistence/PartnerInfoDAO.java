package com.pjt.common.persistence;

import java.util.List;

import com.pjt.common.domain.PartnerInfoDTO;

public interface PartnerInfoDAO {
	public PartnerInfoDTO userInfo(String user_id) throws Exception;
	
	public List<PartnerInfoDTO> partnerInfo(int meet_num, int startRow, int endRow) throws Exception;
	
	public PartnerInfoDTO writerInfo(int meet_num) throws Exception;
	
}

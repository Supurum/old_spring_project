package com.pjt.common.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.common.domain.PartnerInfoDTO;
import com.pjt.common.persistence.PartnerInfoDAO;

@Service
public class PartnerInfoServiceImpl implements PartnerInfoService {
	@Inject
	PartnerInfoDAO dao;
	@Override
	public PartnerInfoDTO userInfo(String user_id) throws Exception {
		return dao.userInfo(user_id);
	}
	@Override
	public List<PartnerInfoDTO> partnerInfo(int meet_num, int startRow, int endRow) throws Exception {
		return dao.partnerInfo(meet_num, startRow, endRow);
	}
	@Override
	public PartnerInfoDTO writerInfo(int meet_num) throws Exception {
		return dao.writerInfo(meet_num);
	}

}

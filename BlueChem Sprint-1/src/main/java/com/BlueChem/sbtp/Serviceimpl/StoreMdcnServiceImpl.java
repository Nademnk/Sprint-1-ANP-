package com.BlueChem.sbtp.Serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlueChem.sbtp.repository.StoreMdcnRepository;
import com.BlueChem.sbtp.service.StoreMdcnService;
import com.BlueChem.sbtp.entity.StoreMdcn;

//business logic for entity hotelList 
@Service
public class StoreMdcnServiceImpl implements StoreMdcnService{

    @Autowired
	StoreMdcnRepository smrepo;

	
    
    @Override
	public StoreMdcn createStore(StoreMdcn store) {
	return smrepo.save(store);
	}

	@Override
	public List<StoreMdcn> getAll() {
		return smrepo.findAll();
	}

}  

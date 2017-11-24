package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.model.convert.UserConvert;
import pe.com.socialdata.hotel.repository.UserRepository;
import pe.com.socialdata.hotel.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService {
	private static final Log LOG = LogFactory.getLog(UserRoleServiceImpl.class);
	
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	UserConvert userConvert;
	
	@Override
	public UserModel findUserRoleByUsername(String username) {
		LOG.debug("INCIA findUserRoleByUsername");
		UserModel userModel= userConvert.convertUser2UserModel(userRepository.findByUsername(username));
		
		LOG.debug("FIN findUserRoleByUsername");
		return userModel;
	}
	
}

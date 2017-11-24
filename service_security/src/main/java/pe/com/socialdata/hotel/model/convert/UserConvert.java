package pe.com.socialdata.hotel.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.User;
import pe.com.socialdata.hotel.entity.UserRole;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.model.UserRoleModel;

@Component
public class UserConvert  extends ConvertBase{
	
	@Autowired
	UserRoleConvert userRoleConvert;
	public User convertUserModel2User( UserModel userModel){
		User user = new User();
	
			BeanUtils.copyProperties( userModel, user, getNullPropertyNames(userModel));
		
		return user;
	}
	public UserModel convertUser2UserModel(User user){
		UserModel userModel = new UserModel();
		List<UserRoleModel> lista = new ArrayList<UserRoleModel>();
			BeanUtils.copyProperties( user, userModel, getNullPropertyNames(user));
			for(UserRole obj : user.getUserRole()) {
				UserRoleModel userM=userRoleConvert.convertUserRole2UserRoleModel(obj);
				lista.add(userM);
			}
			userModel.setUserRole(lista);
		return userModel;
	}

}

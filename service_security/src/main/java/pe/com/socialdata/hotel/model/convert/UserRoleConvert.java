package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.UserRole;

import pe.com.socialdata.hotel.model.UserRoleModel;

@Component 
public class UserRoleConvert  extends ConvertBase{
	
	public  UserRole convertUserRoleaModel2UserRole(  UserRoleModel  userRoleModel){
		 UserRole  userRole = new  UserRole();
	
			BeanUtils.copyProperties( userRoleModel, userRole, getNullPropertyNames(userRoleModel));
		
		return userRole;
	}
	public  UserRoleModel convertUserRole2UserRoleModel( UserRole userRole){
		UserRoleModel userRoleModel = new UserRoleModel();
		
			BeanUtils.copyProperties( userRole, userRoleModel, getNullPropertyNames(userRole));
	
		return userRoleModel;
	}

}

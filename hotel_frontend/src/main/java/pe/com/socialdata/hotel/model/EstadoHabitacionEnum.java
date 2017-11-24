package pe.com.socialdata.hotel.model;

import java.util.ArrayList;
import java.util.List;

public enum EstadoHabitacionEnum {
		LIBRE("01","LIBRE"),
		OCUPADO("02","OCUPADO"),
		RESERVADO("03","RESERVADO")
	    ;

	    private String code;
	    private String label;

	    EstadoHabitacionEnum(String code, String label) {
	        this.code = code;
	        this.label = label;
	    }

	    public static List<EstadoHabitacionEnum> findAll(){
	        List<EstadoHabitacionEnum> list= new ArrayList<EstadoHabitacionEnum>();

	        for(EstadoHabitacionEnum status: EstadoHabitacionEnum.values()){
	            list.add(status);
	        }

	        return list;
	    }

	    public static EstadoHabitacionEnum findByCode(String value){
	    	EstadoHabitacionEnum[] array= EstadoHabitacionEnum.values();
	    	EstadoHabitacionEnum result=null;
	        for (int i=0;i<array.length;i++){
	            if(array[i].getCode().equals(value)){
	                result=array[i];
	                break;
	            }
	        }
	        return result;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getLabel() {
	        return label;
	    }

	    public void setLabel(String label) {
	        this.label = label;
	    }
}

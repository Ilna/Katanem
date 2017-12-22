package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CarsList")
@Component
public class CarsList {

	List<Cars> carsList;
	
	public List<Cars> getCarsList(){
		return carsList; 
	}
	
	public void setCarsList(List<Cars> CarsList) {
		this.carsList=CarsList;
	}
	
}
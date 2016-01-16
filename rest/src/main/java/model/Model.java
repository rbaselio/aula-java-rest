package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public interface Model {

	Integer getId();
	void setId(Integer id);
	
}

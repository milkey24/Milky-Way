package dairyproject.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Dairy {

	@Id
	private int ownerId;
	private String DairyName;
	private long dairyPhone;
	private String dairyAddress;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> productList;
}

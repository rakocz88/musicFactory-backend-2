package pl.pilaf.inz.wrapper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pl.pilaf.inz.model.Band;
import pl.pilaf.inz.model.User;

public class BandWrapper implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    private long id;
    
    private String name;
    
    private String description;
    
    private Date createdDate;
    
    private String createdPlace;
    
    private List<User> members;
    
    private String gengre;

    private List<Long> users;
    
    

	public BandWrapper() {
		super();
	}
	
	public BandWrapper(Band band) {
		this.id=band.getId();
		this.name=band.getName();
		this.description=band.getDescription();
		this.createdDate=band.getCreatedDate();
		this.createdPlace=band.getCreatedPlace();
		this.gengre=band.getGengre();
		this.users= band.getIdList();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedPlace() {
		return createdPlace;
	}

	public void setCreatedPlace(String createdPlace) {
		this.createdPlace = createdPlace;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public String getGengre() {
		return gengre;
	}

	public void setGengre(String gengre) {
		this.gengre = gengre;
	}

	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}
   
}

package gustavo.unicesumar.entidades;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }    

    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) o;
        return Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    
}

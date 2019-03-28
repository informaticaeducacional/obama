package br.ufrn.imd.obama.dominio;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;

    public Entidade() {
    }

    public abstract int getId();

    public abstract void setId(int id);

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

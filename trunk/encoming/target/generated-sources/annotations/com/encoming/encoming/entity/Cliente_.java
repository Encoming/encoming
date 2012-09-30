package com.encoming.encoming.entity;

import com.encoming.encoming.entity.ClientePK;
import com.encoming.encoming.entity.Encomienda;
import com.encoming.encoming.entity.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> encomiendasEnviadas;
    public static volatile SingularAttribute<Cliente, Integer> encomiendasRecibidas;
    public static volatile SingularAttribute<Cliente, ClientePK> clientePK;
    public static volatile SingularAttribute<Cliente, Persona> persona;
    public static volatile ListAttribute<Cliente, Encomienda> encomiendaList;

}
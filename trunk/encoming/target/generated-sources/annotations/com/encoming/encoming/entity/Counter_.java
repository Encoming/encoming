package com.encoming.encoming.entity;

import com.encoming.encoming.entity.CounterPK;
import com.encoming.encoming.entity.Encomienda;
import com.encoming.encoming.entity.Trabajador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Counter.class)
public class Counter_ { 

    public static volatile SingularAttribute<Counter, String> usuario;
    public static volatile SingularAttribute<Counter, Trabajador> trabajador;
    public static volatile SingularAttribute<Counter, String> contrasenia;
    public static volatile SingularAttribute<Counter, CounterPK> counterPK;
    public static volatile ListAttribute<Counter, Encomienda> encomiendaList;

}
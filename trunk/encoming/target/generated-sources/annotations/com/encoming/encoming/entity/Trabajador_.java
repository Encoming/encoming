package com.encoming.encoming.entity;

import com.encoming.encoming.entity.Administrador;
import com.encoming.encoming.entity.Conductor;
import com.encoming.encoming.entity.Counter;
import com.encoming.encoming.entity.Persona;
import com.encoming.encoming.entity.TrabajadorPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile ListAttribute<Trabajador, Administrador> administradorList;
    public static volatile SingularAttribute<Trabajador, String> salario;
    public static volatile SingularAttribute<Trabajador, TrabajadorPK> trabajadorPK;
    public static volatile ListAttribute<Trabajador, Conductor> conductorList;
    public static volatile ListAttribute<Trabajador, Counter> counterList;
    public static volatile SingularAttribute<Trabajador, Persona> persona;

}
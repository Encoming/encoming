package com.encoming.encoming.entity;

import com.encoming.encoming.entity.Conductor;
import com.encoming.encoming.entity.Encomienda;
import com.encoming.encoming.entity.VehiculoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> estado;
    public static volatile SingularAttribute<Vehiculo, VehiculoPK> vehiculoPK;
    public static volatile SingularAttribute<Vehiculo, String> tipo;
    public static volatile ListAttribute<Vehiculo, Conductor> conductorList;
    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, String> modelo;
    public static volatile SingularAttribute<Vehiculo, Integer> capacidad;
    public static volatile ListAttribute<Vehiculo, Encomienda> encomiendaList;

}
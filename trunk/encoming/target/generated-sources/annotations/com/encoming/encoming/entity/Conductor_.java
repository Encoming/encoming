package com.encoming.encoming.entity;

import com.encoming.encoming.entity.ConductorPK;
import com.encoming.encoming.entity.Trabajador;
import com.encoming.encoming.entity.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, Trabajador> trabajador;
    public static volatile SingularAttribute<Conductor, String> licenciaConduccion;
    public static volatile SingularAttribute<Conductor, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Conductor, ConductorPK> conductorPK;

}
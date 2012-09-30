package com.encoming.encoming.entity;

import com.encoming.encoming.entity.AdministradorPK;
import com.encoming.encoming.entity.Trabajador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, AdministradorPK> administradorPK;
    public static volatile SingularAttribute<Administrador, String> usuario;
    public static volatile SingularAttribute<Administrador, Trabajador> trabajador;
    public static volatile SingularAttribute<Administrador, String> contrasenia;

}
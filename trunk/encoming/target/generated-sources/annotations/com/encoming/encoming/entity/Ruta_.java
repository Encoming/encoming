package com.encoming.encoming.entity;

import com.encoming.encoming.entity.Encomienda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Ruta.class)
public class Ruta_ { 

    public static volatile SingularAttribute<Ruta, Integer> idRuta;
    public static volatile SingularAttribute<Ruta, Integer> numeroKm;
    public static volatile SingularAttribute<Ruta, Integer> numeroPeajes;
    public static volatile SingularAttribute<Ruta, String> listaCiudades;
    public static volatile ListAttribute<Ruta, Encomienda> encomiendaList;

}
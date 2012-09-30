package com.encoming.encoming.entity;

import com.encoming.encoming.entity.Cliente;
import com.encoming.encoming.entity.Counter;
import com.encoming.encoming.entity.EncomiendaPK;
import com.encoming.encoming.entity.Recibo;
import com.encoming.encoming.entity.Ruta;
import com.encoming.encoming.entity.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Encomienda.class)
public class Encomienda_ { 

    public static volatile ListAttribute<Encomienda, Recibo> reciboList;
    public static volatile SingularAttribute<Encomienda, EncomiendaPK> encomiendaPK;
    public static volatile SingularAttribute<Encomienda, Cliente> cliente;
    public static volatile SingularAttribute<Encomienda, String> tamaño;
    public static volatile SingularAttribute<Encomienda, String> tipo;
    public static volatile SingularAttribute<Encomienda, Counter> counter;
    public static volatile SingularAttribute<Encomienda, String> prioridad;
    public static volatile SingularAttribute<Encomienda, Ruta> ruta;
    public static volatile SingularAttribute<Encomienda, String> ciudadOrigen;
    public static volatile SingularAttribute<Encomienda, String> ciudadDestino;
    public static volatile SingularAttribute<Encomienda, Vehiculo> vehiculo;

}
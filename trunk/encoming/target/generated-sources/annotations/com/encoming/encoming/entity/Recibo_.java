package com.encoming.encoming.entity;

import com.encoming.encoming.entity.Encomienda;
import com.encoming.encoming.entity.ReciboPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T21:48:34")
@StaticMetamodel(Recibo.class)
public class Recibo_ { 

    public static volatile SingularAttribute<Recibo, Encomienda> encomienda;
    public static volatile SingularAttribute<Recibo, Date> fecha;
    public static volatile SingularAttribute<Recibo, ReciboPK> reciboPK;
    public static volatile SingularAttribute<Recibo, String> remitenteEnvio;
    public static volatile SingularAttribute<Recibo, String> destinatarioEnvio;

}
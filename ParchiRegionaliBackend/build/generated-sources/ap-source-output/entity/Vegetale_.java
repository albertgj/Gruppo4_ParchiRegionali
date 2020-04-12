package entity;

import entity.Parco;
import entity.Tipologia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-12T18:56:20")
@StaticMetamodel(Vegetale.class)
public class Vegetale_ { 

    public static volatile SingularAttribute<Vegetale, String> noteVarie;
    public static volatile SingularAttribute<Vegetale, String> nomePianta;
    public static volatile SingularAttribute<Vegetale, Parco> parco;
    public static volatile SingularAttribute<Vegetale, String> stagioneFioritura;
    public static volatile SingularAttribute<Vegetale, Long> id;
    public static volatile SingularAttribute<Vegetale, Tipologia> tipologia;

}
package entity;

import entity.OrdineAppartenenza;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-12T18:56:20")
@StaticMetamodel(Specie.class)
public class Specie_ { 

    public static volatile SingularAttribute<Specie, Long> id;
    public static volatile SingularAttribute<Specie, String> nomeSpecie;
    public static volatile SingularAttribute<Specie, OrdineAppartenenza> ordineAppartenenza;

}
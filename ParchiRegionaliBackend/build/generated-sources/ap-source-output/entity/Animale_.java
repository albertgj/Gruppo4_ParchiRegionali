package entity;

import entity.Parco;
import entity.Specie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-12T18:56:20")
@StaticMetamodel(Animale.class)
public class Animale_ { 

    public static volatile SingularAttribute<Animale, Specie> specie;
    public static volatile SingularAttribute<Animale, Parco> parco;
    public static volatile SingularAttribute<Animale, Integer> numeroFemmine;
    public static volatile SingularAttribute<Animale, Integer> nCuccioliFemmine;
    public static volatile SingularAttribute<Animale, String> nome;
    public static volatile SingularAttribute<Animale, Integer> numeroMaschi;
    public static volatile SingularAttribute<Animale, String> annoPrimoAvvistamento;
    public static volatile SingularAttribute<Animale, Long> id;
    public static volatile SingularAttribute<Animale, Integer> nCuccioliMaschi;
    public static volatile SingularAttribute<Animale, Integer> livelloSalute;
    public static volatile SingularAttribute<Animale, Integer> rischioEstinzione;

}
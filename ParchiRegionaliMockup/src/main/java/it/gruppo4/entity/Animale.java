/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gruppo4.entity;

import javax.persistence.Entity;

/**
 *
 * @author albert
 */
public class Animale
{

    private Long id;
    private String nome;
    private String numeroFemmine;
    private String numeroMaschi;
    private String nCuccioliFemmine;
    private String nCuccioliMaschi;
    private String livelloSalute;
    private String rischioEstinzione;
    private String annoPrimoAvvistamento;
    private Parco parco;
    private Specie specie;

    public Animale(Long id, String nome, String numeroFemmine, String numeroMaschi, String nCuccioliFemmine, String nCuccioliMaschi, String livelloSalute, String rischioEstinzione, String annoPrimoAvvistamento, Parco parco, Specie specie)
    {
        this.id = id;
        this.nome = nome;
        this.numeroFemmine = numeroFemmine;
        this.numeroMaschi = numeroMaschi;
        this.nCuccioliFemmine = nCuccioliFemmine;
        this.nCuccioliMaschi = nCuccioliMaschi;
        this.livelloSalute = livelloSalute;
        this.rischioEstinzione = rischioEstinzione;
        this.annoPrimoAvvistamento = annoPrimoAvvistamento;
        this.parco = parco;
        this.specie = specie;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNumeroFemmine()
    {
        return this.numeroFemmine;
    }

    public void setNumeroFemmine(String numeroFemmine)
    {
        this.numeroFemmine = numeroFemmine;
    }

    public String getNumeroMaschi()
    {
        return this.numeroMaschi;
    }

    public void setNumeroMaschi(String numeroMaschi)
    {
        this.numeroMaschi = numeroMaschi;
    }

    public String getNCuccioliFemmine()
    {
        return this.nCuccioliFemmine;
    }

    public void setNCuccioliFemmine(String nCuccioliFemmine)
    {
        this.nCuccioliFemmine = nCuccioliFemmine;
    }

    public String getNCuccioliMaschi()
    {
        return this.nCuccioliMaschi;
    }

    public void setNCuccioliMaschi(String nCuccioliMaschi)
    {
        this.nCuccioliMaschi = nCuccioliMaschi;
    }

    public String getLivelloSalute()
    {
        return this.livelloSalute;
    }

    public void setLivelloSalute(String livelloSalute)
    {
        this.livelloSalute = livelloSalute;
    }

    public String getRischioEstinzione()
    {
        return this.rischioEstinzione;
    }

    public void setRischioEstinzione(String rischioEstinzione)
    {
        this.rischioEstinzione = rischioEstinzione;
    }

    public String getAnnoPrimoAvvistamento()
    {
        return this.annoPrimoAvvistamento;
    }

    public void setAnnoPrimoAvvistamento(String annoPrimoAvvistamento)
    {
        this.annoPrimoAvvistamento = annoPrimoAvvistamento;
    }

    public Parco getParco()
    {
        return this.parco;
    }

    public void setParco(Parco parco)
    {
        this.parco = parco;
    }

    public Specie getSpecie()
    {
        return this.specie;
    }

    public void setSpecie(Specie specie)
    {
        this.specie = specie;
    }
}

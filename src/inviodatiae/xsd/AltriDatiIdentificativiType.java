//
// Questo file Ŕ stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrÓ persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java per AltriDatiIdentificativiType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="AltriDatiIdentificativiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Denominazione" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}String80LatinType" minOccurs="0"/>
 *         &lt;element name="Nome" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}String60LatinType" minOccurs="0"/>
 *         &lt;element name="Cognome" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}String60LatinType" minOccurs="0"/>
 *         &lt;element name="Sede" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}IndirizzoType" minOccurs="0"/>
 *         &lt;element name="StabileOrganizzazione" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}IndirizzoType" minOccurs="0"/>
 *         &lt;element name="RappresentanteFiscale" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}RappresentanteFiscaleType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AltriDatiIdentificativiType", propOrder = {
    "denominazione",
    "nome",
    "cognome",
    "sede",
    "stabileOrganizzazione",
    "rappresentanteFiscale"
})
public class AltriDatiIdentificativiType {

    @XmlElement(name = "Denominazione")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String denominazione;
    @XmlElement(name = "Nome")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String nome;
    @XmlElement(name = "Cognome")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String cognome;
    @XmlElement(name = "Sede")
    protected IndirizzoType sede;
    @XmlElement(name = "StabileOrganizzazione")
    protected IndirizzoType stabileOrganizzazione;
    @XmlElement(name = "RappresentanteFiscale")
    protected RappresentanteFiscaleType rappresentanteFiscale;

    /**
     * Recupera il valore della proprietÓ denominazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * Imposta il valore della proprietÓ denominazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazione(String value) {
        this.denominazione = value;
    }

    /**
     * Recupera il valore della proprietÓ nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietÓ nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietÓ cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietÓ cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietÓ sede.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoType }
     *     
     */
    public IndirizzoType getSede() {
        return sede;
    }

    /**
     * Imposta il valore della proprietÓ sede.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoType }
     *     
     */
    public void setSede(IndirizzoType value) {
        this.sede = value;
    }

    /**
     * Recupera il valore della proprietÓ stabileOrganizzazione.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoType }
     *     
     */
    public IndirizzoType getStabileOrganizzazione() {
        return stabileOrganizzazione;
    }

    /**
     * Imposta il valore della proprietÓ stabileOrganizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoType }
     *     
     */
    public void setStabileOrganizzazione(IndirizzoType value) {
        this.stabileOrganizzazione = value;
    }

    /**
     * Recupera il valore della proprietÓ rappresentanteFiscale.
     * 
     * @return
     *     possible object is
     *     {@link RappresentanteFiscaleType }
     *     
     */
    public RappresentanteFiscaleType getRappresentanteFiscale() {
        return rappresentanteFiscale;
    }

    /**
     * Imposta il valore della proprietÓ rappresentanteFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link RappresentanteFiscaleType }
     *     
     */
    public void setRappresentanteFiscale(RappresentanteFiscaleType value) {
        this.rappresentanteFiscale = value;
    }

}

//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiFatturaType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiFatturaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatiFatturaHeader" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DatiFatturaHeaderType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="DTE" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DTEType"/>
 *           &lt;element name="DTR" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DTRType"/>
 *           &lt;element name="ANN" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}ANNType"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versione" use="required" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}VersioneType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiFatturaType", propOrder = {
    "datiFatturaHeader",
    "dte",
    "dtr",
    "ann",
    "signature"
})
public class DatiFatturaType {

    @XmlElement(name = "DatiFatturaHeader")
    protected DatiFatturaHeaderType datiFatturaHeader;
    @XmlElement(name = "DTE")
    protected DTEType dte;
    @XmlElement(name = "DTR")
    protected DTRType dtr;
    @XmlElement(name = "ANN")
    protected ANNType ann;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versione", required = true)
    protected VersioneType versione;

    /**
     * Recupera il valore della proprietà datiFatturaHeader.
     * 
     * @return
     *     possible object is
     *     {@link DatiFatturaHeaderType }
     *     
     */
    public DatiFatturaHeaderType getDatiFatturaHeader() {
        return datiFatturaHeader;
    }

    /**
     * Imposta il valore della proprietà datiFatturaHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiFatturaHeaderType }
     *     
     */
    public void setDatiFatturaHeader(DatiFatturaHeaderType value) {
        this.datiFatturaHeader = value;
    }

    /**
     * Recupera il valore della proprietà dte.
     * 
     * @return
     *     possible object is
     *     {@link DTEType }
     *     
     */
    public DTEType getDTE() {
        return dte;
    }

    /**
     * Imposta il valore della proprietà dte.
     * 
     * @param value
     *     allowed object is
     *     {@link DTEType }
     *     
     */
    public void setDTE(DTEType value) {
        this.dte = value;
    }

    /**
     * Recupera il valore della proprietà dtr.
     * 
     * @return
     *     possible object is
     *     {@link DTRType }
     *     
     */
    public DTRType getDTR() {
        return dtr;
    }

    /**
     * Imposta il valore della proprietà dtr.
     * 
     * @param value
     *     allowed object is
     *     {@link DTRType }
     *     
     */
    public void setDTR(DTRType value) {
        this.dtr = value;
    }

    /**
     * Recupera il valore della proprietà ann.
     * 
     * @return
     *     possible object is
     *     {@link ANNType }
     *     
     */
    public ANNType getANN() {
        return ann;
    }

    /**
     * Imposta il valore della proprietà ann.
     * 
     * @param value
     *     allowed object is
     *     {@link ANNType }
     *     
     */
    public void setANN(ANNType value) {
        this.ann = value;
    }

    /**
     * Recupera il valore della proprietà signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Imposta il valore della proprietà signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Recupera il valore della proprietà versione.
     * 
     * @return
     *     possible object is
     *     {@link VersioneType }
     *     
     */
    public VersioneType getVersione() {
        return versione;
    }

    /**
     * Imposta il valore della proprietà versione.
     * 
     * @param value
     *     allowed object is
     *     {@link VersioneType }
     *     
     */
    public void setVersione(VersioneType value) {
        this.versione = value;
    }

}

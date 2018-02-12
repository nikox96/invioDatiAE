//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CedentePrestatoreDTRType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CedentePrestatoreDTRType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificativiFiscali" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}IdentificativiFiscaliType" minOccurs="0"/>
 *         &lt;element name="AltriDatiIdentificativi" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}AltriDatiIdentificativiType" minOccurs="0"/>
 *         &lt;element name="DatiFatturaBodyDTR" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DatiFatturaBodyDTRType" maxOccurs="1000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CedentePrestatoreDTRType", propOrder = {
    "identificativiFiscali",
    "altriDatiIdentificativi",
    "datiFatturaBodyDTR"
})
public class CedentePrestatoreDTRType {

    @XmlElement(name = "IdentificativiFiscali")
    protected IdentificativiFiscaliType identificativiFiscali;
    @XmlElement(name = "AltriDatiIdentificativi")
    protected AltriDatiIdentificativiType altriDatiIdentificativi;
    @XmlElement(name = "DatiFatturaBodyDTR", required = true)
    protected List<DatiFatturaBodyDTRType> datiFatturaBodyDTR;

    /**
     * Recupera il valore della proprietà identificativiFiscali.
     * 
     * @return
     *     possible object is
     *     {@link IdentificativiFiscaliType }
     *     
     */
    public IdentificativiFiscaliType getIdentificativiFiscali() {
        return identificativiFiscali;
    }

    /**
     * Imposta il valore della proprietà identificativiFiscali.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificativiFiscaliType }
     *     
     */
    public void setIdentificativiFiscali(IdentificativiFiscaliType value) {
        this.identificativiFiscali = value;
    }

    /**
     * Recupera il valore della proprietà altriDatiIdentificativi.
     * 
     * @return
     *     possible object is
     *     {@link AltriDatiIdentificativiType }
     *     
     */
    public AltriDatiIdentificativiType getAltriDatiIdentificativi() {
        return altriDatiIdentificativi;
    }

    /**
     * Imposta il valore della proprietà altriDatiIdentificativi.
     * 
     * @param value
     *     allowed object is
     *     {@link AltriDatiIdentificativiType }
     *     
     */
    public void setAltriDatiIdentificativi(AltriDatiIdentificativiType value) {
        this.altriDatiIdentificativi = value;
    }

    /**
     * Gets the value of the datiFatturaBodyDTR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datiFatturaBodyDTR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatiFatturaBodyDTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatiFatturaBodyDTRType }
     * 
     * 
     */
    public List<DatiFatturaBodyDTRType> getDatiFatturaBodyDTR() {
        if (datiFatturaBodyDTR == null) {
            datiFatturaBodyDTR = new ArrayList<DatiFatturaBodyDTRType>();
        }
        return this.datiFatturaBodyDTR;
    }

}

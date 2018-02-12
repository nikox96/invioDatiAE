//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Blocco relativo ai dati del Cedente / Prestatore
 * 
 * <p>Classe Java per CedentePrestatoreDTEType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CedentePrestatoreDTEType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificativiFiscali" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}IdentificativiFiscaliITType"/>
 *         &lt;element name="AltriDatiIdentificativi" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}AltriDatiIdentificativiITType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CedentePrestatoreDTEType", propOrder = {
    "identificativiFiscali",
    "altriDatiIdentificativi"
})
public class CedentePrestatoreDTEType {

    @XmlElement(name = "IdentificativiFiscali", required = true)
    protected IdentificativiFiscaliITType identificativiFiscali;
    @XmlElement(name = "AltriDatiIdentificativi")
    protected AltriDatiIdentificativiITType altriDatiIdentificativi;

    /**
     * Recupera il valore della proprietà identificativiFiscali.
     * 
     * @return
     *     possible object is
     *     {@link IdentificativiFiscaliITType }
     *     
     */
    public IdentificativiFiscaliITType getIdentificativiFiscali() {
        return identificativiFiscali;
    }

    /**
     * Imposta il valore della proprietà identificativiFiscali.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificativiFiscaliITType }
     *     
     */
    public void setIdentificativiFiscali(IdentificativiFiscaliITType value) {
        this.identificativiFiscali = value;
    }

    /**
     * Recupera il valore della proprietà altriDatiIdentificativi.
     * 
     * @return
     *     possible object is
     *     {@link AltriDatiIdentificativiITType }
     *     
     */
    public AltriDatiIdentificativiITType getAltriDatiIdentificativi() {
        return altriDatiIdentificativi;
    }

    /**
     * Imposta il valore della proprietà altriDatiIdentificativi.
     * 
     * @param value
     *     allowed object is
     *     {@link AltriDatiIdentificativiITType }
     *     
     */
    public void setAltriDatiIdentificativi(AltriDatiIdentificativiITType value) {
        this.altriDatiIdentificativi = value;
    }

}

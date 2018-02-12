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
 * <p>Classe Java per DTRType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DTRType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CessionarioCommittenteDTR" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CessionarioCommittenteDTRType"/>
 *         &lt;element name="CedentePrestatoreDTR" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CedentePrestatoreDTRType" maxOccurs="1000"/>
 *         &lt;element name="Rettifica" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}RettificaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTRType", propOrder = {
    "cessionarioCommittenteDTR",
    "cedentePrestatoreDTR",
    "rettifica"
})
public class DTRType {

    @XmlElement(name = "CessionarioCommittenteDTR", required = true)
    protected CessionarioCommittenteDTRType cessionarioCommittenteDTR;
    @XmlElement(name = "CedentePrestatoreDTR", required = true)
    protected List<CedentePrestatoreDTRType> cedentePrestatoreDTR;
    @XmlElement(name = "Rettifica")
    protected RettificaType rettifica;

    /**
     * Recupera il valore della proprietà cessionarioCommittenteDTR.
     * 
     * @return
     *     possible object is
     *     {@link CessionarioCommittenteDTRType }
     *     
     */
    public CessionarioCommittenteDTRType getCessionarioCommittenteDTR() {
        return cessionarioCommittenteDTR;
    }

    /**
     * Imposta il valore della proprietà cessionarioCommittenteDTR.
     * 
     * @param value
     *     allowed object is
     *     {@link CessionarioCommittenteDTRType }
     *     
     */
    public void setCessionarioCommittenteDTR(CessionarioCommittenteDTRType value) {
        this.cessionarioCommittenteDTR = value;
    }

    /**
     * Gets the value of the cedentePrestatoreDTR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cedentePrestatoreDTR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCedentePrestatoreDTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CedentePrestatoreDTRType }
     * 
     * 
     */
    public List<CedentePrestatoreDTRType> getCedentePrestatoreDTR() {
        if (cedentePrestatoreDTR == null) {
            cedentePrestatoreDTR = new ArrayList<CedentePrestatoreDTRType>();
        }
        return this.cedentePrestatoreDTR;
    }

    /**
     * Recupera il valore della proprietà rettifica.
     * 
     * @return
     *     possible object is
     *     {@link RettificaType }
     *     
     */
    public RettificaType getRettifica() {
        return rettifica;
    }

    /**
     * Imposta il valore della proprietà rettifica.
     * 
     * @param value
     *     allowed object is
     *     {@link RettificaType }
     *     
     */
    public void setRettifica(RettificaType value) {
        this.rettifica = value;
    }

}

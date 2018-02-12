//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andra' persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DTEType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DTEType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CedentePrestatoreDTE" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CedentePrestatoreDTEType"/>
 *         &lt;element name="CessionarioCommittenteDTE" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CessionarioCommittenteDTEType" maxOccurs="1000"/>
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
@XmlType(name = "DTEType", propOrder = {
    "cedentePrestatoreDTE",
    "cessionarioCommittenteDTE",
    "rettifica"
})
public class DTEType {

    @XmlElement(name = "CedentePrestatoreDTE", required = true)
    protected CedentePrestatoreDTEType cedentePrestatoreDTE;
    @XmlElement(name = "CessionarioCommittenteDTE", required = true)
    protected List<CessionarioCommittenteDTEType> cessionarioCommittenteDTE;
    @XmlElement(name = "Rettifica")
    protected RettificaType rettifica;

    /**
     * Recupera il valore della propriet� cedentePrestatoreDTE.
     * 
     * @return
     *     possible object is
     *     {@link CedentePrestatoreDTEType }
     *     
     */
    public CedentePrestatoreDTEType getCedentePrestatoreDTE() {
        return cedentePrestatoreDTE;
    }

    /**
     * Imposta il valore della propriet� cedentePrestatoreDTE.
     * 
     * @param value
     *     allowed object is
     *     {@link CedentePrestatoreDTEType }
     *     
     */
    public void setCedentePrestatoreDTE(CedentePrestatoreDTEType value) {
        this.cedentePrestatoreDTE = value;
    }

    /**
     * Gets the value of the cessionarioCommittenteDTE property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cessionarioCommittenteDTE property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCessionarioCommittenteDTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CessionarioCommittenteDTEType }
     * 
     * 
     */
    public List<CessionarioCommittenteDTEType> getCessionarioCommittenteDTE() {
        if (cessionarioCommittenteDTE == null) {
            cessionarioCommittenteDTE = new ArrayList<CessionarioCommittenteDTEType>();
        }
        return this.cessionarioCommittenteDTE;
    }

    /**
     * Recupera il valore della propriet� rettifica.
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
     * Imposta il valore della propriet� rettifica.
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

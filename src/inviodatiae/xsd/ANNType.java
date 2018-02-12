//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andra' persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java per ANNType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ANNType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdFile" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}String18Type"/>
 *         &lt;element name="Posizione" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}PosizioneType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ANNType", propOrder = {
    "idFile",
    "posizione"
})
public class ANNType {

    @XmlElement(name = "IdFile", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String idFile;
    @XmlElement(name = "Posizione")
    @XmlSchemaType(name = "integer")
    protected Integer posizione;

    /**
     * Recupera il valore della propriet� idFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFile() {
        return idFile;
    }

    /**
     * Imposta il valore della propriet� idFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFile(String value) {
        this.idFile = value;
    }

    /**
     * Recupera il valore della propriet� posizione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPosizione() {
        return posizione;
    }

    /**
     * Imposta il valore della propriet� posizione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosizione(Integer value) {
        this.posizione = value;
    }

}

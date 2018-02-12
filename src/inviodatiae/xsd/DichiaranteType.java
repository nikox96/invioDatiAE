//
// Questo file e' stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
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
 * <p>Classe Java per DichiaranteType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DichiaranteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodiceFiscale" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CodiceFiscaleType"/>
 *         &lt;element name="Carica" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CaricaType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DichiaranteType", propOrder = {
    "codiceFiscale",
    "carica"
})
public class DichiaranteType {

    @XmlElement(name = "CodiceFiscale", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String codiceFiscale;
    @XmlElement(name = "Carica")
    @XmlSchemaType(name = "integer")
    protected int carica;

    /**
     * Recupera il valore della propriet� codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della propriet� codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della propriet� carica.
     * 
     */
    public int getCarica() {
        return carica;
    }

    /**
     * Imposta il valore della propriet� carica.
     * 
     */
    public void setCarica(int value) {
        this.carica = value;
    }

}

//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiIVAType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiIVAType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Imposta" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}Amount2DecimalType" minOccurs="0"/>
 *         &lt;element name="Aliquota" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}RateType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiIVAType", propOrder = {
    "imposta",
    "aliquota"
})
public class DatiIVAType {

    @XmlElement(name = "Imposta")
    protected BigDecimal imposta;
    @XmlElement(name = "Aliquota")
    protected BigDecimal aliquota;

    /**
     * Recupera il valore della proprietà imposta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImposta() {
        return imposta;
    }

    /**
     * Imposta il valore della proprietà imposta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImposta(BigDecimal value) {
        this.imposta = value;
    }

    /**
     * Recupera il valore della proprietà aliquota.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAliquota() {
        return aliquota;
    }

    /**
     * Imposta il valore della proprietà aliquota.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAliquota(BigDecimal value) {
        this.aliquota = value;
    }

}

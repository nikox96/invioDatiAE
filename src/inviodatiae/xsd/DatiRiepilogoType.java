//
// Questo file e' stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andra' persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae.xsd;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiRiepilogoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiRiepilogoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImponibileImporto" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}Amount2DecimalType"/>
 *         &lt;element name="DatiIVA" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DatiIVAType"/>
 *         &lt;element name="Natura" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}NaturaType" minOccurs="0"/>
 *         &lt;element name="Detraibile" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}RateType" minOccurs="0"/>
 *         &lt;element name="Deducibile" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DeducibileType" minOccurs="0"/>
 *         &lt;element name="EsigibilitaIVA" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}EsigibilitaIVAType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiRiepilogoType", propOrder = {
    "imponibileImporto",
    "datiIVA",
    "natura",
    "detraibile",
    "deducibile",
    "esigibilitaIVA"
})
public class DatiRiepilogoType {

    @XmlElement(name = "ImponibileImporto", required = true)
    protected BigDecimal imponibileImporto;
    @XmlElement(name = "DatiIVA", required = true)
    protected DatiIVAType datiIVA;
    @XmlElement(name = "Natura")
    @XmlSchemaType(name = "string")
    protected NaturaType natura;
    @XmlElement(name = "Detraibile")
    protected BigDecimal detraibile;
    @XmlElement(name = "Deducibile")
    @XmlSchemaType(name = "string")
    protected DeducibileType deducibile;
    @XmlElement(name = "EsigibilitaIVA")
    @XmlSchemaType(name = "string")
    protected EsigibilitaIVAType esigibilitaIVA;

    /**
     * Recupera il valore della propriet� imponibileImporto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImponibileImporto() {
        return imponibileImporto;
    }

    /**
     * Imposta il valore della propriet� imponibileImporto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImponibileImporto(BigDecimal value) {
        this.imponibileImporto = value;
    }

    /**
     * Recupera il valore della propriet� datiIVA.
     * 
     * @return
     *     possible object is
     *     {@link DatiIVAType }
     *     
     */
    public DatiIVAType getDatiIVA() {
        return datiIVA;
    }

    /**
     * Imposta il valore della propriet� datiIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiIVAType }
     *     
     */
    public void setDatiIVA(DatiIVAType value) {
        this.datiIVA = value;
    }

    /**
     * Recupera il valore della propriet� natura.
     * 
     * @return
     *     possible object is
     *     {@link NaturaType }
     *     
     */
    public NaturaType getNatura() {
        return natura;
    }

    /**
     * Imposta il valore della propriet� natura.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturaType }
     *     
     */
    public void setNatura(NaturaType value) {
        this.natura = value;
    }

    /**
     * Recupera il valore della propriet� detraibile.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDetraibile() {
        return detraibile;
    }

    /**
     * Imposta il valore della propriet� detraibile.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDetraibile(BigDecimal value) {
        this.detraibile = value;
    }

    /**
     * Recupera il valore della propriet� deducibile.
     * 
     * @return
     *     possible object is
     *     {@link DeducibileType }
     *     
     */
    public DeducibileType getDeducibile() {
        return deducibile;
    }

    /**
     * Imposta il valore della propriet� deducibile.
     * 
     * @param value
     *     allowed object is
     *     {@link DeducibileType }
     *     
     */
    public void setDeducibile(DeducibileType value) {
        this.deducibile = value;
    }

    /**
     * Recupera il valore della propriet� esigibilitaIVA.
     * 
     * @return
     *     possible object is
     *     {@link EsigibilitaIVAType }
     *     
     */
    public EsigibilitaIVAType getEsigibilitaIVA() {
        return esigibilitaIVA;
    }

    /**
     * Imposta il valore della propriet� esigibilitaIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link EsigibilitaIVAType }
     *     
     */
    public void setEsigibilitaIVA(EsigibilitaIVAType value) {
        this.esigibilitaIVA = value;
    }

}

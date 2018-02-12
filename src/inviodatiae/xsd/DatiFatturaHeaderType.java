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
 * <p>Classe Java per DatiFatturaHeaderType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiFatturaHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProgressivoInvio" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}String10Type" minOccurs="0"/>
 *         &lt;element name="Dichiarante" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}DichiaranteType" minOccurs="0"/>
 *         &lt;element name="IdSistema" type="{http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v2.0}CodiceFiscaleType" minOccurs="0"/>
 *         &lt;element name="SpazioDatiFattura" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiFatturaHeaderType", propOrder = {
    "progressivoInvio",
    "dichiarante",
    "idSistema",
    "spazioDatiFattura"
})
public class DatiFatturaHeaderType {

    @XmlElement(name = "ProgressivoInvio")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String progressivoInvio;
    @XmlElement(name = "Dichiarante")
    protected DichiaranteType dichiarante;
    @XmlElement(name = "IdSistema")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String idSistema;
    @XmlElement(name = "SpazioDatiFattura")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String spazioDatiFattura;

    /**
     * Recupera il valore della propriet� progressivoInvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgressivoInvio() {
        return progressivoInvio;
    }

    /**
     * Imposta il valore della propriet� progressivoInvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgressivoInvio(String value) {
        this.progressivoInvio = value;
    }

    /**
     * Recupera il valore della propriet� dichiarante.
     * 
     * @return
     *     possible object is
     *     {@link DichiaranteType }
     *     
     */
    public DichiaranteType getDichiarante() {
        return dichiarante;
    }

    /**
     * Imposta il valore della propriet� dichiarante.
     * 
     * @param value
     *     allowed object is
     *     {@link DichiaranteType }
     *     
     */
    public void setDichiarante(DichiaranteType value) {
        this.dichiarante = value;
    }

    /**
     * Recupera il valore della propriet� idSistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSistema() {
        return idSistema;
    }

    /**
     * Imposta il valore della propriet� idSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSistema(String value) {
        this.idSistema = value;
    }

    /**
     * Recupera il valore della propriet� spazioDatiFattura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpazioDatiFattura() {
        return spazioDatiFattura;
    }

    /**
     * Imposta il valore della propriet� spazioDatiFattura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpazioDatiFattura(String value) {
        this.spazioDatiFattura = value;
    }

}

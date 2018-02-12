//
// Questo file e' stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andra' persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.02.12 alle 06:53:03 PM CET 
//


package inviodatiae.xsd;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TipoDocumentoType.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoDocumentoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;length value="4"/>
 *     &lt;enumeration value="TD01"/>
 *     &lt;enumeration value="TD04"/>
 *     &lt;enumeration value="TD05"/>
 *     &lt;enumeration value="TD07"/>
 *     &lt;enumeration value="TD08"/>
 *     &lt;enumeration value="TD10"/>
 *     &lt;enumeration value="TD11"/>
 *     &lt;enumeration value="TD12"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoDocumentoType")
@XmlEnum
public enum TipoDocumentoType {


    /**
     * Fattura
     * 
     */
    @XmlEnumValue("TD01")
    TD_01("TD01"),

    /**
     * Nota di credito
     * 
     */
    @XmlEnumValue("TD04")
    TD_04("TD04"),

    /**
     * Nota di debito
     * 
     */
    @XmlEnumValue("TD05")
    TD_05("TD05"),

    /**
     * Fattura semplificata
     * 
     */
    @XmlEnumValue("TD07")
    TD_07("TD07"),

    /**
     * Nota di credito semplificata
     * 
     */
    @XmlEnumValue("TD08")
    TD_08("TD08"),

    /**
     * Acquisto beni intra
     * 
     */
    @XmlEnumValue("TD10")
    TD_10("TD10"),

    /**
     * Acquisto servizi intra
     * 
     */
    @XmlEnumValue("TD11")
    TD_11("TD11"),

    /**
     * Documento riepilogativo (art. 6, DPR 695/1996)
     * 
     */
    @XmlEnumValue("TD12")
    TD_12("TD12");
    private final String value;

    TipoDocumentoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoDocumentoType fromValue(String v) {
        for (TipoDocumentoType c: TipoDocumentoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

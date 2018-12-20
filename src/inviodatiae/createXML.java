/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inviodatiae;

import inviodatiae.xsd.DatiFatturaBodyDTEType;
import inviodatiae.xsd.IndirizzoType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.xml.sax.SAXException;
import inviodatiae.xsd.*;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.datatype.DatatypeConstants;

/**
 * @since 28/09/2017
 * @version 2.0.0
 * @author Nicolò
 */
public class createXML {

    static ObjectFactory xml;
    static DatiFatturaType rootDTE, rootDTR, rootANN;

    //header: progressivo e id sistema
    static DatiFatturaHeaderType header;
    //codice fiscale e carica dichiarante
    static DichiaranteType dic;

    //contiene i dati per fatture emesse
    static DTEType dte;
    static CedentePrestatoreDTEType dteCed;

    static IdentificativiFiscaliITType idenFisCed;
    static IdFiscaleITType idFisCed;

    static AltriDatiIdentificativiITType idenAltriCed;

    static IndirizzoType indCedSede;
    static IndirizzoType indCedStabOrg;
    static RappresentanteFiscaleITType cedRappFis;
    static IdFiscaleITType idFisCedRappFis;

    static CessionarioCommittenteDTEType dteCess;

    static IdentificativiFiscaliNoIVAType idenFisCess;
    static IdFiscaleType idFisCess;

    static AltriDatiIdentificativiType idenAltriCess;

    static IndirizzoType indCessSede;
    static IndirizzoType indCessStabOrg;
    static RappresentanteFiscaleType cessRappFis;
    static IdFiscaleType idFisCessRappFis;

    static DatiFatturaBodyDTEType datiFatBodyDTE;

    static DatiGeneraliDTEType datiGenDTE;
    static DatiRiepilogoType datiRiepilogoDTE;

    static DatiIVAType datiIvaDTE;

    static RettificaType rettDTE;

    //contiene i dati per fatture ricevute
    static DTRType dtr;
    static CedentePrestatoreDTRType dtrCed;

    static IdentificativiFiscaliType idenFisCedDTR;
    static IdFiscaleType idFisCedDTR;

    static AltriDatiIdentificativiType idenAltriCedDTR;

    static IndirizzoType indCedSedeDTR;
    static IndirizzoType indCedStabOrgDTR;
    static RappresentanteFiscaleType cedRappFisDTR;
    static IdFiscaleType idFisCedRappFisDTR;

    static CessionarioCommittenteDTRType dtrCess;

    static IdentificativiFiscaliITType idenFisCessDTR;
    static IdFiscaleITType idFisCessDTR;

    static AltriDatiIdentificativiITType idenAltriCessDTR;

    static IndirizzoType indCessSedeDTR;
    static IndirizzoType indCessStabOrgDTR;
    static RappresentanteFiscaleITType cessRappFisDTR;
    static IdFiscaleITType idFisCessRappFisDTR;

    static DatiFatturaBodyDTRType datiFatBodyDTR;

    static DatiGeneraliDTRType datiGenDTR;
    static DatiRiepilogoType datiRiepilogoDTR;

    static DatiIVAType datiIvaDTR;

    static RettificaType rettDTR;

    static ANNType ann;
    static JAXBContext jaxbContext;
    static Marshaller marshaller;
    static FileWriter fw;
    static String cf, appdata;
    static BufferedWriter bwe = null;
    static Date date = new Date();

    static int lvlCur, lvlPrev = 0, tipFatt, nprg, line, retCod, cessDTE, bodyDTE, riepDTE, cedDTR, bodyDTR, riepDTR;

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static boolean dtePrinted = false;
    private static boolean dtrPrinted = false;

    /*
    *  tipo fattura: 1- RET
    *                2- DTE
    *                3- DTR
    *                4- ANN
     */
    /**
     * @param args the command line arguments
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     * @throws javax.xml.datatype.DatatypeConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException, IOException, SAXException {
        xml = new ObjectFactory();
        rootDTE = xml.createDatiFatturaType();
        rootDTR = xml.createDatiFatturaType();
        rootANN = xml.createDatiFatturaType();
        nprg = 0;
        cessDTE = 0;
        riepDTE = 0;
        bodyDTE = 0;
        cedDTR = 0;
        riepDTR = 0;
        bodyDTR = 0;
        //SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        //Schema schema = schemaFactory.newSchema(new File("C:\\Users\\Nicolò\\Documents\\Dati fatture ae\\V2.0\\DatiFattura_v2.0.xsd"));

        initializeVar();

        jaxbContext = JAXBContext.newInstance("inviodatiae.xsd");
        marshaller = jaxbContext.createMarshaller();
        //marshaller.setSchema(schema);

        BufferedReader br = null;
        File fTemp;
        FileReader fr = null;
        fw = null;

        FileWriter fwe = null;
        JFileChooser jfc = new JFileChooser();
        JFrame jf = new JFrame("Conversione dati fatture in XML");
        JPanel jp = new JPanel();
        jp.setVisible(true);
        jf.getContentPane().add(jp, BorderLayout.CENTER);
        jf.setVisible(true);

        try {
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jfc.setDialogTitle("Scegli file da convertire in XML");
            jfc.setDialogType(JFileChooser.OPEN_DIALOG);
            jfc.setMultiSelectionEnabled(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            jfc.setFileFilter(filter);
            jfc.setVisible(true);

            while (jfc.getSelectedFile() == null || !(jfc.getSelectedFile().exists())) {
                if (jfc.showOpenDialog(jf) == JFileChooser.CANCEL_OPTION) {
                    System.exit(1);
                }
            }
            //appdata = System.getenv("AppData");
            appdata = jfc.getSelectedFile().getParent();
            if ("".equals(appdata) || appdata == null) {
                System.out.println("env var not defined!");
                return;
            }

            fTemp = new File(appdata + "\\ae_datiFatture");
            if (!(fTemp.exists())) {
                fTemp.mkdirs();
            }
            fTemp = new File(appdata + "\\ae_datiFatture\\spesometro_err.log");
            if (!(fTemp.exists())) {
                fTemp.createNewFile();
            }
            fwe = new FileWriter(fTemp);
            bwe = new BufferedWriter(fwe);
            
            cf = JOptionPane.showInputDialog("Codice fiscale del dichiarante:");
            if (cf == null || "".equals(cf) || " ".equals(cf)) {
                cf = "cfcfcfcfcfcfcfcf";
            } else {
                dic.setCodiceFiscale(cf);
                int carica = Integer.parseInt(JOptionPane.showInputDialog("Codice carica: (valori ammessi tra 1 e 15)"));
                while (carica < 1 || carica > 15) {
                    carica = Integer.parseInt(JOptionPane.showInputDialog("Codice carica: (valori ammessi tra 1 e 15)"));
                }
                dic.setCarica(carica);
            }

            fr = new FileReader(jfc.getSelectedFile());
            br = new BufferedReader(new InputStreamReader(new FileInputStream(jfc.getSelectedFile()), "Cp1252"));

            String sCurrentLine = br.readLine();
            while (sCurrentLine != null) {
                // serialise to xml
                line++;
                bwe.write(sdf.format(date) + " >   " + "init-tratt @line: " + line + "\n");

                try {
                    retCod = getXml(sCurrentLine);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(jp, "Errore riga " + line + "\nValore riga: " + sCurrentLine + "\nEccezione sollevata: " + e.toString() + "\n", "Formato dato errato", JOptionPane.WARNING_MESSAGE);
                }

                switch (retCod) {
                    case 1:
                        break;
                    default:
                        bwe.write(sdf.format(date) + " >   " + "errore tipo: " + retCod + "\n");
                        break;
                }
                sCurrentLine = br.readLine();
            }

            nprg += 1;
            fw = new FileWriter(appdata + "\\ae_datiFatture\\IT" + cf.trim() + "_DF_" + tipFatt + String.format("%04d", nprg) + ".xml");
            switch (tipFatt) {
                case 4:
                    if (ann != null) {
                        rootANN.setANN(ann);
                        header.setDichiarante(dic);
                        rootANN.setDatiFatturaHeader(header);
                        marshaller.marshal(rootANN, fw);
                    }
                    break;
                default:
                    break;
            }

            if (JOptionPane.showConfirmDialog(jp, "Si desidera aprire la cartella dove sono stati prodotti i file?") == JOptionPane.YES_OPTION) {
                Runtime.getRuntime().exec("explorer.exe " + appdata + "\\ae_datiFatture");
            }
            System.exit(1);
        } catch (JAXBException je) {
            je.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (bwe != null) {
                    bwe.write(sdf.format(date) + " >   righe lette: " + line);
                    bwe.close();
                }
                if (fwe != null) {
                    fwe.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    private static void initializeVar() {
        //header: progressivo e id sistema
        rootDTE = xml.createDatiFatturaType();
        rootDTR = xml.createDatiFatturaType();
        rootANN = xml.createDatiFatturaType();
        header = xml.createDatiFatturaHeaderType();
        //codice fiscale e carica dichiarante
        dic = xml.createDichiaranteType();

        //contiene i dati per fatture emesse
        dte = xml.createDTEType();
        dteCed = xml.createCedentePrestatoreDTEType();

        idenFisCed = xml.createIdentificativiFiscaliITType();
        idFisCed = xml.createIdFiscaleITType();

        idenAltriCed = xml.createAltriDatiIdentificativiITType();

        indCedSede = xml.createIndirizzoType();
        indCedStabOrg = xml.createIndirizzoType();
        cedRappFis = xml.createRappresentanteFiscaleITType();
        idFisCedRappFis = xml.createIdFiscaleITType();

        dteCess = xml.createCessionarioCommittenteDTEType();

        idenFisCess = xml.createIdentificativiFiscaliNoIVAType();
        idFisCess = xml.createIdFiscaleType();

        idenAltriCess = xml.createAltriDatiIdentificativiType();

        indCessSede = xml.createIndirizzoType();
        indCessStabOrg = xml.createIndirizzoType();
        cessRappFis = xml.createRappresentanteFiscaleType();
        idFisCessRappFis = xml.createIdFiscaleType();

        datiFatBodyDTE = xml.createDatiFatturaBodyDTEType();

        datiGenDTE = xml.createDatiGeneraliDTEType();
        datiRiepilogoDTE = xml.createDatiRiepilogoType();

        datiIvaDTE = xml.createDatiIVAType();

        rettDTE = xml.createRettificaType();

        //contiene i dati per fatture ricevute
        dtr = xml.createDTRType();
        dtrCed = xml.createCedentePrestatoreDTRType();

        idenFisCedDTR = xml.createIdentificativiFiscaliType();
        idFisCedDTR = xml.createIdFiscaleType();

        idenAltriCedDTR = xml.createAltriDatiIdentificativiType();

        indCedSedeDTR = xml.createIndirizzoType();
        indCedStabOrgDTR = xml.createIndirizzoType();
        cedRappFisDTR = xml.createRappresentanteFiscaleType();
        idFisCedRappFisDTR = xml.createIdFiscaleType();

        dtrCess = xml.createCessionarioCommittenteDTRType();

        idenFisCessDTR = xml.createIdentificativiFiscaliITType();
        idFisCessDTR = xml.createIdFiscaleITType();

        idenAltriCessDTR = xml.createAltriDatiIdentificativiITType();

        indCessSedeDTR = xml.createIndirizzoType();
        indCessStabOrgDTR = xml.createIndirizzoType();
        cessRappFisDTR = xml.createRappresentanteFiscaleITType();
        idFisCessRappFisDTR = xml.createIdFiscaleITType();

        datiFatBodyDTR = xml.createDatiFatturaBodyDTRType();

        datiGenDTR = xml.createDatiGeneraliDTRType();
        datiRiepilogoDTR = xml.createDatiRiepilogoType();

        datiIvaDTR = xml.createDatiIVAType();

        rettDTR = xml.createRettificaType();
        cessDTE = 0;
        riepDTE = 0;
        bodyDTE = 0;
        cedDTR = 0;
        riepDTR = 0;
        bodyDTR = 0;
    }

    private static int getXml(String s) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException, IOException {
        String[] index;
        DecimalFormat df = new DecimalFormat("######0.00");

        bwe.write(sdf.format(date) + " >   before split: " + s + "\n");             //@debug
        index = s.split(";");
        bwe.write(sdf.format(date) + " >   after split[0]: " + index[0] + "\n");    //@debug
        index[0] = index[0].replaceAll("\\s+", "");
        bwe.write(sdf.format(date) + " >   after replace[0]: " + index[0] + "\n");  //@debug
        if (index.length > 1) {
            bwe.write(sdf.format(date) + " >   after split[1]: " + index[1] + "\n");    //@debug
            index[1] = index[1].replaceAll("[^a-zA-Z0-9- ]+", "");
            bwe.write(sdf.format(date) + " >   after replace[1]: " + index[1] + "\n");          //@debug
        }
        //System.out.println("lvl " + index[0]);

        if (Character.getNumericValue(index[0].charAt(0)) == 3 && dtePrinted == false) {
            buildDTEXml();
            nprg += 1;
            fw = new FileWriter(appdata + "\\ae_datiFatture\\IT" + cf.trim() + "_DF_" + tipFatt + String.format("%04d", nprg) + ".xml");
            marshaller.marshal(rootDTE, fw);
            dtePrinted = true;
        }
        if (Character.getNumericValue(index[0].charAt(0)) == 4 && dtrPrinted == false) {
            buildDTRXml();
            nprg += 1;
            fw = new FileWriter(appdata + "\\ae_datiFatture\\IT" + cf.trim() + "_DF_" + tipFatt + String.format("%04d", nprg) + ".xml");
            marshaller.marshal(rootDTR, fw);
            dtrPrinted = true;
        }
        if (index.length != 2) {
            return 3;
        } else {
            lvlCur = cntlLvl(index[0].replace(".", "").replace(",", ""));
            if (lvlPrev >= lvlCur) {
                if (lvlCur > 211100 && lvlCur < 212640) {
                    return 5;
                } else if (lvlCur > 220000 && lvlCur < 222640) {
                    buildCessXml();
                } else if (lvlCur > 223000 && lvlCur < 223200) {
                    buildFatturaBodyDTEXml();
                } else if (lvlCur > 223200 && lvlCur < 230000) {
                    buildFatturaRiepDTEXml();
                } else if (lvlCur > 311100 && lvlCur < 312640) {
                    return 10;
                } else if (lvlCur > 320000 && lvlCur < 322640) {
                    buildCedDTRXml();
                } else if (lvlCur > 323000 && lvlCur < 323200) {
                    buildFatturaBodyDTRXml();
                } else if (lvlCur > 323200 && lvlCur < 330000) {
                    buildFatturaRiepDTRXml();
                } else {
                    return 8;
                }
            }
            tipFatt = Character.getNumericValue(index[0].charAt(0));

            switch (index[0]) {
                case "1.1":
                    header.setProgressivoInvio(index[1]);
                    break;
                case "1.2.1":
                    //dic.setCodiceFiscale(index[1]);
                    break;
                case "1.2.2":
                    //dic.setCarica(Integer.parseInt(index[1]));
                    break;
                case "1.3":
                    //v2.1 da non valorizzare header.setIdSistema(index[1]);
                    break;
                //v2.1-inizio
                case "1.4":
                    //spazio dati fattura campo di sistema (da non valorizzare)
                    break;
                //v2.1-fine
                case "2.1.1.1.1":
                    idFisCed.setIdPaese(NazioneITType.valueOf(index[1]));
                    break;
                case "2.1.1.1.2":
                    cf = index[1];
                    idFisCed.setIdCodice(index[1]);
                    break;
                case "2.1.1.2":
                    idenFisCed.setCodiceFiscale(index[1]);
                    break;
                case "2.1.2.1":
                    idenAltriCed.setDenominazione(index[1]);
                    break;
                case "2.1.2.2":
                    idenAltriCed.setNome(index[1]);
                    break;
                case "2.1.2.3":
                    idenAltriCed.setCognome(index[1]);
                    break;
                case "2.1.2.4.1":
                    indCedSede.setIndirizzo(index[1]);
                    break;
                case "2.1.2.4.2":
                    indCedSede.setNumeroCivico(index[1]);
                    break;
                case "2.1.2.4.3":
                    indCedSede.setCAP(index[1]);
                    break;
                case "2.1.2.4.4":
                    indCedSede.setComune(index[1]);
                    break;
                case "2.1.2.4.5":
                    indCedSede.setProvincia(index[1]);
                    break;
                case "2.1.2.4.6":
                    indCedSede.setNazione(index[1]);
                    break;
                case "2.1.2.5.1":
                    indCedStabOrg.setIndirizzo(index[1]);
                    break;
                case "2.1.2.5.2":
                    indCedStabOrg.setNumeroCivico(index[1]);
                    break;
                case "2.1.2.5.3":
                    indCedStabOrg.setCAP(index[1]);
                    break;
                case "2.1.2.5.4":
                    indCedStabOrg.setComune(index[1]);
                    break;
                case "2.1.2.5.5":
                    indCedStabOrg.setProvincia(index[1]);
                    break;
                case "2.1.2.5.6":
                    indCedStabOrg.setNazione(index[1]);
                    break;
                case "2.1.2.6.1.1":
                    idFisCedRappFis.setIdPaese(NazioneITType.valueOf(index[1]));
                    break;
                case "2.1.2.6.1.2":
                    idFisCedRappFis.setIdCodice(index[1]);
                    break;
                case "2.1.2.6.2":
                    cedRappFis.setDenominazione(index[1]);
                    break;
                case "2.1.2.6.3":
                    cedRappFis.setNome(index[1]);
                    break;
                case "2.1.2.6.4":
                    cedRappFis.setCognome(index[1]);
                    break;
                case "2.2.1.1.1":
                    idFisCess.setIdPaese(index[1]);
                    break;
                case "2.2.1.1.2":
                    idFisCess.setIdCodice(index[1]);
                    break;
                case "2.2.1.2":
                    idenFisCess.setCodiceFiscale(index[1]);
                    break;
                case "2.2.2.1":
                    idenAltriCess.setDenominazione(index[1]);
                    break;
                case "2.2.2.2":
                    idenAltriCess.setNome(index[1]);
                    break;
                case "2.2.2.3":
                    idenAltriCess.setCognome((index[1]));
                    break;
                case "2.2.2.4.1":
                    indCessSede.setIndirizzo(index[1]);
                    break;
                case "2.2.2.4.2":
                    indCessSede.setNumeroCivico(index[1]);
                    break;
                case "2.2.2.4.3":
                    indCessSede.setCAP(index[1]);
                    break;
                case "2.2.2.4.4":
                    indCessSede.setComune(index[1]);
                    break;
                case "2.2.2.4.5":
                    indCessSede.setProvincia(index[1]);
                    break;
                case "2.2.2.4.6":
                    indCessSede.setNazione(index[1]);
                    break;
                case "2.2.2.5.1":
                    indCessStabOrg.setIndirizzo(index[1]);
                    break;
                case "2.2.2.5.2":
                    indCessStabOrg.setNumeroCivico(index[1]);
                    break;
                case "2.2.2.5.3":
                    indCessStabOrg.setCAP(index[1]);
                    break;
                case "2.2.2.5.4":
                    indCessStabOrg.setComune(index[1]);
                    break;
                case "2.2.2.5.5":
                    indCessStabOrg.setProvincia(index[1]);
                    break;
                case "2.2.2.5.6":
                    indCessStabOrg.setNazione(index[1]);
                    break;
                case "2.2.2.6.1.1":
                    idFisCessRappFis.setIdPaese(index[1]);
                    break;
                case "2.2.2.6.1.2":
                    idFisCessRappFis.setIdCodice(index[1]);
                    break;
                case "2.2.2.6.2":
                    cessRappFis.setDenominazione(index[1]);
                    break;
                case "2.2.2.6.3":
                    cessRappFis.setNome(index[1]);
                    break;
                case "2.2.2.6.4":
                    cessRappFis.setCognome(index[1]);
                    break;
                case "2.2.3.1.1":
                    datiGenDTE.setTipoDocumento(TipoDocumentoType.fromValue(index[1]));
                    break;
                case "2.2.3.1.2":
                    datiGenDTE.setData(getXMLGregorianCalendar(index[1]));
                    break;
                case "2.2.3.1.3":
                    datiGenDTE.setNumero(index[1]);
                    break;
                case "2.2.3.2.1":
                    index[1] = index[1].replace(",", ".");
                    datiRiepilogoDTE.setImponibileImporto(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "2.2.3.2.2.1":
                    index[1] = index[1].replace(",", ".");
                    datiIvaDTE.setImposta(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "2.2.3.2.2.2":
                    index[1] = index[1].replace(",", ".");
                    datiIvaDTE.setAliquota(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "2.2.3.2.3":
                    datiRiepilogoDTE.setNatura(NaturaType.fromValue(index[1]));
                    break;
                case "2.2.3.2.4":
                    index[1] = index[1].replace(",", ".");
                    datiRiepilogoDTE.setDetraibile(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "2.2.3.2.5":
                    datiRiepilogoDTE.setDeducibile(DeducibileType.fromValue(index[1]));
                    break;
                case "2.2.3.2.6":
                    datiRiepilogoDTE.setEsigibilitaIVA(EsigibilitaIVAType.fromValue(index[1]));
                    break;
                case "2.3.1":
                    tipFatt = 1;
                    rettDTE.setIdFile(index[1]);
                    break;
                case "2.3.2":
                    tipFatt = 1;
                    rettDTE.setPosizione(Integer.parseInt(index[1]));
                    break;
                case "3.1.1.1.1":
                    idFisCessDTR.setIdPaese(NazioneITType.fromValue(index[1]));
                    break;
                case "3.1.1.1.2":
                    idFisCessDTR.setIdCodice(index[1]);
                    break;
                case "3.1.1.2":
                    idenFisCessDTR.setCodiceFiscale(index[1]);
                    break;
                case "3.1.2.1":
                    idenAltriCessDTR.setDenominazione(index[1]);
                    break;
                case "3.1.2.2":
                    idenAltriCessDTR.setNome(index[1]);
                    break;
                case "3.1.2.3":
                    idenAltriCessDTR.setCognome(index[1]);
                    break;
                case "3.1.2.4.1":
                    indCessSedeDTR.setIndirizzo(index[1]);
                    break;
                case "3.1.2.4.2":
                    indCessSedeDTR.setNumeroCivico(index[1]);
                    break;
                case "3.1.2.4.3":
                    indCessSedeDTR.setCAP(index[1]);
                    break;
                case "3.1.2.4.4":
                    indCessSedeDTR.setComune(index[1]);
                    break;
                case "3.1.2.4.5":
                    indCessSedeDTR.setProvincia(index[1]);
                    break;
                case "3.1.2.4.6":
                    indCessSedeDTR.setNazione(index[1]);
                    break;
                case "3.1.2.5.1":
                    indCessStabOrgDTR.setIndirizzo(index[1]);
                    break;
                case "3.1.2.5.2":
                    indCessStabOrgDTR.setNumeroCivico(index[1]);
                    break;
                case "3.1.2.5.3":
                    indCessStabOrgDTR.setCAP(index[1]);
                    break;
                case "3.1.2.5.4":
                    indCessStabOrgDTR.setComune(index[1]);
                    break;
                case "3.1.2.5.5":
                    indCessStabOrgDTR.setProvincia(index[1]);
                    break;
                case "3.1.2.5.6":
                    indCessStabOrgDTR.setNazione(index[1]);
                    break;
                case "3.1.2.6.1.1":
                    idFisCessRappFisDTR.setIdPaese(NazioneITType.fromValue(index[1]));
                    break;
                case "3.1.2.6.1.2":
                    idFisCessRappFisDTR.setIdCodice(index[1]);
                    break;
                case "3.1.2.6.2":
                    cessRappFisDTR.setDenominazione(index[1]);
                    break;
                case "3.1.2.6.3":
                    cessRappFisDTR.setCognome(index[1]);
                    break;
                case "3.1.2.6.4":
                    cessRappFisDTR.setNome(index[1]);
                    break;
                case "3.2.1.1.1":
                    idFisCedDTR.setIdPaese(index[1]);
                    break;
                case "3.2.1.1.2":
                    idFisCedDTR.setIdCodice(index[1]);
                    break;
                case "3.2.1.2":
                    idenFisCedDTR.setCodiceFiscale(index[1]);
                    break;
                case "3.2.2.1":
                    idenAltriCedDTR.setDenominazione(index[1]);
                    break;
                case "3.2.2.2":
                    idenAltriCedDTR.setNome(index[1]);
                    break;
                case "3.2.2.3":
                    idenAltriCedDTR.setCognome(index[1]);
                    break;
                case "3.2.2.4.1":
                    indCedSedeDTR.setIndirizzo(index[1]);
                    break;
                case "3.2.2.4.2":
                    indCedSedeDTR.setNumeroCivico(index[1]);
                    break;
                case "3.2.2.4.3":
                    indCedSedeDTR.setCAP(index[1]);
                    break;
                case "3.2.2.4.4":
                    indCedSedeDTR.setComune(index[1]);
                    break;
                case "3.2.2.4.5":
                    indCedSedeDTR.setProvincia(index[1]);
                    break;
                case "3.2.2.4.6":
                    indCedSedeDTR.setNazione(index[1]);
                    break;
                case "3.2.2.5.1":
                    indCedStabOrgDTR.setIndirizzo(index[1]);
                    break;
                case "3.2.2.5.2":
                    indCedStabOrgDTR.setNumeroCivico(index[1]);
                    break;
                case "3.2.2.5.3":
                    indCedStabOrgDTR.setCAP(index[1]);
                    break;
                case "3.2.2.5.4":
                    indCedStabOrgDTR.setComune(index[1]);
                    break;
                case "3.2.2.5.5":
                    indCedStabOrgDTR.setProvincia(index[1]);
                    break;
                case "3.2.2.5.6":
                    indCedStabOrgDTR.setNazione(index[1]);
                    break;
                case "3.2.2.6.1.1":
                    idFisCedRappFisDTR.setIdPaese(index[1]);
                    break;
                case "3.2.2.6.1.2":
                    idFisCedRappFisDTR.setIdCodice(index[1]);
                    break;
                case "3.2.2.6.2":
                    cedRappFisDTR.setDenominazione(index[1]);
                    break;
                case "3.2.2.6.3":
                    cedRappFisDTR.setNome(index[1]);
                    break;
                case "3.2.2.6.4":
                    cedRappFisDTR.setCognome(index[1]);
                    break;
                case "3.2.3.1.1":
                    datiGenDTR.setTipoDocumento(TipoDocumentoType.fromValue(index[1]));
                    break;
                case "3.2.3.1.2":
                    datiGenDTR.setData(getXMLGregorianCalendar(index[1]));
                    break;
                case "3.2.3.1.3":
                    datiGenDTR.setNumero(index[1]);
                    break;
                case "3.2.3.1.4":
                    datiGenDTR.setDataRegistrazione(getXMLGregorianCalendar(index[1]));
                    break;
                case "3.2.3.2.1":
                    index[1] = index[1].replace(",", ".");
                    datiRiepilogoDTR.setImponibileImporto(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "3.2.3.2.2.1":
                    index[1] = index[1].replace(",", ".");
                    datiIvaDTR.setImposta(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "3.2.3.2.2.2":
                    index[1] = index[1].replace(",", ".");
                    datiIvaDTR.setAliquota(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "3.2.3.2.3":
                    datiRiepilogoDTR.setNatura(NaturaType.fromValue(index[1]));
                    break;
                case "3.2.3.2.4":
                    index[1] = index[1].replace(",", ".");
                    datiRiepilogoDTR.setDetraibile(new BigDecimal(("0".equals(index[1]) ? "0.00" : index[1])));
                    break;
                case "3.2.3.2.5":
                    datiRiepilogoDTR.setDeducibile(DeducibileType.fromValue(index[1]));
                    break;
                case "3.2.3.2.6":
                    datiRiepilogoDTR.setEsigibilitaIVA(EsigibilitaIVAType.fromValue(index[1]));
                    break;
                case "3.3.1":
                    rettDTR.setIdFile(index[1]);
                    break;
                case "3.3.2":
                    rettDTR.setPosizione(Integer.parseInt(index[1]));
                    break;
                case "4.1":
                    ann.setIdFile(index[1]);
                    break;
                case "4.2":
                    ann.setPosizione(Integer.parseInt(index[1]));
                    break;
            }
            lvlPrev = lvlCur;
        }
        return 1;
    }

    private static int cntlLvl(String s) {
        if (s.length() < 6) {
            s += "0";
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(cntlLvl(s));
            s = sb.toString();
        }
        return Integer.parseInt(s);
    }

    private static void buildDTEXml() throws JAXBException, FileNotFoundException {

        buildCedXml();

        if (!(rettDTE.getIdFile() == null || "".equals(rettDTE.getIdFile()))) {
            dte.setRettifica(rettDTE);
        }
        if (!(dic.getCodiceFiscale() == null || "".equals(dic.getCodiceFiscale()))) {
            header.setDichiarante(dic);
        }

        if (dte != null) {
            rootDTE.setDTE(dte);
        }

        rootDTE.setDatiFatturaHeader(header);
        rootDTE.setVersione(VersioneType.DAT_20);

        //contiene i dati per fatture emesse
        dte = xml.createDTEType();
        dteCed = xml.createCedentePrestatoreDTEType();

        idenFisCed = xml.createIdentificativiFiscaliITType();
        idFisCed = xml.createIdFiscaleITType();

        idenAltriCed = xml.createAltriDatiIdentificativiITType();

        indCedSede = xml.createIndirizzoType();
        indCedStabOrg = xml.createIndirizzoType();
        cedRappFis = xml.createRappresentanteFiscaleITType();
        idFisCedRappFis = xml.createIdFiscaleITType();

        dteCess = xml.createCessionarioCommittenteDTEType();

        idenFisCess = xml.createIdentificativiFiscaliNoIVAType();
        idFisCess = xml.createIdFiscaleType();

        idenAltriCess = xml.createAltriDatiIdentificativiType();

        indCessSede = xml.createIndirizzoType();
        indCessStabOrg = xml.createIndirizzoType();
        cessRappFis = xml.createRappresentanteFiscaleType();
        idFisCessRappFis = xml.createIdFiscaleType();

        datiFatBodyDTE = xml.createDatiFatturaBodyDTEType();

        datiGenDTE = xml.createDatiGeneraliDTEType();
        datiRiepilogoDTE = xml.createDatiRiepilogoType();

        datiIvaDTE = xml.createDatiIVAType();

        rettDTE = xml.createRettificaType();
        cessDTE = 0;
        bodyDTE = 0;
        riepDTE = 0;
    }

    private static void buildCedXml() throws JAXBException, FileNotFoundException {

        buildCessXml();

        if (!("".equals(idFisCed.getIdCodice()) || idFisCed.getIdCodice() == null)) {
            idenFisCed.setIdFiscaleIVA(idFisCed);
        }
        idenAltriCed.setSede(indCedSede);
        idenAltriCed.setStabileOrganizzazione(indCedStabOrg);
        if (!("".equals(idFisCedRappFis.getIdCodice()) || idFisCedRappFis.getIdCodice() == null)) {
            cedRappFis.setIdFiscaleIVA(idFisCedRappFis);
        }
        idenAltriCed.setRappresentanteFiscale(cedRappFis);

        dteCed.setAltriDatiIdentificativi(idenAltriCed);
        dteCed.setIdentificativiFiscali(idenFisCed);

        dte.setCedentePrestatoreDTE(dteCed);

        dteCed = xml.createCedentePrestatoreDTEType();

        idenFisCed = xml.createIdentificativiFiscaliITType();
        idFisCed = xml.createIdFiscaleITType();

        idenAltriCed = xml.createAltriDatiIdentificativiITType();

        indCedSede = xml.createIndirizzoType();
        indCedStabOrg = xml.createIndirizzoType();
        cedRappFis = xml.createRappresentanteFiscaleITType();
        idFisCedRappFis = xml.createIdFiscaleITType();

    }

    private static void buildCessXml() throws JAXBException, FileNotFoundException {

        cessDTE++;
        if (cessDTE == 1000) {
            System.out.println("max cess DTE");
            buildDTEXml();
        }

        buildFatturaBodyDTEXml();

        if (!("".equals(idFisCess.getIdCodice()) || idFisCess.getIdCodice() == null)) {
            idenFisCess.setIdFiscaleIVA(idFisCess);
        }
        idenAltriCess.setSede(indCessSede);
        idenAltriCess.setStabileOrganizzazione(indCessStabOrg);
        if (!("".equals(idFisCessRappFis.getIdCodice()) || idFisCessRappFis.getIdCodice() == null)) {
            cessRappFis.setIdFiscaleIVA(idFisCessRappFis);
        }
        idenAltriCess.setRappresentanteFiscale(cessRappFis);

        dteCess.setAltriDatiIdentificativi(idenAltriCess);
        dteCess.setIdentificativiFiscali(idenFisCess);
        //dteCess.getDatiFatturaBodyDTE().add(datiFatBodyDTE);

        dte.getCessionarioCommittenteDTE().add(dteCess);

        dteCess = xml.createCessionarioCommittenteDTEType();

        idenFisCess = xml.createIdentificativiFiscaliNoIVAType();
        idFisCess = xml.createIdFiscaleType();

        idenAltriCess = xml.createAltriDatiIdentificativiType();

        indCessSede = xml.createIndirizzoType();
        indCessStabOrg = xml.createIndirizzoType();
        cessRappFis = xml.createRappresentanteFiscaleType();
        idFisCessRappFis = xml.createIdFiscaleType();
        bodyDTE = 0;
        riepDTE = 0;

    }

    private static void buildFatturaBodyDTEXml() throws JAXBException, FileNotFoundException {

        bodyDTE++;
        if (bodyDTE == 1000) {
            System.out.println("max body DTE");
            buildCessXml();
        }

        buildFatturaRiepDTEXml();

        datiFatBodyDTE.setDatiGenerali(datiGenDTE);
        dteCess.getDatiFatturaBodyDTE().add(datiFatBodyDTE);

        datiFatBodyDTE = xml.createDatiFatturaBodyDTEType();
        datiGenDTE = xml.createDatiGeneraliDTEType();
        datiIvaDTE = xml.createDatiIVAType();
        riepDTE = 0;
    }

    private static void buildFatturaRiepDTEXml() throws JAXBException, FileNotFoundException {

        riepDTE++;
        if (riepDTE == 1000) {
            System.out.println("max riep DTE");
            buildFatturaBodyDTEXml();
        }

        datiRiepilogoDTE.setDatiIVA(datiIvaDTE);
        datiFatBodyDTE.getDatiRiepilogo().add(datiRiepilogoDTE);

        datiRiepilogoDTE = xml.createDatiRiepilogoType();
        datiIvaDTE = xml.createDatiIVAType();

    }

    private static void buildDTRXml() throws JAXBException, FileNotFoundException {

        buildCessDTRXml();

        if (!(rettDTR.getIdFile() == null || "".equals(rettDTR.getIdFile()))) {
            dtr.setRettifica(rettDTR);
        }
        if (!(dic.getCodiceFiscale() == null || "".equals(dic.getCodiceFiscale()))) {
            header.setDichiarante(dic);
        }

        if (dtr != null) {
            rootDTR.setDTR(dtr);
        }

        rootDTR.setDatiFatturaHeader(header);
        rootDTR.setVersione(VersioneType.DAT_20);
        //contiene i dati per fatture emesse
        dtr = xml.createDTRType();
        dtrCed = xml.createCedentePrestatoreDTRType();

        idenFisCedDTR = xml.createIdentificativiFiscaliType();
        idFisCedDTR = xml.createIdFiscaleType();

        idenAltriCedDTR = xml.createAltriDatiIdentificativiType();

        indCedSedeDTR = xml.createIndirizzoType();
        indCedStabOrgDTR = xml.createIndirizzoType();
        cedRappFisDTR = xml.createRappresentanteFiscaleType();
        idFisCedRappFisDTR = xml.createIdFiscaleType();

        dtrCess = xml.createCessionarioCommittenteDTRType();

        idenFisCessDTR = xml.createIdentificativiFiscaliITType();
        idFisCessDTR = xml.createIdFiscaleITType();

        idenAltriCessDTR = xml.createAltriDatiIdentificativiITType();

        indCessSedeDTR = xml.createIndirizzoType();
        indCessStabOrgDTR = xml.createIndirizzoType();
        cessRappFisDTR = xml.createRappresentanteFiscaleITType();
        idFisCessRappFisDTR = xml.createIdFiscaleITType();

        datiFatBodyDTR = xml.createDatiFatturaBodyDTRType();

        datiGenDTR = xml.createDatiGeneraliDTRType();
        datiRiepilogoDTR = xml.createDatiRiepilogoType();

        datiIvaDTR = xml.createDatiIVAType();

        rettDTR = xml.createRettificaType();
        cedDTR = 0;
        bodyDTR = 0;
        riepDTR = 0;
    }

    private static void buildCessDTRXml() throws JAXBException, FileNotFoundException {

        buildCedDTRXml();

        if (!("".equals(idFisCessDTR.getIdCodice()) || idFisCessDTR.getIdCodice() == null)) {
            idenFisCessDTR.setIdFiscaleIVA(idFisCessDTR);
        }
        idenAltriCessDTR.setSede(indCessSedeDTR);
        idenAltriCessDTR.setStabileOrganizzazione(indCessStabOrgDTR);
        if (!("".equals(idFisCessRappFisDTR.getIdCodice()) || idFisCessRappFisDTR.getIdCodice() == null)) {
            cessRappFisDTR.setIdFiscaleIVA(idFisCessRappFisDTR);
        }
        idenAltriCessDTR.setRappresentanteFiscale(cessRappFisDTR);

        dtrCess.setAltriDatiIdentificativi(idenAltriCessDTR);
        dtrCess.setIdentificativiFiscali(idenFisCessDTR);

        dtr.setCessionarioCommittenteDTR(dtrCess);

        dteCess = xml.createCessionarioCommittenteDTEType();

        idenFisCessDTR = xml.createIdentificativiFiscaliITType();
        idFisCessDTR = xml.createIdFiscaleITType();

        idenAltriCessDTR = xml.createAltriDatiIdentificativiITType();

        indCessSedeDTR = xml.createIndirizzoType();
        indCessStabOrgDTR = xml.createIndirizzoType();
        cessRappFisDTR = xml.createRappresentanteFiscaleITType();
        idFisCessRappFisDTR = xml.createIdFiscaleITType();

    }

    private static void buildCedDTRXml() throws JAXBException, FileNotFoundException {

        cedDTR++;
        if (cedDTR == 1000) {
            System.out.println("max ced DTR");
            buildDTRXml();
        }

        buildFatturaBodyDTRXml();

        if (!("".equals(idFisCedDTR.getIdCodice()) || idFisCedDTR.getIdCodice() == null)) {
            idenFisCedDTR.setIdFiscaleIVA(idFisCedDTR);
        }
        idenAltriCedDTR.setSede(indCedSedeDTR);
        idenAltriCedDTR.setStabileOrganizzazione(indCedStabOrgDTR);
        if (!("".equals(idFisCedRappFisDTR.getIdCodice()) || idFisCedRappFisDTR.getIdCodice() == null)) {
            cedRappFisDTR.setIdFiscaleIVA(idFisCedRappFisDTR);
        }
        idenAltriCedDTR.setRappresentanteFiscale(cedRappFisDTR);

        dtrCed.setAltriDatiIdentificativi(idenAltriCedDTR);
        dtrCed.setIdentificativiFiscali(idenFisCedDTR);

        dtr.getCedentePrestatoreDTR().add(dtrCed);

        dtrCed = xml.createCedentePrestatoreDTRType();

        idenFisCedDTR = xml.createIdentificativiFiscaliType();
        idFisCedDTR = xml.createIdFiscaleType();

        idenAltriCedDTR = xml.createAltriDatiIdentificativiType();

        indCedSedeDTR = xml.createIndirizzoType();
        indCedStabOrgDTR = xml.createIndirizzoType();
        cedRappFisDTR = xml.createRappresentanteFiscaleType();
        idFisCedRappFisDTR = xml.createIdFiscaleType();
        bodyDTR = 0;
        riepDTR = 0;

    }

    private static void buildFatturaBodyDTRXml() throws JAXBException, FileNotFoundException {

        bodyDTR++;
        if (bodyDTR == 1000) {
            System.out.println("max body DTR");
            buildCedDTRXml();
        }

        buildFatturaRiepDTRXml();

        datiFatBodyDTR.setDatiGenerali(datiGenDTR);
        dtrCed.getDatiFatturaBodyDTR().add(datiFatBodyDTR);
        datiFatBodyDTR = xml.createDatiFatturaBodyDTRType();
        datiGenDTR = xml.createDatiGeneraliDTRType();
        datiIvaDTR = xml.createDatiIVAType();
        riepDTR = 0;
    }

    private static void buildFatturaRiepDTRXml() throws JAXBException, FileNotFoundException {

        riepDTR++;
        if (riepDTR == 1000) {
            System.out.println("max riep DTR");
            buildFatturaBodyDTRXml();
        }

        datiRiepilogoDTR.setDatiIVA(datiIvaDTR);
        datiFatBodyDTR.getDatiRiepilogo().add(datiRiepilogoDTR);

        datiRiepilogoDTR = xml.createDatiRiepilogoType();

        datiIvaDTR = xml.createDatiIVAType();
    }

    private static XMLGregorianCalendar getXMLGregorianCalendar(String date) throws ParseException, DatatypeConfigurationException {
        Date dob;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("inviodatiae.createXML.getXMLGregorianCalendar() >> string " + date);
        dob = df.parse(date);
        GregorianCalendar cal = new GregorianCalendar();

        System.out.println("inviodatiae.createXML.getXMLGregorianCalendar() >> date " + dob.toString());
        cal.setTime(dob);
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        xmlDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        System.out.println("inviodatiae.createXML.getXMLGregorianCalendar() >> xmldate " + xmlDate.toXMLFormat());
        //XMLGregorianCalendar xmlDate3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(), dob.getMinutes(), dob.getSeconds(), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        return xmlDate;
    }
}

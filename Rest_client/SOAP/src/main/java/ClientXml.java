
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import resume.*;

import javax.swing.*;
import javax.swing.text.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.ScrollPaneConstants.*;


public class ClientXml {

    private Service service;
    private JAXBContext jc;
    private static final QName qname = new QName("", "");

    private static final int FRAME_WIDTH = 420;
    private static final int FRAME_HEIGHT = 600;

    //private static final String url ="http://localhost:8080/SpringMVC/rest/resume/";
    private static final String url ="http://lw2xml-m1gil15.rhcloud.com/SpringMVC/rest/resume/";
    private JFrame frame;
    private JTextPane text;
    private JScrollPane scroll;


    private JButton View;
    private JButton Addcv;
    private JButton Valide;
    private JTextField Idres;

    private JButton Ajoutlang;

    private JButton Ajoutexp;
   

    private JButton aj;
    private JButton Home;

    private JTextField nom;
    private JTextField prenom;
    private JTextField Adresse;


    private List<JTextField> languages;
    private List<JTextField> experiences;


    public ClientXml() {
        try {
            jc = JAXBContext.newInstance(Experience.class, Language.class, Resume.class, ListeExperience.class,ListeLangue.class,ListeResume.class
            );
        } catch (JAXBException je) {
            System.out.println("Cannot create JAXBContext " + je);
        }
        BuildView();
        placeComponents();
        Controler();
    }

    private void BuildView() {

        frame = new JFrame("Bibliotheque des  CV");
        frame.setBackground(Color.GRAY);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        text = new JTextPane();
        text.setEditable(false);

        scroll = new JScrollPane();
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

     java.net.URL url1 = getClass().getResource("bouton_voir_cv.png");
     ImageIcon i1 = new ImageIcon(url1);
        View = new JButton(i1);
      View.setBackground(Color.GRAY);
        View.setForeground(Color.GRAY);
        View.setBorder(null);
        java.net.URL url2 = getClass().getResource("bouton_ajoute_cv.png");
        ImageIcon i2 = new ImageIcon(url2);
        Addcv = new JButton(i2);
       Addcv.setBackground(Color.GRAY);
       Addcv.setForeground(Color.GRAY);
        Addcv.setBorder(null);

        java.net.URL ok = getClass().getResource("recherce.png");
        ImageIcon iconOK = new ImageIcon(ok);
        Valide = new JButton(iconOK);
       Valide.setBackground(Color.GRAY);
        Valide.setForeground(Color.GRAY);
        Valide.setBorder(null);

        text.setBackground(Color.GRAY);
        text.setForeground(Color.WHITE);

        Idres = new JTextField(2);

        nom = new JTextField();
        prenom = new JTextField();
        Adresse = new JTextField();

        java.net.URL plus = getClass().getResource("plus.png");
        ImageIcon iconPlus = new ImageIcon(plus);


        Ajoutlang = new JButton(iconPlus);
        
        Ajoutexp = new JButton(iconPlus);


        Ajoutlang.setForeground(Color.GRAY);
        Ajoutlang.setBackground(Color.GRAY);
        Ajoutlang.setBorder(null);

        Ajoutexp.setForeground(Color.GRAY);
        Ajoutexp.setBackground(Color.GRAY);
        Ajoutexp.setBorder(null);



        languages = new ArrayList<JTextField>();
        languages.add(new JTextField(""));
        languages.add(new JTextField(""));

        

        experiences = new ArrayList<JTextField>();
        experiences.add(new JTextField(""));
        experiences.add(new JTextField(""));
        experiences.add(new JTextField(""));



        java.net.URL ajouter = getClass().getResource("ajout1.png");
        ImageIcon iconAjouter = new ImageIcon(ajouter);

        aj = new JButton(iconAjouter);
       aj.setForeground(Color.GRAY);
        aj.setBackground(Color.GRAY);
        aj.setBorder(null);

     java.net.URL a = getClass().getResource("accueil1.png");
        ImageIcon iconHome = new ImageIcon(a);

        Home = new JButton(iconHome);
        Home.setForeground(Color.GRAY);
        Home.setBackground(Color.GRAY);
        Home.setBorder(null);
    }

    private void placeComponents() {

        JPanel panel1 = new JPanel(new GridLayout(0, 1)); {
           
           panel1.setBackground(Color.GRAY);
            JPanel p2 = new JPanel();

            p2.add(View, BorderLayout.CENTER);

           p2.setBackground(Color.GRAY);
            panel1.add(p2);
            JPanel p3 = new JPanel();
            p3.setBackground(Color.GRAY);
            p3.add(Addcv, BorderLayout.CENTER);
            panel1.add(p3);

        }
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(scroll, BorderLayout.CENTER);
        scroll.getViewport().add(panel1);
    }
    private void AllView() {

        JPanel panel = new JPanel(new BorderLayout()); {
            JPanel panel2 = new JPanel(new BorderLayout()); {
              
                panel2.setBackground(Color.GRAY);

                JPanel panel3 = new JPanel(new BorderLayout()); {
                    java.net.URL imgAfficher = getClass().getResource("afficher.png");
                    ImageIcon icon2 = new ImageIcon(imgAfficher);
                    JLabel afficher = new JLabel(icon2, JLabel.CENTER);
                    panel3.setBackground(Color.GRAY);
                    panel3.add(afficher, BorderLayout.WEST);

                    JPanel panel4 = new JPanel(new FlowLayout()); {
                        panel4.add(Idres);
                        panel4.setBackground(Color.GRAY);
                    }
                    panel3.add(panel4);

                    panel3.add(Valide, BorderLayout.EAST);
                }
                panel2.add(panel3, BorderLayout.SOUTH);
            }
            panel.add(panel2, BorderLayout.NORTH);
            panel.setBackground(Color.GRAY);

            panel.add(text, BorderLayout.CENTER);
            panel.add(Home, BorderLayout.SOUTH);
            Home.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.add(scroll, BorderLayout.CENTER);
        scroll.getViewport().add(panel);
    }

    private void AddView() {

        JPanel panel = new JPanel(new BorderLayout()); {
            JPanel panel2 = new JPanel(new BorderLayout()); {
              
                panel2.setBackground(Color.GRAY);

                JPanel panel3 = new JPanel(new GridLayout(0, 2));  {
                    panel3.add(new JLabel("Nom"));
                    panel3.add(nom);

                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));

                    panel3.add(new JLabel("Prenom"));
                    panel3.add(prenom);

                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));

                    panel3.add(new JLabel("Adresse"));
                    panel3.add(Adresse);

                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));

                    

                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));


                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));

                    panel3.add(new JLabel("Experience"));
                    panel3.add(Ajoutexp);
                    Ajoutexp.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                  int   j = 0;
                    for (int i = 0; i < experiences.size(); i++) {
                        JLabel nom = new JLabel("Nom");
                        JLabel description = new JLabel("Description");
                        JLabel annee = new JLabel("Année");

                        if (j%3 == 0) {
                            nom.setForeground(new Color(190, 51, 51));
                            description.setForeground(new Color(190, 51, 51));
                            annee.setForeground(new Color(190, 51, 51));
                        } else if (j%3 == 1) {
                            nom.setForeground(new Color(149, 193, 29));
                            description.setForeground(new Color(149, 193, 29));
                            annee.setForeground(new Color(149, 193, 29));
                        } else {
                            nom.setForeground(new Color(29, 173, 193));
                            description.setForeground(new Color(29, 173, 193));
                            annee.setForeground(new Color(29, 173, 193));
                        }

                        panel3.add(nom);
                        panel3.add(experiences.get(i));
                        i++;
                        panel3.add(description);
                        panel3.add(experiences.get(i));
                        i++;
                        panel3.add(annee);
                        panel3.add(experiences.get(i));
                        j++;
                    }

                  
                    panel3.add(new JLabel("Langues"));
                    panel3.add(Ajoutlang);
                    Ajoutlang.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                    j = 0;
                    for (int i = 0; i < languages.size(); i++) {
                        JLabel nom = new JLabel("Nom");
                        JLabel niveau = new JLabel("Niveau");

                        if (j%3 == 0) {
                            nom.setForeground(new Color(190, 51, 51));
                            niveau.setForeground(new Color(190, 51, 51));
                        } else if (j%3 == 1) {
                            nom.setForeground(new Color(149, 193, 29));
                            niveau.setForeground(new Color(149, 193, 29));
                        } else {
                            nom.setForeground(new Color(29, 173, 193));
                            niveau.setForeground(new Color(29, 173, 193));
                        }

                        panel3.add(nom);
                        panel3.add(languages.get(i));
                        i++;
                        panel3.add(niveau);
                        panel3.add(languages.get(i));
                        j++;
                    }

                    panel3.add(new JLabel(""));
                    panel3.add(new JLabel(""));


                    panel3.setBackground(Color.GRAY);
                    panel3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                }
                panel2.add(panel3, BorderLayout.SOUTH);
            }
            panel.add(panel2, BorderLayout.NORTH);
            panel.setBackground(Color.GRAY);

            panel.add(text, BorderLayout.CENTER);

            JPanel buttons = new JPanel(new GridLayout(0, 2)); {
                buttons.add(aj);
                buttons.add(Home);
                aj.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            }
            panel.add(buttons, BorderLayout.SOUTH);

        }
        scroll.getViewport().add(panel);
    }

    private void Controler() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeComponents();
            }
        });

        View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllView();
                try {
                    GetResum();
                } catch (Exception e1) {

                }
            }
        });

        Addcv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               AddView();
                try {
                    
                } catch (Exception e1) {

                }
            }
        });

        Valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllView();
                int id = 1;
                if (Idres.getText().equals("")) {
                    try {
                        GetResum();
                    } catch (Exception e1) {

                    }
                    return;
                }
                try {
                    id = Integer.valueOf(Idres.getText());
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(frame, "L'id est incorrecte !");
                    return;
                }

                if (id <= 0) {
                    JOptionPane.showMessageDialog(frame, "L'id doit > à 0!");
                    return;
                }
                try {
                    GetResumeId(id);
                } catch (Exception e1) {
                    return;
                }
            }
        });



        Ajoutlang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                languages.add(new JTextField());
                languages.add(new JTextField());
                AddView();
            }
        });

        Ajoutexp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                experiences.add(new JTextField());
                experiences.add(new JTextField());
                experiences.add(new JTextField());
                AddView();
            }
        });

        aj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;
                try {
                    b = Ajoutcv();
                } catch (JAXBException jaxbe) {
                    //
                }
                if (b == true) {
                    placeComponents();

                    languages = new ArrayList<JTextField>();
                    languages.add(new JTextField(""));
                    languages.add(new JTextField(""));


                    experiences = new ArrayList<JTextField>();
                    experiences.add(new JTextField(""));
                    experiences.add(new JTextField(""));
                    experiences.add(new JTextField(""));


                }
            }
        });
    }
    private void GetResum() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
        }

        try {
            Document document = builder.parse(url);
            document.getDocumentElement().normalize();
            text.setText("");
            ShowListCv(document);
        } catch (Exception e) {
        }
        text.setCaretPosition(0);
    }

    private void GetResumeId(int id) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {

        }

        try {
            Document document = null;
            try {
                document = builder.parse(url + "/" + id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Ce cv est introuvable !");
                document = null;
            }
            document.getDocumentElement().normalize();
            text.setText("");
            ShowListCv(document);
        } catch (Exception e) {
        }
        text.setCaretPosition(0);
    }

    private void ShowListCv(Document document) throws BadLocationException {

        NodeList l = document.getElementsByTagName("resume");

        StyledDocument doc = (StyledDocument) text.getDocument();

        // Style pour les catégories
        Style category = text.addStyle("Categorie", null);
        StyleConstants.setForeground(category, new Color(190, 51, 51));
        StyleConstants.setAlignment(category, StyleConstants.ALIGN_CENTER);

        // Style pour les sous catégories
        Style sousCategory = text.addStyle("Sous categorie", null);
        StyleConstants.setForeground(sousCategory, new Color(149, 193, 29));
        StyleConstants.setAlignment(sousCategory, StyleConstants.ALIGN_CENTER);

        // Style pour les sous catégories
        Style text1 = text.addStyle("Text", null);
        StyleConstants.setForeground(text1, new Color(29, 173, 193));
        StyleConstants.setAlignment(text1, StyleConstants.ALIGN_CENTER);

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        //
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);

        for (int i = 0; i < l.getLength(); i++) {

            //doc.insertString(doc.getLength(), "_________________CV "+nodeList.item(2).getTextContent()+"_________________\n\n", sousCategory);

            NodeList nodeList = l.item(i).getChildNodes();

            doc.insertString(doc.getLength(), "____________________CV Numero: "+nodeList.item(2).getTextContent()+"_____________________\n\n", sousCategory);

            //doc.insertString(doc.getLength(), "#" + nodeList.item(2).getTextContent() + "\n", text);
            doc.insertString(doc.getLength(), "\nNOM \n", category);
            doc.insertString(doc.getLength(), nodeList.item(4).getTextContent() + "\n", text1);
            doc.insertString(doc.getLength(), "\nPRENOM \n", category);
            doc.insertString(doc.getLength(), nodeList.item(6).getTextContent() + "\n", text1);
            doc.insertString(doc.getLength(), "\nAdresse \n", category);
            doc.insertString(doc.getLength(), nodeList.item(5).getTextContent() + "\n", text1);

          
            NodeList exp = nodeList.item(0).getChildNodes();
            doc.insertString(doc.getLength(), "\nEXPERIENCE\n", category);
            for (int j = 0; j < exp.getLength(); j++) {
                doc.insertString(doc.getLength(), "\nDESCRIPTION ", sousCategory);
                doc.insertString(doc.getLength(), exp.item(j).getChildNodes().item(1).getTextContent() + "\n", text1);
                doc.insertString(doc.getLength(), "NOM ", sousCategory);
                doc.insertString(doc.getLength(), exp.item(j).getChildNodes().item(2).getTextContent() + "\n", text1);
                doc.insertString(doc.getLength(), "ANNEE ", sousCategory);
                doc.insertString(doc.getLength(), exp.item(j).getChildNodes().item(0).getTextContent() + "\n", text1);
            }
            
            NodeList lang = nodeList.item(3).getChildNodes();
            doc.insertString(doc.getLength(), "\nLANGUE\n", category);
            for (int j = 0; j < lang.getLength(); j++) {
                doc.insertString(doc.getLength(), "\nLANGUE ", sousCategory);
                doc.insertString(doc.getLength(), lang.item(j).getChildNodes().item(1).getTextContent() + "\n", text1);
                doc.insertString(doc.getLength(), "NIVEAU ", sousCategory);
                doc.insertString(doc.getLength(), lang.item(j).getChildNodes().item(0).getTextContent() + "\n", text1);

            }


        }
    }
    private boolean Ajoutcv() throws JAXBException {
        service = Service.create(qname);
        service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname,
                Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "POST");

        boolean added = true;

        if (nom.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Le champ Nom doit être rempli !");
            return false;
        } else if (prenom.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Le champ Prénom doit être rempli !");
            return false;
        } else if (Adresse.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Le champ Adresse doit être rempli !");
            return false;
        } else if (experiences.get(0).getText().equals("") || experiences.get(1).getText().equals("") || experiences.get(2).getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Experience obligatoires !");
            return false;
        }  else if (languages.get(0).getText().equals("") || languages.get(1).getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "langues obligatoires !");
            return false;
        } else {
            Resume resume = new Resume();
            resume.setNom(nom.getText());
            resume.setPrenom(prenom.getText());
            resume.setAdresse(Adresse.getText());

            ListeLangue lm = new ListeLangue();
            for (int i = 0; i < languages.size(); i++) {
                String name = languages.get(i).getText(); i++;
                String level = languages.get(i).getText();
                if (!name.equals("") && !level.equals("")) {
                    Language lang = new Language(name, level);
                    lm.addLangue(lang);
                } else if (name.equals("") && level.equals("")) {
                } else {
                    JOptionPane.showMessageDialog(frame, "Les 2 champs des langues sont obligatoires !");
                    added = false;
                    return false;
                }
            }
            resume.setLangue(lm);


            ListeExperience em = new ListeExperience();
            for (int i = 0; i < experiences.size(); i++) {
                String name = experiences.get(i).getText(); i++;
                String description = experiences.get(i).getText(); i++;
                String year = experiences.get(i).getText();
                if (!name.equals("") && !description.equals("") && !year.equals("")) {
                    Experience ex = new Experience(name, description, year);
                    em.addExperience(ex);
                } else if (name.equals("") && description.equals("") && year.equals("")) {
                } else {
                    JOptionPane.showMessageDialog(frame, "Les 3 champs des expériences sont obligatoires !");
                    added = false;
                    return false;
                }
            }
            resume.setExperience(em);

            try {
                dispatcher.invoke(new JAXBSource(jc, resume));
            } catch (Exception e) {
                //
            }
            if (added == true) {
                JOptionPane.showMessageDialog(frame, "CV ajouté avec succes!");


                languages = new ArrayList<JTextField>();
                languages.add(new JTextField(""));
                languages.add(new JTextField(""));


                experiences = new ArrayList<JTextField>();
                experiences.add(new JTextField(""));
                experiences.add(new JTextField(""));
                experiences.add(new JTextField(""));


            }
            return true;
        }
    }

    public void Show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClientXml().Show();
            }
        });
    }
}

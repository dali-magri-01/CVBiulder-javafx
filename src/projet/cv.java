/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner; 
public class cv {
    int idcv;
    String tel;
    String Email;
    String linkedin;
    String localisation;
    String fcb;
    String description;
    String statut;
    HashMap<String, Date> parcoursAcademique;
    HashMap<String, String> experienceProf;
    HashMap<String, String> projetAcademique;
    LinkedList<String> competencesTechniques;
    LinkedList<String> competencesPersonnelles;
    LinkedList<String> certificats;
    LinkedList<String> vieAssociative;

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setFcb(String fcb) {
        this.fcb = fcb;
    }
    
    
    public cv(int i,String desc, String stat){
      this.idcv=i;
      this.description=desc;
      this.statut=stat;
    }

    public cv() {
    }

    public void setIdcv(int idcv) {
        this.idcv = idcv;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    public void ajouterCompetenceTech(){
        String bool="oui";
        do{
        Scanner a = new Scanner(System.in);
        System.out.println("donner vos competences techniques");
        String comp = a.nextLine();
        competencesTechniques.add(comp);
        System.out.println("si tu veux ajouter d'autre competences tapez oui");
        bool=a.nextLine();
        }
        while(bool=="oui");
    }
    public void ajouterCompetencePers(){
        String bool="oui";
        do{
        Scanner a = new Scanner(System.in);
        System.out.println("donner vos competences personnelles");
        String comp = a.nextLine();
        competencesTechniques.add(comp);
        System.out.println("si tu veux ajouter d'autre competences tapez oui");
       bool=a.nextLine();
        }
        while(bool=="oui");
    }
     public void ajouterCertificats(){
        String bool="oui";
        do{
        Scanner a = new Scanner(System.in);
        System.out.println("ajouter certificat");
        String comp = a.nextLine();
        certificats.add(comp);
        System.out.println("si tu veux ajouter d'autre certificats tapez oui");
        bool=a.nextLine();
        }
        while(bool=="oui");
    }
     public void ajouterVieAssociative(){
        String bool="oui";
        do{
        Scanner a = new Scanner(System.in);
        System.out.println("ajouter les clubs dont lesquelles tu as ete un membre actif");
        String comp = a.nextLine();
        competencesTechniques.add(comp);
        System.out.println("si tu veux ajouter d'autre clubs taper oui");
        bool=a.nextLine();
        }
        while(bool=="oui");
    }
    public void ajouterExpProf(){
       String bool="oui";
       do{
        Scanner a = new Scanner(System.in);
        System.out.println("Donner le poste chargé ainsi que le nom de l'entreprise concernée");
        String key = a.nextLine();
        System.out.println("Donner une bref description de l'experience");
        String value = a.nextLine();
        experienceProf.put(key, value);
        System.out.println("si tu as plus d'experiences proffessionnelles taper oui");
        bool=a.nextLine();
        }
       while(bool=="oui");
    }
        public void ajouterParcours() throws ParseException{
       String bool="oui";
       do{
        Scanner a = new Scanner(System.in);
        System.out.println("Donner le nom de diplome que tu as eu");
        String key = a.nextLine();
        System.out.println("Donner la date d'obtention");
        String date = a.nextLine();
        Date value=new SimpleDateFormat("dd-MM-yyyy").parse(date);
        parcoursAcademique.put(key,value);
        System.out.println("si tu as plus d'experiences proffessionnelles taper oui");
        bool=a.nextLine();
        }
       while(bool=="oui");
    }
    public void ajouterProjAcademique(){
       String bool="oui";
       do{
        Scanner a = new Scanner(System.in);
        System.out.println("Donner le nom du projet");
        String key = a.nextLine();
        System.out.println("Donner une bref description du projet");
        String value = a.nextLine();
        projetAcademique.put(key, value);
        System.out.println("si tu as plus d'experiences proffessionnelles taper oui");
        bool=a.nextLine();
        }
       while(bool=="oui");
    }

    @Override
    public String toString() {
        return "cv{" + "idcv=" + idcv + ", tel=" + tel + ", Email=" + Email + ", linkedin=" + linkedin + ", localisation=" + localisation + ", fcb=" + fcb + ", description=" + description + ", statut=" + statut + ", vieAssociative=" + vieAssociative + '}';
    }
    
}

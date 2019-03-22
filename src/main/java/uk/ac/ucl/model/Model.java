package uk.ac.ucl.model;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model
{
  public ArrayList<Patient> patients = new ArrayList<>();
  private String[] fields = {"ID", "BIRTHDATE","DEATHDATE","SSN","DRIVERS","PASSPORT","PREFIX","FIRST","LAST","SUFFIX","MAIDEN","MARITAL","RACE","ETHNICITY","GENDER","BIRTHPLACE","ADDRESS","CITY","STATE","ZIP"};



  public void readFile(File file) throws IOException
  {
    BufferedReader fin = new BufferedReader(new FileReader(file));
    ArrayList<Patient> patients = new ArrayList<>();
    String[] titles = fin.readLine().split(",");
    while(fin.ready())
    {
      Patient thisPatient = new Patient();
      String thisString = fin.readLine();
      String[] splitedString = thisString.split(",");
      for (int i = 0; i < splitedString.length; i++)
      {
        thisPatient.set(titles[i], splitedString[i]);
      }
      patients.add(thisPatient);
    }
    this.patients = patients;
  }



  public Map<String, String> searchFor(Map<String, String> keywords)
  {
    Map<String, String> results = new LinkedHashMap<>();
    for (Patient patient : patients)
    {
      boolean isEqual = true;
      for (int i = 0; i < fields.length; i++)
      {
        if (!keywords.get(fields[i]).equals("") && patient.get(fields[i]).indexOf(keywords.get(fields[i])) == -1)
        {
          System.out.println(keywords.get(fields[i]));
          isEqual = false;
        }
      }
      if (isEqual == true)
      {
        results.put(patient.get("FIRST"), patient.get("LAST"));
      }
    }
    return results;
  }

  public Map<String, String> getPatientNames()
  {
    Map<String, String> names = new LinkedHashMap<>();
    for (int i = 0; i < patients.size(); i++)
    {
      names.put(patients.get(i).get("FIRST"), patients.get(i).get("LAST"));
    }
    return names;
  }

  public String[] getFields()
  {
    return fields;
  }

  public String[] getProperty(String first, String last)
  {
    for (Patient patient : patients)
    {
      if (patient.get("FIRST").equals(first) && patient.get("LAST").equals(last))
      {
        return patient.getValue();
      }
    }
    System.out.println(patients.get(0).get("LAST"));
    return null;
  }




  public Map<String, String> getFullname(String name)
  {
    Map<String, String> results = new LinkedHashMap<>();
    for (Patient patient : patients)
    {
      if (patient.get("FIRST").indexOf(name) != -1 ||  patient.get("LAST").indexOf(name) != -1)
      {
        results.put(patient.get("FIRST"), patient.get("LAST"));
      }
    }
    return results;
  }
}


